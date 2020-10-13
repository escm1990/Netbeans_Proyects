/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.managed.bean;


import com.tesis.utils.SaveLogs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Luis Chávez
 */
@ManagedBean(name = "admin_controller")
@SessionScoped
public class TesisAdministrationController {

    /**
     * Creates a new instance of TesisAdministrationController
     */
    String user = "";

    FacesContext context = FacesContext.getCurrentInstance();
    ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    
    public TesisAdministrationController() {
    }

    public String getViewUpdateInfraestructura() {
        return "update_infraestructure";
    }
    
     public String getViewUpdateCulture() {
        return "update_culture";
    }
     
    public String getViewUpdatePlan() {
        return "update_plan";
    }

    public String getViewUpdateMaster() {
        return "update_master";
    }
    
      public String getViewUpdateOffer() {
        return "update_offer";
    }

    public String getDashBoard() {
        return "dashboardAdministration";
    }

    public String getViewDeleteInfraestructura() {
        return "delete_infraestructure";
    }
    
    public String getViewDeleteCulture() {
        return "delete_culture";
    }
  
    public String getViewDeletePlan() {
        return "delete_plan";
    }

    public String getViewDeleteMaster(){
        return "delete_master";
    }
    
     public String getViewDeleteOffer(){
        return "delete_offer";
    }

    public String getViewUsers() {
        return "user_administrator";
    }
    
     public String getViewVisits() {
        return "chart_administration";
    }

    public String getViewAudit() {
        return "audit_administration";
    }
     
    public String getExit() {
        //SaveLogs.logRegister("LOGIN", "Deslogueo de Usuario: " + getUser(), getUser());
        return "../../../index.xhtml";
    }
    
    public String getUser() {
        try {
            String session = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            user = session;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return user;
    }

}
