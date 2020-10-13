/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import com.tesis.controllers.TesisUserCampusJpaController;
import com.tesis.controllers.TesisUserJpaController;
import com.tesis.model.entity.TesisCampus;
import com.tesis.model.entity.TesisUser;
import com.tesis.model.entity.TesisUserCampus;
import com.tesis.utils.EncriptUtility;
import com.tesis.utils.FindCampus;
import com.tesis.utils.SaveLogs;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author luis.chavez
 */
@ManagedBean (name = "user_controller")
@ViewScoped
public class TesisAdministrationUsers {

    /**
     * Creates a new instance of TesisAdministrationUsers
     */
    private List<TesisUserCampus> usuarios = new ArrayList<>();
    TesisUserJpaController userImpl = new TesisUserJpaController();
    private TesisUser user_selected = new TesisUser();
    private TesisUserCampus user_campus_select = new TesisUserCampus();
    TesisUserCampusJpaController userCampusImpl = new TesisUserCampusJpaController();
    
    private String user = "";
    private String description = "";
    private String pass = "";
    private String campus = "";
    
    public TesisAdministrationUsers() {
    }

    @PostConstruct
    public void init () {
        this.usuarios = userCampusImpl.findAllUsersCampus();
    }
    /**
     * @return the usuarios
     */
    public List<TesisUserCampus> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<TesisUserCampus> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the user_selected
     */
    public TesisUser getUser_selected() {
        return user_selected;
    }

    /**
     * @param user_selected the user_selected to set
     */
    public void setUser_selected(TesisUser user_selected) {
        this.user_selected = user_selected;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
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
    
    public void saveUser() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();   
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            
            TesisUser user = new TesisUser();
            user.setUserName(this.user);
            String password = EncriptUtility.getStringMessageDigest(pass,EncriptUtility.MD5);
            user.setUserPass(password);
            user.setUserDescription(description);
            user.setCreatedBy(request.getSession().getAttribute("user").toString());
            user.setCreatedDate(new Date());
            user.setUpdateBy(request.getSession().getAttribute("user").toString());
            user.setUpdateDate(new Date());
            
            userImpl.create(user);
            TesisCampus tesis_campus = FindCampus.getCampus(campus);
            TesisUser user_return = userImpl.findTesisUserByUserName(this.user);
            
            TesisUserCampus usercampus = new TesisUserCampus();
            usercampus.setFkTesisCampus(tesis_campus);
            usercampus.setFkTesisUser(user_return);
            usercampus.setCreatedBy(request.getSession().getAttribute("user").toString());
            usercampus.setCreatedDate(new Date());
            userCampusImpl.create(usercampus);
            this.usuarios = userCampusImpl.findAllUsersCampus();
            addMessage("Usuario agregado con éxito!!!");
            SaveLogs.logRegister("NEW USER", "Creación de Usuario: "+ this.user, request.getSession().getAttribute("user").toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            SaveLogs.logRegister("NEW USER", "Error de Creación", "system");
            addMessageError("Ocurrio una excepción al agregar el usuario, por favor verifique campos!!!");
        }
    }
    
    public void eliminarUser () {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            userCampusImpl.destroy(user_campus_select.getCodTesisUserCampus());
            userImpl.destroy(user_campus_select.getFkTesisUser().getCodTesisUser());
            this.usuarios = userCampusImpl.findAllUsersCampus();
            addMessage("Usuario eliminado con éxito!!!");
            SaveLogs.logRegister("DELETE USER", "Eliminación de Usuario: "+user_campus_select.getFkTesisUser().getUserName(), request.getSession().getAttribute("user").toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            addMessageError("Error al eliminar usuario, por favor, verifique sesión!!!");
            SaveLogs.logRegister("DELETE USER", "Error de Eliminación", "system");
        }
    }
    
    public void updateUser () {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            
            String password = EncriptUtility.getStringMessageDigest(user_selected.getUserPass(),EncriptUtility.MD5);
            user_selected.setUserPass(password);
            user_selected.setUpdateBy(request.getSession().getAttribute("user").toString());
            user_selected.setUpdateDate(new Date());
            userImpl.edit(user_selected);
            this.usuarios = userCampusImpl.findAllUsersCampus();
            addMessage("Usuario actualizado con éxito!!!");
            SaveLogs.logRegister("UPDATE USER", "Modificación de Usuario: "+user_selected.getUserName(), request.getSession().getAttribute("user").toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            addMessageError("Error al actualizar usuario, por favor, verifique sesión!!!");
            SaveLogs.logRegister("UPDATE USER", "Error de Modificación", "system");
        }
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
     public void addMessageError(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the user_campus_select
     */
    public TesisUserCampus getUser_campus_select() {
        return user_campus_select;
    }

    /**
     * @param user_campus_select the user_campus_select to set
     */
    public void setUser_campus_select(TesisUserCampus user_campus_select) {
        this.user_campus_select = user_campus_select;
    }

}
