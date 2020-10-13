/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesis.managed.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Luis
 */
@ManagedBean (name = "tesisAdministration", eager = true)
@RequestScoped
public class TesisAdministrationIndexController implements Serializable{

    /** Creates a new instance of TesisAdministrationIndexController */
    public TesisAdministrationIndexController() {
         super();
    }
     public String infraestructura() {
      return "resources/templates/clients/infraestructuraClients.xhtml";
   }
     
     public String maestrias() {
      return "resources/templates/clients/maestriasClients.xhtml";
   }
     
}
