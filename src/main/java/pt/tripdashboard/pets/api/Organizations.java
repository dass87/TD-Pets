/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.tripdashboard.pets.api;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
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
import pt.tripdashboard.pets.entities.Organization;
import pt.tripdashboard.pets.facades.OrganizationFacade;

/**
 *
 * @author David
 */
@Singleton
@Path("organizations")
public class Organizations {
    
    @EJB
    private OrganizationFacade organizationsFacade;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Organization> findAll() {
        try {
            /* Find Organizations */
            return organizationsFacade.findAll();

        } catch (RuntimeException ex) {
            System.out.println(ex.getLocalizedMessage());
            // TODO return http code!!
            return new ArrayList<>(0);
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieve(@PathParam("id") final Long id) {
        Organization result = organizationsFacade.find(id);

        if (result == null) {
            return Response.status(Response.Status.NOT_FOUND).build();

        } else {
            return Response.ok(result).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Organization create(Organization organization) {
        organizationsFacade.create(organization);
        return organization;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") final Long id, Organization organization) {

        if (!id.equals(organization.getId())) {
            return Response.status(Response.Status.CONFLICT).build();
        }

        Organization result = organizationsFacade.find(id);

        if (result == null) {
            return Response.status(Response.Status.NOT_FOUND).build();

        } else {
            organizationsFacade.edit(organization);
            return Response.ok().build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") final Long id) {
        Organization result = organizationsFacade.find(id);

        if (result == null) {
            return Response.status(Response.Status.NOT_FOUND).build();

        } else {
            organizationsFacade.remove(result);

            return Response.ok().build();
        }
    }
}
