/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.managed.bean;

import com.tesis.controllers.TesisPlansJpaController;
import com.tesis.controllers.TesisSystemDocumentJpaController;
import com.tesis.controllers.TesisSystemImageJpaController;
import com.tesis.model.entity.TesisPlans;
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
@ManagedBean(name = "update_plan")
@ViewScoped
public class TesisAdministrationUpdatePlanController {

    /**
     * Creates a new instance of TesisAdministrationUpdatePlanController
     */
    TesisSystemImageJpaController imageImp = new TesisSystemImageJpaController();
    TesisSystemDocumentJpaController fileImpl = new TesisSystemDocumentJpaController();
    TesisPlansJpaController planImpl = new TesisPlansJpaController();
    private TesisPlans plan_select = new TesisPlans();
    private List<TesisPlans> list = new ArrayList<>();
    private Part image;
    private Part newfile;
    private String campus;

    public TesisAdministrationUpdatePlanController() {
    }

    @PostConstruct
    public void init() {
        this.list = planImpl.findAllPlans();
    }

    /**
     * @return the plan_select
     */
    public TesisPlans getPlan_select() {
        return plan_select;
    }

    /**
     * @param plan_select the plan_select to set
     */
    public void setPlan_select(TesisPlans plan_select) {
        this.plan_select = plan_select;
    }

    /**
     * @return the list
     */
    public List<TesisPlans> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<TesisPlans> list) {
        this.list = list;
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

    public void downloadArchivo() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("/");

            if (plan_select != null) {
                String savePath = "resources/" + plan_select.getFkTesisSystemDocument().getDocumentUri() + plan_select.getFkTesisSystemDocument().getDocumentDescription();
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

    public void actualizar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            String path = servletContext.getRealPath("");
            String carper = "planes/";
            try {
                if (image != null) {
                    TesisSystemImage img = plan_select.getFkTesisSystemImages();
                    TesisSystemImage system_image = ImageTreatment.fillImage(path, image, carper);
                    imageImp.create(system_image);
                    List<TesisSystemImage> system_image_returned = imageImp.findListTesisSystemImageByImageDescription(system_image.getImageDescription());
                    if (system_image_returned.isEmpty() == false) {
                        plan_select.setFkTesisSystemImages(system_image_returned.get(0));
                        delete_file_system_image(img, path);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                if (newfile != null) {
                    TesisSystemDocument archivo = plan_select.getFkTesisSystemDocument();
                    TesisSystemDocument doc = FileTreatment.fillFile(path, newfile, carper);
                    fileImpl.create(doc);
                    List<TesisSystemDocument> system_document_returned = fileImpl.findListTesisSystemDocumentByDocumentDescription(doc.getDocumentDescription());
                    if (system_document_returned.isEmpty() == false) {
                        plan_select.setFkTesisSystemDocument(system_document_returned.get(0));
                        delete_file_system_document(archivo, path);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (plan_select != null) {
                plan_select.setUpdateBy(request.getSession().getAttribute("user").toString());
                plan_select.setUpdateDate(new Date());
                planImpl.edit(plan_select);
                SaveLogs.logRegister("UPDATE PLAN", "Modificación de Plan de Estudio: "+ plan_select.getPlanName(), request.getSession().getAttribute("user").toString());
            }
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            SaveLogs.logRegister("UPDATE PLAN", "Error de Modificación ", "system");
        }
        this.list = planImpl.findAllPlans();
        addMessage("Programa de estudio modificado con éxito!!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
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
}
