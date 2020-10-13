/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Luis Chávez
 */
public class JpaUtil {
    
    private static EntityManagerFactory emf = null;
    static {
        try {
            emf = Persistence.createEntityManagerFactory("AplicationPropertiesDB");
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
    }
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    } 
    
}
