/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.managed.bean;

import com.tesis.controllers.TesisInfrastructureJpaController;
import com.tesis.controllers.TesisSystemDocumentJpaController;
import com.tesis.controllers.TesisSystemImageJpaController;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisInfrastructure;
import com.tesis.model.entity.TesisSystemDocument;
import com.tesis.model.entity.TesisSystemImage;
import com.tesis.utils.FileTreatment;
import com.tesis.utils.FindCampus;
import com.tesis.utils.FindTypeInfra;
import com.tesis.utils.ImageTreatment;
import com.tesis.utils.SaveLogs;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author Luis Chávez
 */
@ManagedBean(name = "newInfraestructure")
@RequestScoped
public class TesisAdministrationNewInfraestructure {

    /**
     * Creates a new instance of TesisAdministrationNewInfraestructure
     */
    TesisSystemImageJpaController imageImp = new TesisSystemImageJpaController();
    TesisSystemDocumentJpaController docImp = new TesisSystemDocumentJpaController();
    TesisInfrastructureJpaController infraImpl = new TesisInfrastructureJpaController();
    
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private String alto;
    private String ancho;
    private String largo;
    private String campus;
    private String tipo;
    private Part image;
    private Part file;

    public TesisAdministrationNewInfraestructure() {

        this.nombre = "";
        this.descripcion = "";
        this.ancho = "";
        this.alto = "";
        this.ubicacion = "";
        this.largo = "";
        this.campus = "";
        this.image = null;
        this.file = null;
        this.tipo = "";
    }
    
    public void resetValues() {
        this.nombre = "";
        this.descripcion = "";
        this.ancho = "";
        this.alto = "";
        this.ubicacion = "";
        this.largo = "";
        this.campus = "";
        this.image = null;
        this.setFile(null);
        this.setTipo("");
    }

    public void insertInfra(ActionEvent actionEvent) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            String path = servletContext.getRealPath("");
            String carper = "infraestructura/";
            TesisInfrastructure infra = new TesisInfrastructure();
            try {
                TesisSystemImage system_image = ImageTreatment.fillImage(path, image, carper);
                imageImp.create(system_image);
                List<TesisSystemImage> system_image_returned = imageImp.findListTesisSystemImageByImageDescription(system_image.getImageDescription());
                infra.setFkTesisSystemImages(system_image_returned.get(0));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                if (file != null) {
                    TesisSystemDocument doc = FileTreatment.fillFile(path, getFile(), carper);
                    docImp.create(doc);
                    List<TesisSystemDocument> system_document_returned = docImp.findListTesisSystemDocumentByDocumentDescription(doc.getDocumentDescription());
                    if (system_document_returned.isEmpty() == false) {
                        infra.setFkTesisSystemDocument(system_document_returned.get(0));
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
           
            try {
                TesisCampus tesis_campus = FindCampus.getCampus(campus);
                infra.setFkTesisCampus(tesis_campus);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            infra.setInfraestructuraName(nombre);
            infra.setInfraestructuraType(tipo);
            infra.setInfraestucturaDescription(descripcion);
            infra.setInfraestucturaLocation(ubicacion);
            infra.setHeightLength(alto);
            infra.setWeigthLength(ancho);
            infra.setLength(largo);
            infra.setCreatedBy(request.getSession().getAttribute("user").toString());
            infra.setCreatedDate(new Date());
            infra.setUpdateBy(request.getSession().getAttribute("user").toString());
            infra.setUpdateDate(new Date());
            infraImpl.create(infra);
            SaveLogs.logRegister("NEW INFRAESTRUCTURE", "Creación de Nueva Infraestructura: "+ nombre, request.getSession().getAttribute("user").toString());
            resetValues();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            SaveLogs.logRegister("NEW INFRAESTRUCTURE", "Error en Creación", "system");
        }
        addMessage("Infraestructura agregada con éxito!!");
        
    
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
     * @return the alto
     */
    public String getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(String alto) {
        this.alto = alto;
    }

    /**
     * @return the ancho
     */
    public String getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(String ancho) {
        this.ancho = ancho;
    }

    /**
     * @return the largo
     */
    public String getLargo() {
        return largo;
    }

    /**
     * @param largo the largo to set
     */
    public void setLargo(String largo) {
        this.largo = largo;
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

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

}
