/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.model;

/**
 * 
 * @author luis.chavez
 */
public class chartInformation {

    private String description;
    private String value;

    public chartInformation(String description, String value) {
        this.description = description;
        this.value = value;
    }
    
    
    public chartInformation() {
        this.description = "";
        this.value = "";
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
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    
    
    
}
