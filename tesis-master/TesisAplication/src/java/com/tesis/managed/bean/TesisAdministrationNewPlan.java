/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.managed.bean;

import com.tesis.controllers.TesisPlansJpaController;
import com.tesis.controllers.TesisSystemDocumentJpaController;
import com.tesis.controllers.TesisSystemImageJpaController;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisPlans;
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
@ManagedBean(name = "newPlan")
@RequestScoped
public class TesisAdministrationNewPlan {

    /**
     * Creates a new instance of TesisAdministrationNewPlan
     */
    TesisSystemImageJpaController imageImp = new TesisSystemImageJpaController();
    TesisPlansJpaController planImpl = new TesisPlansJpaController();
    TesisSystemDocumentJpaController docImpl = new TesisSystemDocumentJpaController();

    private String nombre;
    private String descripcion;
    private String campus;
    private Part image;
    private Part file;

    public TesisAdministrationNewPlan() {
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
        this.file = null;
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
    
      public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
      public void insertPlan() {
          try {
              FacesContext context = FacesContext.getCurrentInstance();
              ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
              HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
              String path = servletContext.getRealPath("");
              String carper = "planes/";
              TesisPlans plan = new TesisPlans();
              try {
                  if (image != null) {
                      TesisSystemImage system_image = ImageTreatment.fillImage(path, image, carper);
                      imageImp.create(system_image);
                      List<TesisSystemImage> system_image_returned = imageImp.findListTesisSystemImageByImageDescription(system_image.getImageDescription());
                      if (system_image_returned.isEmpty() == false) {
                          plan.setFkTesisSystemImages(system_image_returned.get(0));
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
                          plan.setFkTesisSystemDocument(system_document_returned.get(0));
                      }
                  }
              } catch (Exception e) {
                  System.out.println(e.getMessage());
              }
               
              try {
                  TesisCampus tesis_campus = FindCampus.getCampus(campus);
                  plan.setFkTesisCampus(tesis_campus);
              } catch (Exception e) {
                  System.out.println(e.getMessage());
              }

              plan.setPlanName(nombre);
              plan.setPlanDescription(descripcion);
              plan.setCreatedBy(request.getSession().getAttribute("user").toString());
              plan.setCreatedDate(new Date());
              plan.setUpdateBy(request.getSession().getAttribute("user").toString());
              plan.setUpdateDate(new Date());
              planImpl.create(plan);
              SaveLogs.logRegister("NEW PLAN", "Creación de Plan de Estudio: "+ nombre, request.getSession().getAttribute("user").toString());
              resetValues();

          } catch (Exception e) {
              System.out.println(e.getMessage());
              SaveLogs.logRegister("NEW PLAN", "Error de Creación", "system");
          }
           addMessage("Programa de estudio agregado con éxito!!");
      }

}
