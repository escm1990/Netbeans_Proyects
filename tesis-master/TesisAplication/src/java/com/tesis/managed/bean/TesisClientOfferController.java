/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import com.tesis.controllers.TesisOfferJpaController;
import com.tesis.model.entity.TesisOffer;
import com.tesis.utils.FileDownload;
import com.tesis.utils.SaveAudit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luis.chavez
 */
@ManagedBean (name = "offer_client")
@SessionScoped
public class TesisClientOfferController {

    /**
     * Creates a new instance of TesisClientOfferController
     */
    
    TesisOfferJpaController offerImpl = new TesisOfferJpaController();
    private List<TesisOffer> list = new ArrayList<>();
    private TesisOffer item = new TesisOffer();
    private String criterio = "";
            
    public TesisClientOfferController() {
    }
    
     @PostConstruct
    public void init() {
        this.setList(offerImpl.findAllOffersOrder());
    }

    /**
     * @return the list
     */
    public List<TesisOffer> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<TesisOffer> list) {
        this.list = list;
    }

    /**
     * @return the item
     */
    public TesisOffer getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(TesisOffer item) {
        this.item = item;
    }
    
    public void downloadArchivo() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("/");

            if (item != null) {
                String savePath = "resources/" + item.getFkTesisSystemDocument().getDocumentUri() + item.getFkTesisSystemDocument().getDocumentDescription();
                path = path.replace("\\build", "");
                File file = new File(path + File.separator + savePath);

                String mimeType = servletContext.getMimeType(file.getAbsolutePath());
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }
                FileDownload.write(response, mimeType, file, facesContext);
                SaveAudit.logRegister("Oferta", item.getOfferArea());
                SaveAudit.logRegister("Oferta", "descarga");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String oferta() {
        this.setList(offerImpl.findAllOffersOrder());
        return "resources/templates/clients/ofertaClients.xhtml";
    }

    public String submit() {
        SaveAudit.logRegister("Oferta", "visita");
        return "detail_offer?faces-redirect=true";
    }

    public String regresar() {
        return "ofertaClients?faces-redirect=true";
    }

    /**
     * @return the criterio
     */
    public String getCriterio() {
        return criterio;
    }

    /**
     * @param criterio the criterio to set
     */
    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }
    
     
    public void busqueda() {
        try {
            if (criterio.isEmpty() == true) {
               this.list = offerImpl.findAllOffersOrder();
               criterio = "";
            } else {
                 this.list = offerImpl.findAllOfferByCriteria(criterio);
                 criterio = "";
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
