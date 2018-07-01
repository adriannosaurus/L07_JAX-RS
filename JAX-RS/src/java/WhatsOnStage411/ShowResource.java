package WhatsOnStage411;

import java.util.ArrayList;
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
    private ArrayList<Show> showList;

    public ShowResource()
    {
        showList = new ArrayList();
    }
    
    /**
     * PUT method for updating or creating an instance of ShowResource
     * @param content representation for the resource
     * @return 
     */
    @PUT
    //@Path("create")
    @Consumes(MediaType.TEXT_HTML)
    public String putHtml(String content)
    {
        Show show = new Show(content);
        showList.add(show);
        return "Show added: " + show.getTitle();
    }
    
    /**
     * Retrieves representation of an instance of WhatsOnStage411.ShowResource
     * @return an instance of java.lang.String
     */
    @GET
    //@Path("read")
    @Produces(MediaType.TEXT_HTML)
    public String getHtml()
    {
        return "You have called the getHTML() method in the ShowResource.java class.";
    }
}
