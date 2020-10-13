/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.managed.bean;

import com.tesis.controllers.TesisOfferJpaController;
import com.tesis.controllers.TesisSystemDocumentJpaController;
import com.tesis.controllers.TesisSystemImageJpaController;
import com.tesis.model.entity.TesisOffer;
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
@ManagedBean(name = "update_offer")
@ViewScoped
public class TesisAdministrationUpdateOfferController {

    /**
     * Creates a new instance of TesisAdministrationUpdateOfferController
     */
    TesisSystemDocumentJpaController docImpl = new TesisSystemDocumentJpaController();
    TesisOfferJpaController offerImpl = new TesisOfferJpaController();
    TesisSystemImageJpaController imageImp = new TesisSystemImageJpaController();
    private Part newfile;
    private Part image;
    private String campus;
    private TesisOffer offer_select = new TesisOffer();
    private List<TesisOffer> list = new ArrayList<>();

    public TesisAdministrationUpdateOfferController() {
    }

    @PostConstruct
    public void init() {
        this.setList(offerImpl.findAllOffers());
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
     * @return the offer_select
     */
    public TesisOffer getOffer_select() {
        return offer_select;
    }

    /**
     * @param offer_select the offer_select to set
     */
    public void setOffer_select(TesisOffer offer_select) {
        this.offer_select = offer_select;
    }

    /**
     * @return the list
     */
    public List<TesisOffer> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<TesisOffer> list) {
        this.list = list;
    }

    public void downloadArchivo() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("/");

            if (offer_select != null) {
                String savePath = "resources/" + offer_select.getFkTesisSystemDocument().getDocumentUri() + offer_select.getFkTesisSystemDocument().getDocumentDescription();
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

    public void actualizar() {
        try {
            
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            String path = servletContext.getRealPath("");
            String carper = "oferta/";
            
            try {
                if (image != null) {
                    TesisSystemImage img = offer_select.getFkTesisSystemImage();
                    TesisSystemImage system_image = ImageTreatment.fillImage(path, image, carper);
                    imageImp.create(system_image);
                    List<TesisSystemImage> system_image_returned = imageImp.findListTesisSystemImageByImageDescription(system_image.getImageDescription());
                    if (system_image_returned.isEmpty() == false) {
                        offer_select.setFkTesisSystemImage(system_image_returned.get(0));
                        delete_file_system_image(img, path);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            try {
                if (newfile != null) {
                    TesisSystemDocument archivo = offer_select.getFkTesisSystemDocument();
                    TesisSystemDocument doc = FileTreatment.fillFile(path, newfile, carper);
                    docImpl.create(doc);
                    List<TesisSystemDocument> system_document_returned = docImpl.findListTesisSystemDocumentByDocumentDescription(doc.getDocumentDescription());
                    if (system_document_returned.isEmpty() == false) {
                        offer_select.setFkTesisSystemDocument(system_document_returned.get(0));
                        delete_file_system_document(archivo, path);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
           
            if (offer_select != null) {
                offer_select.setUpdateBy(request.getSession().getAttribute("user").toString());
                offer_select.setUpdateDate(new Date());
                offerImpl.edit(offer_select);
                SaveLogs.logRegister("UPDATE OFFER", "Modificación de Oferta Académica: "+ offer_select.getOfferName(), request.getSession().getAttribute("user").toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            SaveLogs.logRegister("UPDATE OFFER", "Error al modificar", "system");
        }

        this.list = offerImpl.findAllOffers();
        addMessage("Oferta académica modificada con éxito!!");
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
