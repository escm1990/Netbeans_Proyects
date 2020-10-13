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
 * @author escm1990
 */
@ManagedBean(name = "update_master")
@ViewScoped
public class TesisAdministrationUpdateMasterController {

    /**
     * Creates a new instance of TesisAdministrationUpdateMaster
     */
    TesisSystemImageJpaController imageImp = new TesisSystemImageJpaController();
    TesisSystemDocumentJpaController fileImpl = new TesisSystemDocumentJpaController();
    TesisMastersJpaController masterImpl = new TesisMastersJpaController();
    private TesisMasters master_select = new TesisMasters();
    private List<TesisMasters> lista = new ArrayList<>();
    private Part image;
    private Part newfile;
    private String approved;
    private String plan;

    public TesisAdministrationUpdateMasterController() {
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    @PostConstruct
    public void init() {
        this.lista = masterImpl.findAllMaster();
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
     * @return the lista
     */
    public List<TesisMasters> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<TesisMasters> lista) {
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

    public void actualizar_maestria() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            String path = servletContext.getRealPath("");
            String carper = "maestrias/";

            List<TesisSystemImage> system_image_returned = new ArrayList<>();
            if (image != null) {
                TesisSystemImage system_image = ImageTreatment.fillImage(path, image, carper);
                imageImp.create(system_image);
                system_image_returned = imageImp.findListTesisSystemImageByImageDescription(system_image.getImageDescription());
            }

            try {
                if (newfile != null) {
                    TesisSystemDocument archivo = master_select.getFkTesisSystemDocument();
                    TesisSystemDocument doc = FileTreatment.fillFile(path, newfile, carper);
                    fileImpl.create(doc);
                    List<TesisSystemDocument> system_document_returned = fileImpl.findListTesisSystemDocumentByDocumentDescription(doc.getDocumentDescription());
                    if (system_document_returned.isEmpty() == false) {
                        master_select.setFkTesisSystemDocument(system_document_returned.get(0));
                        delete_file_system_document(archivo, path);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (master_select != null) {
                TesisSystemImage img = master_select.getFkTesisSystemImages();
                this.master_select.setUpdateBy(request.getSession().getAttribute("user").toString());
                this.master_select.setUpdateDate(new Date());
                if (system_image_returned.isEmpty() == false) {
                    master_select.setFkTesisSystemImages(system_image_returned.get(0));
                    delete_file_system_image(img, path);
                }
                masterImpl.edit(master_select);
                SaveLogs.logRegister("UPDATE MASTER", "Modificación de Maestría: " + master_select.getMaestriaName(), request.getSession().getAttribute("user").toString());
            }
            this.lista = masterImpl.findAllMaster();
        } catch (Exception e) {
            e.printStackTrace();
            SaveLogs.logRegister("UPDATE MASTER", "Error de Modificación", "system");
        }

        addMessage("Maestría actualizada con éxito!");
    }

    /**
     * @return the approved
     */
    public String getApproved() {
        return approved;
    }

    /**
     * @param approved the approved to set
     */
    public void setApproved(String approved) {
        this.approved = approved;
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
