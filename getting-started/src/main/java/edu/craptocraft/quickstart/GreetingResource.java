package edu.craptocraft.quickstart;

import java.net.URI;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/dev")
public class GreetingResource {

    @Inject
    DeveloperRepository repo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDev(Developer dev) {
        repo.createDeveloper(dev);
        return Response.created(URI.create("/dev/" + dev.getId())).build();
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Developer findByName(@PathParam("name") String name) {
        return repo.findByName(name);
    }

}
