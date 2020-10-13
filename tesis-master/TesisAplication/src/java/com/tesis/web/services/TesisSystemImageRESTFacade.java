/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.web.services;

import com.tesis.controllers.TesisSystemImageJpaController;
import com.tesis.model.entity.TesisSystemImage;
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
@Path("/imagenes")
public class TesisSystemImageRESTFacade {


    private TesisSystemImageJpaController getJpaController() {
        return new TesisSystemImageJpaController();
    }

    public TesisSystemImageRESTFacade() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(TesisSystemImage entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getCodTesisSystemImages().toString())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(TesisSystemImage entity) {
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
    public TesisSystemImage find(@PathParam("id") Integer id) {
        return getJpaController().findTesisSystemImage(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<TesisSystemImage> findAll() {
        return getJpaController().findTesisSystemImageEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<TesisSystemImage> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findTesisSystemImageEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getTesisSystemImageCount());
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TesisSystemImage> geAllData() {
        return getJpaController().findTesisSystemImageEntities();
    }
}
