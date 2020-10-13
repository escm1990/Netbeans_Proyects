/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.managed.bean;

import com.tesis.controllers.TesisCultureJpaController;
import com.tesis.model.entity.TesisCulture;
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
@ManagedBean(name = "cul_client")
@SessionScoped
public class TesisClientCultureController {

    /**
     * Creates a new instance of TesisClientCultureController
     */
    TesisCultureJpaController cultureImpl = new TesisCultureJpaController();
    private List<TesisCulture> list = new ArrayList<>();
    private TesisCulture item = new TesisCulture();
    private String criterio = "";

    public TesisClientCultureController() {
    }

    @PostConstruct
    public void init() {
        this.list = cultureImpl.findAllCultureOrder();
    }

    /**
     * @return the list
     */
    public List<TesisCulture> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<TesisCulture> list) {
        this.list = list;
    }

    /**
     * @return the item
     */
    public TesisCulture getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(TesisCulture item) {
        this.item = item;
    }

    public String cultura() {
        this.list = cultureImpl.findAllCultureOrder();
        return "resources/templates/clients/culturaClients.xhtml";
    }

    public String submit() {
        SaveAudit.logRegister("Cultura", "visita");
        return "detail_cul?faces-redirect=true";
    }

    public String regresar() {
        return "culturaClients?faces-redirect=true";
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
                this.list = cultureImpl.findAllCultureOrder();
                criterio = "";
            } else {
                this.list = cultureImpl.findAllPlanByCriteria(criterio);
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
                String savePath = "resources/" + item.getFkSystemDocument().getDocumentUri() + item.getFkSystemDocument().getDocumentDescription();
                path = path.replace("\\build", "");
                File file = new File(path + File.separator + savePath);

                String mimeType = servletContext.getMimeType(file.getAbsolutePath());
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }
                FileDownload.write(response, mimeType, file, facesContext);
                SaveAudit.logRegister("Cultura", "descarga");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
