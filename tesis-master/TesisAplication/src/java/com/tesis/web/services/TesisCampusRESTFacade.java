/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tesis.web.services;

import com.tesis.controllers.TesisCampusJpaController;
import com.tesis.model.entity.TesisCampus;
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
@Path("/campus")
public class TesisCampusRESTFacade {


    private TesisCampusJpaController getJpaController() {
        return new TesisCampusJpaController();
    }

    public TesisCampusRESTFacade() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(TesisCampus entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getCodTesisCampus().toString())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(TesisCampus entity) {
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
    public TesisCampus find(@PathParam("id") Integer id) {
        return getJpaController().findTesisCampus(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<TesisCampus> findAll() {
        return getJpaController().findTesisCampusEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<TesisCampus> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findTesisCampusEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getTesisCampusCount());
    }
    
    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TesisCampus> geAllData() {
        return getJpaController().findTesisCampusEntities();
    }

}
