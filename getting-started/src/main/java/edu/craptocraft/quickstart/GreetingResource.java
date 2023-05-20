package edu.craptocraft.quickstart;

import java.net.URI;
import java.util.List;

import io.smallrye.common.constraint.NotNull;
import jakarta.transaction.Transactional;
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

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "\nBienvenido a Quarkus Data";
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDev(Developer dev) {
        dev.persist();
        return Response.created(URI.create("/dev/" + dev.id)).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Developer> getAllDevs() {
        return Developer.findAll().list();
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Developer findByName(@PathParam("name") String name) {
        return Developer.find("name", name).firstResult();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}/{age}")
    public Developer findByNameAge(@NotNull @PathParam("name") String name, @PathParam("age") Integer age) {

        return Developer.find("name = ?1 and age = ?2", name, age).firstResult();
    }
}
