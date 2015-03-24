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
import pt.tripdashboard.pets.entities.Pet;
import pt.tripdashboard.pets.facades.PetFacade;

/**
 *
 * @author David
 */
@Singleton
@Path("pets")
public class Pets {

    @EJB
    private PetFacade petsFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pet> findAll() {
        try {
            /* Find Pets */
            return petsFacade.findAll();

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
        Pet result = petsFacade.find(id);

        if (result == null) {
            return Response.status(Response.Status.NOT_FOUND).build();

        } else {
            return Response.ok(result).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pet create(Pet pet) {
        petsFacade.create(pet);
        return pet;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") final Long id, Pet pet) {

        if (!id.equals(pet.getId())) {
            return Response.status(Response.Status.CONFLICT).build();
        }

        Pet result = petsFacade.find(id);

        if (result == null) {
            return Response.status(Response.Status.NOT_FOUND).build();

        } else {
            petsFacade.edit(pet);
            return Response.ok().build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") final Long id) {
        Pet result = petsFacade.find(id);

        if (result == null) {
            return Response.status(Response.Status.NOT_FOUND).build();

        } else {
            petsFacade.remove(result);

            return Response.ok().build();
        }
    }
}
