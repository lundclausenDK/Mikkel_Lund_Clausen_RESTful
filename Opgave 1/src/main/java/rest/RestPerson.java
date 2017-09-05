package rest;

import entity.Person;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author lundc
 */

// DB <> JPA <> Facade <> Rest <> JS

@Path("generic")
public class RestPerson {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestPerson
     */
    public RestPerson() {
    }

    /**
     * Retrieves representation of an instance of rest.RestPerson
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(Person p) {
        //TODO return proper representation object
        //return "{\"firstname\": \"Joe\"}";
        return p.toString();
    }

    /**
     * PUT method for updating or creating an instance of RestPerson
     * @param content representation for the resource
     */
    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String putJson(String content, @PathParam("id") int id) {
        System.out.println("From front:" + id);
        return "{}";
    }
}
