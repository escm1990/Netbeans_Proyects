/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.managed.bean;

import com.tesis.controllers.TesisMastersJpaController;
import com.tesis.model.entity.TesisMasters;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Luis Chávez
 */
@ManagedBean (name = "masters", eager = true)
@RequestScoped
public class TesisAdministrationMastersController {

    /**
     * Creates a new instance of TesisAdministrationMastersController
     */
    public TesisAdministrationMastersController() {
    }
    
    public List<TesisMasters> getListMasters(){
        try {
            TesisMastersJpaController controller = new TesisMastersJpaController();
            return controller.findTesisMastersEntities();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public TesisMasters getMaster(int id){
        try {
            TesisMastersJpaController controller = new TesisMastersJpaController();
            return controller.findTesisMasters(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
