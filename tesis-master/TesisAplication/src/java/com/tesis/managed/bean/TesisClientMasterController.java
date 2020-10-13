/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import com.tesis.controllers.TesisMastersJpaController;
import com.tesis.model.entity.TesisMasters;
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
 * @author escm.1990
 */
@ManagedBean (name = "mas_client")
@SessionScoped
public class TesisClientMasterController {

    /**
     * Creates a new instance of TesisClientCultureController
     */
    TesisMastersJpaController masImpl = new TesisMastersJpaController();
    private List<TesisMasters> list = new ArrayList<>();
    private TesisMasters item = new TesisMasters();
    private String criterio = "";
    
    
    public TesisClientMasterController() {
    }

    @PostConstruct
    public void init() {
        this.list = masImpl.findAllMasterOrder();
    }
    /**
     * @return the list
     */
    public List<TesisMasters> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<TesisMasters> list) {
        this.list = list;
    }

    /**
     * @return the item
     */
    public TesisMasters getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(TesisMasters item) {
        this.item = item;
    }
  
    public String maestria() {
        this.list = masImpl.findAllMasterOrder();        
        return "resources/templates/clients/maestriasClients.xhtml";
    }

    public String submit() {
        SaveAudit.logRegister("Maestrias", "visita");
        return "detail_mas?faces-redirect=true";
    }
    
    public String regresar() {
        return "maestriasClients?faces-redirect=true";
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
               this.list = masImpl.findAllMasterOrder();
               criterio = "";
            } else {
                 this.list = masImpl.findAllMasterByCriteria(criterio);
                 criterio = "";
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
                SaveAudit.logRegister("Maestrias", "descarga");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
