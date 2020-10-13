/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import com.tesis.controllers.TesisInfrastructureJpaController;
import com.tesis.model.entity.TesisInfrastructure;
import com.tesis.utils.FileDownload;
import com.tesis.utils.SaveAudit;
import java.io.File;
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
 * @author Luis Chávez
 */
@ManagedBean (name = "infra_client")
@SessionScoped
public class TesisClientInfraestructureController {

    /**
     * Creates a new instance of TesisClientInfraestructureController
     */
    TesisInfrastructureJpaController infraImpl = new TesisInfrastructureJpaController();
    private TesisInfrastructure item = new TesisInfrastructure();
    private List<TesisInfrastructure> lista;
    private String criterio = "";
    
    public TesisClientInfraestructureController() {
    }
    
    @PostConstruct
    public void init() {
       this.lista = infraImpl.findAllInfraOrder();
    }

    /**
     * @return the lista
     */
    public List<TesisInfrastructure> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<TesisInfrastructure> lista) {
        this.lista = lista;
    }

    /**
     * @return the select
     */
    public TesisInfrastructure getSelect() {
        return item;
    }

    /**
     * @param select the select to set
     */
    public void setSelect(TesisInfrastructure select) {
        this.item = select;
    }

    public String submit() {
        SaveAudit.logRegister("Infraestructura", "visita");
        return "detail_infra?faces-redirect=true";
    }
    
    public String regresar() {
        return "infraestructuraClients?faces-redirect=true";
    }
    
    public String infraestructura() {
        this.lista = infraImpl.findAllInfraOrder();
        return "resources/templates/clients/infraestructuraClients.xhtml";
    }
    
    public void busqueda() {
        try {
            if (criterio.isEmpty() == true) {
               this.lista = infraImpl.findAllInfraOrder();
               criterio = "";
            } else {
                 this.lista = infraImpl.findAllInfraByCriteria(criterio);
                 criterio = "";
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
                SaveAudit.logRegister("Infraestructura", "descarga");
                
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
