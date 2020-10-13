/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.managed.bean;

import com.tesis.controllers.TesisMastersJpaController;
import com.tesis.controllers.TesisSystemDocumentJpaController;
import com.tesis.controllers.TesisSystemImageJpaController;
import com.tesis.model.entity.TesisMasters;
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
 * @author escm1990
 */
@ManagedBean(name = "delete_master")
@ViewScoped
public class TesisAdministrationDeleteMasterController {

    /**
     * Creates a new instance of TesisAdministrationDeleteMasterController
     */
    private TesisMastersJpaController masterImpl = new TesisMastersJpaController();
    private List<TesisMasters> list = new ArrayList<>();
    private TesisMasters master_select = new TesisMasters();
    private TesisSystemImageJpaController image_controller = new TesisSystemImageJpaController();
    TesisSystemDocumentJpaController docImpl = new TesisSystemDocumentJpaController();

    @PostConstruct
    public void init() {
        this.setList(getMasterImpl().findAllMaster());
    }

    public TesisAdministrationDeleteMasterController() {
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
     * @return the list
     */
    public List<TesisMasters> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<TesisMasters> list) {
        this.list = list;
    }

    /**
     * @return the master_select
     */
    public TesisMasters getMaster_select() {
        return master_select;
    }

    /**
     * @param master_select the master_select to set
     */
    public void setMaster_select(TesisMasters master_select) {
        this.master_select = master_select;
    }

    /**
     * @return the image_controller
     */
    public TesisSystemImageJpaController getImage_controller() {
        return image_controller;
    }

    /**
     * @param image_controller the image_controller to set
     */
    public void setImage_controller(TesisSystemImageJpaController image_controller) {
        this.image_controller = image_controller;
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

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void eliminar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            String path = servletContext.getRealPath("");
            if (this.master_select != null) {
                TesisSystemImage image = this.master_select.getFkTesisSystemImages();
                TesisSystemDocument doc = this.master_select.getFkTesisSystemDocument();
                masterImpl.destroy(this.master_select.getCodTesisMasters());
                delete_file_system_image(image, path);
                delete_file_system_document(doc, path);
                addMessage("Maestría eliminada con éxito!");
                list = masterImpl.findAllMaster();
                SaveLogs.logRegister("DELETE MASTER", "Eliminación de Maestría: " + master_select.getMaestriaName(), request.getSession().getAttribute("user").toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            SaveLogs.logRegister("DELETE MASTER", "Error de Eliminación", "system");
        }
    }

    public void downloadArchivo() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("/");

            if (master_select != null) {
                String savePath = "resources/" + master_select.getFkTesisSystemDocument().getDocumentUri() + master_select.getFkTesisSystemDocument().getDocumentDescription();
                path = path.replace("\\build", "");
                File file = new File(path + File.separator + savePath);

                String mimeType = servletContext.getMimeType(file.getAbsolutePath());
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }
                FileDownload.write(response, mimeType, file, facesContext);
            }

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
}
