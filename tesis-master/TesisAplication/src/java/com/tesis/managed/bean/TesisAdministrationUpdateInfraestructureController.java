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
import com.tesis.utils.FileTreatment;
import com.tesis.utils.FindTypeInfra;
import com.tesis.utils.ImageTreatment;
import com.tesis.utils.SaveLogs;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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
import javax.servlet.http.Part;

/**
 *
 * @author Luis Chávez
 */
@ManagedBean(name = "update_infra")
@ViewScoped
public class TesisAdministrationUpdateInfraestructureController {

    /**
     * Creates a new instance of
     * TesisAdministrationUpdateInfraestructureController
     */
    TesisInfrastructureJpaController controller = new TesisInfrastructureJpaController();
    TesisSystemImageJpaController imageImp = new TesisSystemImageJpaController();
    TesisSystemDocumentJpaController fileImpl = new TesisSystemDocumentJpaController();
    private List<TesisInfrastructure> infra = new ArrayList<>();
    private TesisInfrastructure infra_select = new TesisInfrastructure();

    private Part image;
    private Part newfile;

    public TesisAdministrationUpdateInfraestructureController() {
        super();
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

    public void actualizar_infra() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            String path = servletContext.getRealPath("");
            String carper = "infraestructura/";
         
            try {
                List<TesisSystemImage> system_image_returned = new ArrayList<>();
                if (image != null) {
                    TesisSystemImage system_image = ImageTreatment.fillImage(path, image, carper);
                    imageImp.create(system_image);
                    system_image_returned = imageImp.findListTesisSystemImageByImageDescription(system_image.getImageDescription());
                }

                try {
                    if (getNewfile() != null) {
                        TesisSystemDocument archivo = infra_select.getFkTesisSystemDocument();
                        TesisSystemDocument doc = FileTreatment.fillFile(path, getNewfile(), carper);
                        fileImpl.create(doc);
                        List<TesisSystemDocument> system_document_returned = fileImpl.findListTesisSystemDocumentByDocumentDescription(doc.getDocumentDescription());
                        if (system_document_returned.isEmpty() == false) {
                            infra_select.setFkTesisSystemDocument(system_document_returned.get(0));
                            delete_file_system_document(archivo, path);
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                if (infra_select != null) {
                    TesisSystemImage img = infra_select.getFkTesisSystemImages();
                    this.infra_select.setUpdateBy(request.getSession().getAttribute("user").toString());
                    this.infra_select.setUpdateDate(new Date());
                    if (system_image_returned.isEmpty() == false) {
                        infra_select.setFkTesisSystemImages(system_image_returned.get(0));
                        delete_file_system_image(img, path);
                    }
                    controller.edit(infra_select);
                    SaveLogs.logRegister("UPDATE INFRAESTRUCTURE", "Modificación de Infraestructura: " + infra_select.getInfraestructuraName(), request.getSession().getAttribute("user").toString());

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                SaveLogs.logRegister("UPDATE INFRAESTRUCTURE", "Error al Modificar", request.getSession().getAttribute("user").toString());
            }
             infra = controller.findAllInfra();
             addMessage("Infraestructura Actualizada con Éxito");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            SaveLogs.logRegister("UPDATE INFRAESTRUCTURE", "Error al Modificar", "system");
        }
    }

    
    /**
     * @return the image
     */
    public Part getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Part image) {
        this.image = image;
    }
    
    
    public void delete_file_system_image(TesisSystemImage image, String path) {
        try {
            path = path.replace("\\build", "");
            String dir = path + "/resources/" + image.getImageUri()+ image.getImageDescription();        
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
     
    public void delete_file_system_document(TesisSystemDocument doc, String path) {
        try {
            path = path.replace("\\build", "");
            String dir = path + "/resources/" + doc.getDocumentUri() + doc.getDocumentDescription();
            File archivo = new File(dir);
            archivo.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the newfile
     */
    public Part getNewfile() {
        return newfile;
    }

    /**
     * @param newfile the newfile to set
     */
    public void setNewfile(Part newfile) {
        this.newfile = newfile;
    }

}
