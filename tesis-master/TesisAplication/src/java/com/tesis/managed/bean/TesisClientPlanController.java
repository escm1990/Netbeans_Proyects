/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.managed.bean;

import com.tesis.controllers.TesisPlansJpaController;
import com.tesis.model.entity.TesisPlans;
import com.tesis.utils.FileDownload;
import com.tesis.utils.SaveAudit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luis.chavez
 */
@ManagedBean(name = "plan_client")
@SessionScoped
public class TesisClientPlanController {

    /**
     * Creates a new instance of TesisClientPlanController
     */
    TesisPlansJpaController planImp = new TesisPlansJpaController();
    private List<TesisPlans> list = new ArrayList<>();
    private TesisPlans item = new TesisPlans();
    private String criterio = "";

    public TesisClientPlanController() {
    }

    @PostConstruct
    public void init() {
        this.setList(planImp.findAllPlansOrder());
    }

    public String planes() {
        this.setList(planImp.findAllPlansOrder());       
        return "resources/templates/clients/planClients.xhtml";
    }

    public String submit() {
        SaveAudit.logRegister("Planes", "visita");
        return "detail_plan?faces-redirect=true";
    }

    public String regresar() {
        return "planClients?faces-redirect=true";
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
     * @return the item
     */
    public TesisPlans getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(TesisPlans item) {
        this.item = item;
    }

    public void downloadArchivo() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = servletContext.getRealPath("/");

            if (item != null) {
                String savePath = "resources/" + item.getFkTesisSystemDocument().getDocumentUri() + item.getFkTesisSystemDocument().getDocumentDescription();
                path = path.replace("\\build", "");
                File file = new File(path + File.separator + savePath);

                String mimeType = servletContext.getMimeType(file.getAbsolutePath());
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }
                FileDownload.write(response, mimeType, file,facesContext);
                SaveAudit.logRegister("Planes", "descarga");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     
    public void busqueda() {
        try {
            if (criterio.isEmpty() == true) {
               this.list = planImp.findAllPlansOrder();
                criterio = "";
            } else {
                 this.list = planImp.findAllPlanByCriteria(criterio);
                 criterio = "";
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the criterio
     */
    public String getCriterio() {
        return criterio;
    }

    /**
     * @param criterio the criterio to set
     */
    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }
    
    

}
