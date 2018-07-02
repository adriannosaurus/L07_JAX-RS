package WhatsOnStage411;

import java.util.ArrayList;
import javax.ws.rs.core.*;
import javax.ws.rs.*;

@Path("show")
public class ShowResource
{
    @Context
    private UriInfo context;
    private ArrayList<Show> showList = new ArrayList();

    public ShowResource()
    {
        //
    }
    
    @POST
    //@Path("create")
    @Consumes(MediaType.TEXT_HTML)
    //public String createShow(@HeaderParam("Referer") String referer, String content)
    public String createShow(String content)
    {
        //logSource(referer);
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
        showList.add(new Show("Phantom of the Opera"));
        showList.add(new Show("Les Miserables"));
        showList.add(new Show("Book of Mormon"));
        showList.add(new Show("Legally Blonde"));
        
        if (!showList.isEmpty())
        {
            for (int i = 1; i <= showList.size(); ++i)
            {
                toReturn += ("(" + i + ")  " + showList.get(i-1).getTitle());
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
    
    //Input should be formatted index/newtitle. Bulk of the method below separates the input into substrings
    @PUT
    //@Path("update")
    @Consumes(MediaType.TEXT_HTML)
    public String putShow(String input)
    {
        showList.add(new Show("Phantom of the Opera"));
        showList.add(new Show("Les Miserables"));
        showList.add(new Show("Book of Mormon"));
        showList.add(new Show("Legally Blonde"));
        
        int shownum = 0;
        String newTitle = "";
        String x = "";
        
        for(int i = 0; i < input.length(); ++i)
        {
            char z = input.charAt(i);
            if(z != '/')
            {
                x += (String) x;
            }
            else
            {
                shownum = Integer.parseInt(x);
                newTitle = input.substring(i + 1);
                break;
            }
        }
        
        Show toEdit = showList.get(shownum - 1);
        toEdit.setTitle(newTitle);
        
        return "Show " + shownum + " renamed to: " + newTitle;
    }
    
    @DELETE
    //@Path("delete")
    @Produces(MediaType.TEXT_HTML)
    public String deleteShow(String update)
    {
        int i = Integer.parseInt(update);
        Show delete = showList.get(i);
        showList.remove(delete);

        return delete.getTitle() + " has been deleted";
    }
    
}