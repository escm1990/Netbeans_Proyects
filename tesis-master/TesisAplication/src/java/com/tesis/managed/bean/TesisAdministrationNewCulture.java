/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import com.tesis.controllers.TesisCultureJpaController;
import com.tesis.controllers.TesisSystemDocumentJpaController;
import com.tesis.controllers.TesisSystemImageJpaController;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisCulture;
import com.tesis.model.entity.TesisSystemDocument;
import com.tesis.model.entity.TesisSystemImage;
import com.tesis.utils.FileTreatment;
import com.tesis.utils.FindCampus;
import com.tesis.utils.ImageTreatment;
import com.tesis.utils.SaveLogs;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author luis.chavez
 */
@ManagedBean (name = "newCulture")
@RequestScoped
public class TesisAdministrationNewCulture {

    /**
     * Creates a new instance of TesisAdministrationNewCulture
     */
    TesisSystemImageJpaController imageImp = new TesisSystemImageJpaController();
    TesisCultureJpaController cultureImpl = new TesisCultureJpaController();
    TesisSystemDocumentJpaController docImpl = new TesisSystemDocumentJpaController();
    private String nombre;
    private String descripcion;
    private String campus;
    private Part image;
    private Part file;
    
    public TesisAdministrationNewCulture() {
        this.nombre = "";
        this.descripcion = "";
        this.campus = "";
        this.image = null;
        this.file = null;
    }
    
    public void resetValues() {
        this.nombre = "";
        this.descripcion = "";
        this.campus = "";
        this.image = null;
        this.setFile(null);
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the campus
     */
    public String getCampus() {
        return campus;
    }

    /**
     * @param campus the campus to set
     */
    public void setCampus(String campus) {
        this.campus = campus;
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
    
    public void insertCulture() {
        try {
            
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            String path = servletContext.getRealPath("");
            String carper = "cultura/";
            TesisCulture cultura = new TesisCulture();
             try {
                TesisSystemImage system_image = ImageTreatment.fillImage(path, image, carper);
                imageImp.create(system_image);
                List<TesisSystemImage> system_image_returned = imageImp.findListTesisSystemImageByImageDescription(system_image.getImageDescription());
                if (system_image_returned.isEmpty() == false) {
                    cultura.setFkSystemImages(system_image_returned.get(0));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                if (file != null) {
                    TesisSystemDocument doc = FileTreatment.fillFile(path, file, carper);
                    docImpl.create(doc);
                    List<TesisSystemDocument> system_document_returned = docImpl.findListTesisSystemDocumentByDocumentDescription(doc.getDocumentDescription());
                    if (system_document_returned.isEmpty() == false) {
                        cultura.setFkSystemDocument(system_document_returned.get(0));
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                TesisCampus tesis_campus = FindCampus.getCampus(campus);
                cultura.setFkTesisCampus(tesis_campus);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
              
            cultura.setCultureName(nombre);
            cultura.setCultureDescription(descripcion);
            cultura.setCreatedBy(request.getSession().getAttribute("user").toString());
            cultura.setCreatedDate(new Date());
            cultura.setUpdateBy(request.getSession().getAttribute("user").toString());
            cultura.setUpdateDate(new Date());
            cultureImpl.create(cultura);
            SaveLogs.logRegister("NEW CULTURE", "Creación de Cultura: " + nombre, request.getSession().getAttribute("user").toString());
            resetValues();

        } catch (Exception e) {
            e.printStackTrace();
            SaveLogs.logRegister("NEW CULTURE", "Error de Creación","system");
        }
        addMessage("Evento cultural agregado con éxito!!");
    }

    /**
     * @return the file
     */
    public Part getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(Part file) {
        this.file = file;
    }
    

}
