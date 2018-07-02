package WhatsOnStage411;

import java.util.ArrayList;
import javax.ws.rs.core.*;
import javax.ws.rs.*;

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

    @POST
    //@Path("create")
    @Consumes(MediaType.TEXT_HTML)
    public String createShow(String content)
    {
        Show show = new Show(content);
        showList.add(show);
        return "Show added: " + show.getTitle();
    }

    @GET
    //@Path("read")
    @Produces(MediaType.TEXT_HTML)
    public String getShow()
    {
        String toReturn = "   ";
        showList.add(new Show("Show 1"));
        showList.add(new Show("Show 2"));
        showList.add(new Show("Show 3"));
        showList.add(new Show("Show 4"));
        
        if (!showList.isEmpty())
        {
            for (int i = 1; i <= showList.size(); ++i)
            {
                toReturn += (showList.get(i-1).getTitle());
                if (i != showList.size())
                {
                    toReturn += "   ||   ";
                }
            }
            return toReturn;
        }
        else
        {
            return "The list is empty";
        }
        
    }
    
//    @PUT
//    //@Path("update")
//    @Consumes(MediaType.TEXT_HTML)
//    public String putShow(String content)
//    {
//        Show show = new Show(content);
//        showList.add(show);
//        return "Show added: " + show.getTitle();
//    }
    
    @DELETE
    @Path("delete")
    public void deleteShow()
    {
        //
    }
    
}