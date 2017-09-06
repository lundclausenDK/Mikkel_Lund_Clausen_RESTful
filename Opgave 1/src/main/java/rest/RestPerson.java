package rest;

import backend.Facade;
import entity.Person;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import utility.JSONConverter;

/**
 * REST Web Service
 *
 * @author lundc
 */

// DB <> JPA <> Facade <> Rest <> JS

@Path("persons")
public class RestPerson {
    
    Facade facade = new Facade();
    JSONConverter convert = new JSONConverter();
    
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
    public String getJson() {
        //TODO return proper representation object
        //return "{\"firstname\": \"Joe\"}";
        return convert.getJSONFromPerson(facade.getPersons()) ;
    }

    /**
     * PUT method for updating or creating an instance of RestPerson
     * @param content representation for the resource
     */
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void postJson(String content/*, @PathParam("id") int id*/) {
        
        Person newPerson = convert.getPersonFromJson(content);
        facade.addPerson(newPerson);
    }
}
