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
 * @author luis.chavez
 */
@ManagedBean(name = "delete_plan")
@ViewScoped
public class TesisAdministrationDeletePlanController {

    /**
     * Creates a new instance of TesisAdministrationDeletePlanController
     */
    TesisPlansJpaController planImp = new TesisPlansJpaController();
    TesisSystemImageJpaController imgImpl = new TesisSystemImageJpaController();
    TesisSystemDocumentJpaController docImpl = new TesisSystemDocumentJpaController();
    private List<TesisPlans> list = new ArrayList<TesisPlans>();
    private TesisPlans plan_select = new TesisPlans();

    public TesisAdministrationDeletePlanController() {
    }

    @PostConstruct
    public void init() {
        this.list = planImp.findAllPlans();
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

    public void downloadArchivo() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("/");

            if (getPlan_select() != null) {
                String savePath = "resources/" + getPlan_select().getFkTesisSystemDocument().getDocumentUri() + getPlan_select().getFkTesisSystemDocument().getDocumentDescription();
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

    public void delete_file_system_image(TesisSystemImage image, String path) {
        try {
            imgImpl.destroy(image.getCodTesisSystemImages());
            path = path.replace("\\build", "");
            String dir = path + "/resources/" + image.getImageUri() + image.getImageDescription();
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
    
    public void eliminar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
             HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            String path = servletContext.getRealPath("");
            if (this.plan_select != null) {
                TesisSystemImage image = this.plan_select.getFkTesisSystemImages();
                TesisSystemDocument doc = this.plan_select.getFkTesisSystemDocument();
                planImp.destroy(this.plan_select.getCodTesisPlans());
                delete_file_system_image(image, path);
                delete_file_system_document(doc, path);
                list = planImp.findAllPlans();
                SaveLogs.logRegister("DELETE PLAN", "Eliminación de Plan de Estudio: "+ plan_select.getPlanName(), request.getSession().getAttribute("user").toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            SaveLogs.logRegister("DELETE PLAN", "Error de Eliminación","system");
        }
        addMessage("Programa de estudio eliminado con éxito!!");
    }
}
