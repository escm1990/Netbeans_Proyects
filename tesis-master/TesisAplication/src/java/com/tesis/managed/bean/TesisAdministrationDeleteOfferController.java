/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import com.tesis.controllers.TesisOfferJpaController;
import com.tesis.controllers.TesisSystemDocumentJpaController;
import com.tesis.controllers.TesisSystemImageJpaController;
import com.tesis.model.entity.TesisOffer;
import com.tesis.model.entity.TesisSystemDocument;
import com.tesis.model.entity.TesisSystemImage;
import com.tesis.utils.FileDownload;
import com.tesis.utils.SaveLogs;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luis.chavez
 */
@ManagedBean (name = "delete_offer")
@ViewScoped
public class TesisAdministrationDeleteOfferController {

    /**
     * Creates a new instance of TesisAdministrationDeleteOfferController
     */
    TesisSystemDocumentJpaController docImpl = new TesisSystemDocumentJpaController();
    TesisOfferJpaController offerImpl = new TesisOfferJpaController();
    TesisSystemImageJpaController imgImpl = new TesisSystemImageJpaController();
    private TesisOffer offer_select = new TesisOffer();
    private List<TesisOffer> list = new ArrayList<>();

    public TesisAdministrationDeleteOfferController() {
    }

    @PostConstruct
    public void init() {
        this.setList(offerImpl.findAllOffers());
    }

    /**
     * @return the offer_select
     */
    public TesisOffer getOffer_select() {
        return offer_select;
    }

    /**
     * @param offer_select the offer_select to set
     */
    public void setOffer_select(TesisOffer offer_select) {
        this.offer_select = offer_select;
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
    
    public void downloadArchivo() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("/");

            if (offer_select != null) {
                String savePath = "resources/" + offer_select.getFkTesisSystemDocument().getDocumentUri() + offer_select.getFkTesisSystemDocument().getDocumentDescription();
                path = path.replace("\\build", "");
                File file = new File(path + File.separator + savePath);

                String mimeType = servletContext.getMimeType(file.getAbsolutePath());
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }
                FileDownload.write(response, mimeType, file,facesContext);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void delete_file_system_document(TesisSystemDocument doc, String path) {
        try {
            docImpl.destroy(doc.getCodTesisSystemDocument());
            path = path.replace("\\build", "");
            String dir = path + "/resources/" + doc.getDocumentUri() + doc.getDocumentDescription();
            File archivo = new File(dir);
            archivo.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete_file_system_image(TesisSystemImage image, String path) {
        try {
            imgImpl.destroy(image.getCodTesisSystemImages());
            path = path.replace("\\build", "");
            String dir = path + "/resources/" + image.getImageUri() + image.getImageDescription();
            File archivo = new File(dir);
            archivo.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            String path = servletContext.getRealPath("");
            if (this.offer_select != null) {
                TesisSystemDocument doc = this.offer_select.getFkTesisSystemDocument();
                TesisSystemImage image = this.offer_select.getFkTesisSystemImage();
                offerImpl.destroy(this.offer_select.getCodTesisOffer());
                delete_file_system_image(image, path);
                delete_file_system_document(doc, path);
                list = offerImpl.findAllOffers();
                SaveLogs.logRegister("DELETE OFFER", "Eliminación de Oferta Académica: "+ offer_select.getOfferName(), request.getSession().getAttribute("user").toString());
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            SaveLogs.logRegister("DELETE OFFER", "Error de Eliminación","system");
        }
        addMessage("oferta académica eliminada con éxito!!");
    }

    
    
}
