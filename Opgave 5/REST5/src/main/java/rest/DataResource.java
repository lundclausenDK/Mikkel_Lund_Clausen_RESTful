package rest;

import backend.Generator;
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
 * @author
 */
@Path("data")
public class DataResource {
    
    Generator generator = new Generator();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DataResource
     */
    public DataResource() {
    }

    /**
     * Retrieves representation of an instance of rest.DataResource
     * @return an instance of java.lang.String
     */
    @Path("{amount}/{startpoint}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("amount") int amount, @PathParam("startpoint") int startpoint) {
        
        return generator.createJson(amount, startpoint);
    }

    /**
     * PUT method for updating or creating an instance of DataResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
