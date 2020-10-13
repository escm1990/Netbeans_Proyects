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
@ManagedBean(name = "delete_cul")
@ViewScoped
public class TesisAdministrationDeleteCultureController {

    /**
     * Creates a new instance of TesisAdministrationDeleteCultureController
     */
    TesisCultureJpaController cultureImpl = new TesisCultureJpaController();
    private List<TesisCulture> list = new ArrayList<>();
    private TesisCulture culture_select = new TesisCulture();
    TesisSystemImageJpaController image_controller = new TesisSystemImageJpaController();
    TesisSystemDocumentJpaController docImpl = new TesisSystemDocumentJpaController();

    @PostConstruct
    public void init() {
        this.list = cultureImpl.findAllCulture();
    }

    public TesisAdministrationDeleteCultureController() {
    }

    /**
     * @return the list
     */
    public List<TesisCulture> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<TesisCulture> list) {
        this.list = list;
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
             if (this.culture_select != null) {
                TesisSystemImage image = this.culture_select.getFkSystemImages();
                TesisSystemDocument doc = this.culture_select.getFkSystemDocument();
                cultureImpl.destroy(this.culture_select.getCodTesisCulture());
                delete_file_system_image(image, path);
                delete_file_system_document(doc, path);
                addMessage("Evento cultural eliminado con éxito!");
                list = cultureImpl.findAllCulture();
                SaveLogs.logRegister("DELETE CULTURE", "Eliminación de Cultura: "+ culture_select.getCultureName(), request.getSession().getAttribute("user").toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            SaveLogs.logRegister("DELETE CULTURE", "Error de Eliminación", "system");
        }
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
