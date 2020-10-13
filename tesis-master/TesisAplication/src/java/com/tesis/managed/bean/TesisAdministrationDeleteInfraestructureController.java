/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import com.tesis.controllers.TesisInfrastructureJpaController;
import com.tesis.controllers.TesisSystemDocumentJpaController;
import com.tesis.controllers.TesisSystemImageJpaController;
import com.tesis.model.entity.TesisInfrastructure;
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
 * @author Luis Chávez
 */
@ManagedBean (name = "delete_infra")
@ViewScoped
public class TesisAdministrationDeleteInfraestructureController {

    /**
     * Creates a new instance of
     * TesisAdministrationDeleteInfraestructureController
     */
    TesisInfrastructureJpaController controller = new TesisInfrastructureJpaController();
    TesisSystemImageJpaController image_controller = new TesisSystemImageJpaController();
    TesisSystemDocumentJpaController docImpl = new TesisSystemDocumentJpaController();
    private List<TesisInfrastructure> infra = new ArrayList<>();
    private TesisInfrastructure infra_select = new TesisInfrastructure();
    
    public TesisAdministrationDeleteInfraestructureController() {
    }
    
    @PostConstruct
    public void init() {
       infra = controller.findAllInfra();
    }

    /**
     * @return the infra
     */
    public List<TesisInfrastructure> getInfra() {
        return infra;
    }

    /**
     * @param infra the infra to set
     */
    public void setInfra(List<TesisInfrastructure> infra) {
        this.infra = infra;
    }

    /**
     * @return the infra_select
     */
    public TesisInfrastructure getInfra_select() {
        return infra_select;
    }

    /**
     * @param infra_select the infra_select to set
     */
    public void setInfra_select(TesisInfrastructure infra_select) {
        this.infra_select = infra_select;
    }
    
    
    public void eliminar() {
        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        String path = servletContext.getRealPath("");
        try {          
            if (this.infra_select != null) {
                TesisSystemImage image = this.infra_select.getFkTesisSystemImages();
                TesisSystemDocument doc = this.infra_select.getFkTesisSystemDocument();
                controller.destroy(this.infra_select.getCodTesisInfrastructure());
                delete_file_system_image(image, path);
                delete_file_system_document(doc, path);
                addMessage("Infraestructura Eliminada con Éxito");
                infra = controller.findAllInfra();
                SaveLogs.logRegister("DELETE INFRAESTRUCTURE", "Eliminación de Infraestructura: "+ infra_select.getInfraestructuraName(), request.getSession().getAttribute("user").toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
             SaveLogs.logRegister("DELETE INFRAESTRUCTURE", "Error de Eliminación", request.getSession().getAttribute("user").toString());
        }
        
    }
    
    public void delete_file_system_image(TesisSystemImage image, String path) {
        try {
            image_controller.destroy(image.getCodTesisSystemImages());
            path = path.replace("\\build", "");
            String dir = path + "/resources/" + image.getImageUri() + image.getImageDescription();
            File archivo = new File(dir);
            archivo.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
        public void downloadArchivo() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("/");

            if (infra_select != null) {
                String savePath = "resources/" + infra_select.getFkTesisSystemDocument().getDocumentUri() + infra_select.getFkTesisSystemDocument().getDocumentDescription();
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
    
}
