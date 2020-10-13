/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.managed.bean;

import com.tesis.controllers.TesisUserJpaController;
import com.tesis.model.entity.TesisUser;
import com.tesis.utils.EncriptUtility;
import com.tesis.utils.SaveLogs;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luis Chávez
 */
@ManagedBean(name = "login", eager = true)
@SessionScoped
public class TesisAdministrationLoginController implements Serializable {

    private String usuario;
    private String contrasenia;
    private HttpServletRequest httpServletRequest;
    private FacesContext faceContext;
    private FacesMessage facesMessage;

    public TesisAdministrationLoginController() {
    }

    public String defaultLogin() {
        return "resources/templates/administration/loginAdministration.xhtml";
    }

    public String dashboardAdministration() {

        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        TesisUserJpaController userImp = new TesisUserJpaController();
        try {
            TesisUser user = userImp.findTesisUserByUserName(usuario);
            String password = EncriptUtility.getStringMessageDigest(contrasenia,EncriptUtility.MD5);
            if (user.getUserName().equals(usuario) && user.getUserPass().equals(password)) {
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("user", usuario);
                SaveLogs.logRegister("LOGIN", "Logeo de Usuario: " + usuario, usuario);
                return "dashboardAdministration.xhtml";
            } else {
                addMessage("Usuario o Contraseña no Válidos");
            } 
        } catch (Exception e) {
            System.out.println(e.getMessage());
             SaveLogs.logRegister("LOGIN", "Error de Logeo", usuario);
            addMessage("Usuario o Contraseña no Válidos");
        }
        return "";
    }

      public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
      
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    

}
