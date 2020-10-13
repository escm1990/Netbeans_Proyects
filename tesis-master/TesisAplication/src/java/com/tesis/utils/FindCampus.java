/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.utils;

import com.tesis.controllers.TesisCampusJpaController;
import com.tesis.model.entity.TesisCampus;

/**
 *
 * @author Luis Chávez
 */
public class FindCampus {
    
    public static TesisCampus getCampus(String select) {
        TesisCampus campus = new TesisCampus();
        TesisCampusJpaController controller = new TesisCampusJpaController();
        try {
            if (select.equals("1") == true) {
                campus = controller.findTesisCampusByCampusName("Facultad Multidisciplinaria de Occidente");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return campus;
    }
    
}
