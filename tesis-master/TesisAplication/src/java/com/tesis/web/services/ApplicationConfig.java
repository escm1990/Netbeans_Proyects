/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.web.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * 
 * @author luis.chavez
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.tesis.web.services.TesisCampusRESTFacade.class);
        resources.add(com.tesis.web.services.TesisCultureRESTFacade.class);
        resources.add(com.tesis.web.services.TesisInfrastructureRESTFacade.class);
        resources.add(com.tesis.web.services.TesisLogRESTFacade.class);
        resources.add(com.tesis.web.services.TesisMastersRESTFacade.class);
        resources.add(com.tesis.web.services.TesisOfferRESTFacade.class);
        resources.add(com.tesis.web.services.TesisPlansRESTFacade.class);
        resources.add(com.tesis.web.services.TesisSystemDocumentRESTFacade.class);
        resources.add(com.tesis.web.services.TesisSystemImageRESTFacade.class);
        resources.add(com.tesis.web.services.TesisUserCampusRESTFacade.class);
        resources.add(com.tesis.web.services.TesisUserRESTFacade.class);
    }

}
