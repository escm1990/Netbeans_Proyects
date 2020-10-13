/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.managed.bean;

import com.tesis.controllers.TesisMastersJpaController;
import com.tesis.controllers.TesisSystemDocumentJpaController;
import com.tesis.controllers.TesisSystemImageJpaController;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisMasters;
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
 * @author escm1990
 */
@ManagedBean (name = "newMaster")
@RequestScoped
public class TesisAdministrationNewMaster {

    /**
     * Creates a new instance of TesisAdministrationNewMaster
     */
    private TesisSystemImageJpaController imageImp = new TesisSystemImageJpaController();
    private TesisMastersJpaController masterImpl = new TesisMastersJpaController();
    TesisSystemDocumentJpaController docImpl = new TesisSystemDocumentJpaController();
    private String nombre;
    private String descripcion;
    private String campus;
    private Part image;
    private Part file;
    private String plan;
    private String aproved;
    
    public TesisAdministrationNewMaster() {
        this.nombre = "";
        this.descripcion = "";
        this.campus = "";
        this.image = null;
        this.plan = "";
        this.aproved = "";
        this.file = null;
    }
    
    public void resetValues() {
        this.nombre = "";
        this.descripcion = "";
        this.campus = "";
        this.image = null;
        this.plan = "";
        this.aproved = "";
        this.setFile(null);
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    /**
     * @return the imageImp
     */
    public TesisSystemImageJpaController getImageImp() {
        return imageImp;
    }

    /**
     * @param imageImp the imageImp to set
     */
    public void setImageImp(TesisSystemImageJpaController imageImp) {
        this.imageImp = imageImp;
    }

    /**
     * @return the masterImpl
     */
    public TesisMastersJpaController getMasterImpl() {
        return masterImpl;
    }

    /**
     * @param masterImpl the masterImpl to set
     */
    public void setMasterImpl(TesisMastersJpaController masterImpl) {
        this.masterImpl = masterImpl;
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
    
    /*Agregando maestria*/
      public void insertMaster() {
        try {
            
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            String path = servletContext.getRealPath("");
            String carper = "maestrias/";
            TesisMasters maestria = new TesisMasters();
             try {
                TesisSystemImage system_image = ImageTreatment.fillImage(path, image, carper);
                imageImp.create(system_image);
                List<TesisSystemImage> system_image_returned = imageImp.findListTesisSystemImageByImageDescription(system_image.getImageDescription());
                if (system_image_returned.isEmpty() == false) {
                    maestria.setFkTesisSystemImages(system_image_returned.get(0));
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
                        maestria.setFkTesisSystemDocument(system_document_returned.get(0));
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
              }
            try {
                TesisCampus tesis_campus = FindCampus.getCampus(campus);
                maestria.setFkTesisCampus(tesis_campus);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
              
            maestria.setMaestriaName(nombre);
            maestria.setMaestriaDescripcion(descripcion);
            maestria.setCreatedBy(request.getSession().getAttribute("user").toString());
            maestria.setCreatedDate(new Date());
            maestria.setUpdateBy(request.getSession().getAttribute("user").toString());
            maestria.setUpdateDate(new Date());
            maestria.setStudyPlan(plan);
            maestria.setApproved(aproved);
            masterImpl.create(maestria);
            SaveLogs.logRegister("NEW MASTER", "Creación de Nueva Maestría: " + nombre, request.getSession().getAttribute("user").toString());
            resetValues();

        } catch (Exception e) {
            e.printStackTrace();
            SaveLogs.logRegister("NEW MASTER", "Error de Creación","system");
        }
        addMessage("Maestría agregada con éxito!!");
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
     * @return the aproved
     */
    public String getAproved() {
        return aproved;
    }

    /**
     * @param aproved the aproved to set
     */
    public void setAproved(String aproved) {
        this.aproved = aproved;
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
