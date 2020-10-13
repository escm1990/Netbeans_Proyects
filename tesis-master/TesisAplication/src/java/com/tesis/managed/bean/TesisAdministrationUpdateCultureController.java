/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import com.tesis.controllers.TesisCultureJpaController;
import com.tesis.controllers.TesisSystemDocumentJpaController;
import com.tesis.controllers.TesisSystemImageJpaController;
import com.tesis.model.entity.TesisCulture;
import com.tesis.model.entity.TesisSystemDocument;
import com.tesis.model.entity.TesisSystemImage;
import com.tesis.utils.FileDownload;
import com.tesis.utils.FileTreatment;
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
 * @author luis.chavez
 */
@ManagedBean (name = "update_cul")
@ViewScoped
public class TesisAdministrationUpdateCultureController {

    /**
     * Creates a new instance of TesisAdministrationUpdateCultureController
     */
    TesisSystemImageJpaController imageImp = new TesisSystemImageJpaController();
    TesisCultureJpaController cultureImpl = new TesisCultureJpaController();
    TesisSystemDocumentJpaController fileImpl = new TesisSystemDocumentJpaController();
    private TesisCulture culture_select = new TesisCulture();
    private List<TesisCulture> lista = new ArrayList<>();
    private Part image;
    private Part newfile;
    
    public TesisAdministrationUpdateCultureController() {
    }
    
     public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    @PostConstruct
    public void init() {
        this.lista = cultureImpl.findAllCulture();
    }

    /**
     * @return the lista
     */
    public List<TesisCulture> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<TesisCulture> lista) {
        this.lista = lista;
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

    /**
     * @return the culture_select
     */
    public TesisCulture getCulture_select() {
        return culture_select;
    }

    /**
     * @param culture_select the culture_select to set
     */
    public void setCulture_select(TesisCulture culture_select) {
        this.culture_select = culture_select;
    }
    
        public void downloadArchivo() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("/");

            if (culture_select != null) {
                String savePath = "resources/" + culture_select.getFkSystemDocument().getDocumentUri() + culture_select.getFkSystemDocument().getDocumentDescription();
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
    
    public void delete_file_system_image(TesisSystemImage image, String path) {
        try {
            imageImp.destroy(image.getCodTesisSystemImages());
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
            fileImpl.destroy(doc.getCodTesisSystemDocument());
            path = path.replace("\\build", "");
            String dir = path + "/resources/" + doc.getDocumentUri() + doc.getDocumentDescription();
            File archivo = new File(dir);
            archivo.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void actualizar_cultura() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            String path = servletContext.getRealPath("");
            String carper = "cultura/";
            
             List<TesisSystemImage> system_image_returned = new ArrayList<>();
                if (image != null) {
                    TesisSystemImage system_image = ImageTreatment.fillImage(path, image, carper);
                    imageImp.create(system_image);
                    system_image_returned = imageImp.findListTesisSystemImageByImageDescription(system_image.getImageDescription());
                }
                
            try {
                if (newfile != null) {
                    TesisSystemDocument archivo = culture_select.getFkSystemDocument();
                    TesisSystemDocument doc = FileTreatment.fillFile(path, newfile, carper);
                    fileImpl.create(doc);
                    List<TesisSystemDocument> system_document_returned = fileImpl.findListTesisSystemDocumentByDocumentDescription(doc.getDocumentDescription());
                    if (system_document_returned.isEmpty() == false) {
                        culture_select.setFkSystemDocument(system_document_returned.get(0));
                        delete_file_system_document(archivo, path);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            if (culture_select != null) {
                TesisSystemImage img = culture_select.getFkSystemImages();
                this.culture_select.setUpdateBy(request.getSession().getAttribute("user").toString());
                this.culture_select.setUpdateDate(new Date());
                if (system_image_returned.isEmpty() == false) {
                    culture_select.setFkSystemImages(system_image_returned.get(0));
                    delete_file_system_image(img, path);
                }
                cultureImpl.edit(culture_select);
                SaveLogs.logRegister("UPDATE CULTURE", "Modificación de Cultura: "+ culture_select.getCultureName(), request.getSession().getAttribute("user").toString());
            }
             this.lista = cultureImpl.findAllCulture();
        } catch (Exception e) {
            e.printStackTrace();
            SaveLogs.logRegister("UPDATE CULTURE", "Error de Modificación","system");
        }
        
        addMessage("Evento cultural actualizado con éxito!");
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
