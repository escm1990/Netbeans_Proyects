/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import com.tesis.controllers.TesisInfrastructureJpaController;
import com.tesis.model.entity.TesisInfrastructure;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Luis Chávez
 */
@ManagedBean (name = "infraestructure", eager = true)
@RequestScoped
public class TesisAdministrationInfraestructureController {

    /**
     * Creates a new instance of TesisAdministrationInfraestructureController
     */
    public TesisAdministrationInfraestructureController() {
    }
    
    public List<TesisInfrastructure> getListInfra(){
        
        try {
            TesisInfrastructureJpaController controller = new TesisInfrastructureJpaController();     
            return controller.findTesisInfrastructureEntities();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
