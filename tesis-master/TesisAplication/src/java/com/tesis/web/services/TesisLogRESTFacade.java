/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.web.services;

import com.tesis.controllers.TesisLogJpaController;
import com.tesis.model.entity.TesisLog;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 
 * @author luis.chavez
 */
@Path("/log")
public class TesisLogRESTFacade {

    private TesisLogJpaController getJpaController() {
        return new TesisLogJpaController();
    }

    public TesisLogRESTFacade() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(TesisLog entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getCodTesisLog().toString())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(TesisLog entity) {
        try {
            getJpaController().edit(entity);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        try {
            getJpaController().destroy(id);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public TesisLog find(@PathParam("id") Integer id) {
        return getJpaController().findTesisLog(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<TesisLog> findAll() {
        return getJpaController().findTesisLogEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<TesisLog> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findTesisLogEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getTesisLogCount());
    }
    
    
    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TesisLog> geAllData() {
        return getJpaController().findTesisLogEntities();
    }

}
