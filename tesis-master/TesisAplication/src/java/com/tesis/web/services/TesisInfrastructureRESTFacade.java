/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.web.services;

import com.tesis.controllers.TesisInfrastructureJpaController;
import com.tesis.model.entity.TesisInfrastructure;
import com.tesis.utils.SaveAudit;
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
@Path("/infraestructura")
public class TesisInfrastructureRESTFacade {

    private TesisInfrastructureJpaController getJpaController() {
        return new TesisInfrastructureJpaController();
    }

    public TesisInfrastructureRESTFacade() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(TesisInfrastructure entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getCodTesisInfrastructure().toString())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(TesisInfrastructure entity) {
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
    public TesisInfrastructure find(@PathParam("id") Integer id) {
        return getJpaController().findTesisInfrastructure(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<TesisInfrastructure> findAll() {
        return getJpaController().findTesisInfrastructureEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<TesisInfrastructure> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findTesisInfrastructureEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getTesisInfrastructureCount());
    }
    
    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
    public List<TesisInfrastructure> geAllData() {
        SaveAudit.logRegister("Infraestructura", "visita");
        return getJpaController().findAllInfra();
    }

}
