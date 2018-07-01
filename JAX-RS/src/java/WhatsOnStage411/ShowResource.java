package WhatsOnStage411;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

//For this app, I think we only need to focus on one aspect of the site. I arbitrarily chose show
@Path("show")
public class ShowResource
{
    @Context
    private UriInfo context;

    public ShowResource()
    {
        //
    }
    
    /**
     * Retrieves representation of an instance of WhatsOnStage411.ShowResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_HTML)
    public String getHtml()
    {
        return "<html><head><title>Hello there</title></head><body>Hello from getHTML() in the ShowResource class</body></html>";
    }

    /**
     * PUT method for updating or creating an instance of ShowResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content)
    {
        //test commit with renamed Github repo
    }
}
