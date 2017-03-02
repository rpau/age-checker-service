package org.arquillian.microservice.agecheckerservice.boundary;

import org.arquillian.microservice.agecheckerservice.controller.AgeChecker;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

@Path("/")
public class AgeCheckerResource {


    @Inject
    AgeChecker ageChecker;

    @Path("/checker")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @POST
    public Response check(final JsonObject data) {

        int userAge = data.getInt("age");
        String pegi = data.getString("pegi");

        if(ageChecker.isOldEnough(userAge,pegi)){
            return Response.ok("OK").build();
        }

        return Response.ok("NO_OK").build();

    }

}
