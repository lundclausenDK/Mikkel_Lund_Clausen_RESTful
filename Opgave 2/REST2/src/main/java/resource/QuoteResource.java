package resource;

import backend.Quote;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author
 */
@Path("quote")
public class QuoteResource {

    private Gson gson = new Gson();
    

    private static Map<Integer, String> quotes = new HashMap() {
        {
            put(0, "Friends are kisses blown to us by angels");
            put(1, "Do not take life too seriously. You will never get out of it alive");
            put(2, "Behind every great man, is a woman rolling her eyes");
        }
    };
    
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of QuoteResource
     */
    public QuoteResource() {
    }

    /**
     * Retrieves representation of an instance of resource.QuoteResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        String[] newQuotes = new String[quotes.size()];
        
        for (int i = 0; i < quotes.size(); i++) {
            
            newQuotes[i] = quotes.get(i);
        }
        
        return gson.toJsonTree(newQuotes).toString();
        //return "{\"firstname\": \"Joe\"}";
    }
    
    @Path("{random}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomJson() {
        String[] newQuotes = new String[quotes.size()];
        
        for (int i = 0; i < quotes.size(); i++) {
            
            newQuotes[i] = quotes.get(i);
        }
        
        int randomEntry = new Random().nextInt(quotes.size());
        String chosenQuote = newQuotes[randomEntry];
        Quote newQuote = new Quote(chosenQuote);
        return gson.toJson(newQuote);

    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(String content/*, @PathParam("id") int id*/) {
        
        //quotes.put(10, getRandomJson());
        System.out.println(getRandomJson());
        quotes.put(quotes.size(), "hello");
    }

    /**
     * PUT method for updating or creating an instance of QuoteResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
