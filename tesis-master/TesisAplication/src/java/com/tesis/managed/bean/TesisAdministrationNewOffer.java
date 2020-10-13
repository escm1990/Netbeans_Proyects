/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import com.tesis.controllers.TesisOfferJpaController;
import com.tesis.controllers.TesisSystemDocumentJpaController;
import com.tesis.controllers.TesisSystemImageJpaController;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisOffer;
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
@ManagedBean (name = "newOffer")
@RequestScoped
public class TesisAdministrationNewOffer {

    /**
     * Creates a new instance of TesisAdministrationNewOffer
     */
    TesisSystemDocumentJpaController docImpl = new TesisSystemDocumentJpaController();
    TesisOfferJpaController offerImpl = new TesisOfferJpaController();
    TesisSystemImageJpaController imageImp = new TesisSystemImageJpaController();
    
    private String nombre;
    private String mode;
    private String area;
    private String ciclos;
    private String plan;
    private String requerimientos;
    private String descripcion;
    private String campus;
    private Part file;
    private Part image;
     
    public TesisAdministrationNewOffer() {
    }
    
    public void resetValues() {
        this.nombre = "";
        this.mode = "";
        this.area = "";
        this.ciclos = "";
        this.plan = "";
        this.requerimientos = "";
        this.descripcion = "";
        this.campus = "";
        this.file = null;
        this.image = null;
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
     * @return the mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * @param mode the mode to set
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the ciclos
     */
    public String getCiclos() {
        return ciclos;
    }

    /**
     * @param ciclos the ciclos to set
     */
    public void setCiclos(String ciclos) {
        this.ciclos = ciclos;
    }

    /**
     * @return the plan
     */
    public String getPlan() {
        return plan;
    }

    /**
     * @param plan the plan to set
     */
    public void setPlan(String plan) {
        this.plan = plan;
    }

    /**
     * @return the requerimientos
     */
    public String getRequerimientos() {
        return requerimientos;
    }

    /**
     * @param requerimientos the requerimientos to set
     */
    public void setRequerimientos(String requerimientos) {
        this.requerimientos = requerimientos;
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
    
    public void saveOffer() {
        try {
          
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            String path = servletContext.getRealPath("");
            String carper = "oferta/";

            TesisOffer oferta = new TesisOffer();
     
            try {
                if (image != null) {
                    TesisSystemImage system_image = ImageTreatment.fillImage(path, image, carper);
                    imageImp.create(system_image);
                    List<TesisSystemImage> system_image_returned = imageImp.findListTesisSystemImageByImageDescription(system_image.getImageDescription());
                    if (system_image_returned.isEmpty() == false) {
                        oferta.setFkTesisSystemImage(system_image_returned.get(0));
                    }
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
                        oferta.setFkTesisSystemDocument(system_document_returned.get(0));
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
              try {
                  TesisCampus tesis_campus = FindCampus.getCampus(campus);
                  oferta.setFkTesisCampus(tesis_campus);
              } catch (Exception e) {
                  System.out.println(e.getMessage());
              }

            oferta.setOfferName(nombre);
            oferta.setOfferMode(mode);
            oferta.setOfferArea(area);
            oferta.setOfferCycles(ciclos);
            oferta.setOfferStudyPlan(plan);
            oferta.setOfferDescription(descripcion);
            oferta.setOfferRequirement(requerimientos);        
            oferta.setCreatedBy(request.getSession().getAttribute("user").toString());
            oferta.setCreatedDate(new Date());
            oferta.setUpdateBy(request.getSession().getAttribute("user").toString());
            oferta.setUpdateDate(new Date());
            offerImpl.create(oferta);
            SaveLogs.logRegister("NEW OFFER", "Creación de Nueva Oferta Académica: "+ nombre, request.getSession().getAttribute("user").toString());
            resetValues();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            SaveLogs.logRegister("NEW OFFER", "Error de Creación", "system");
        }
        
         addMessage("Oferta académica agregada con éxito!!");
    }
   
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
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
    
    
    
}
