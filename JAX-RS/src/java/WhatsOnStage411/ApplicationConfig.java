package WhatsOnStage411;

import java.util.Set;
import javax.ws.rs.core.Application;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;


@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application
{
    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
@Path("departments")
public class DepartmentService 
{
    @DELETE
    @Path("{id}")
    public void removeEntity(@PathParam("id") 
    short id) 
    {
        removeEntity(id);
    }
  //Other methods removed for brevity
}


    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources)
    {
        resources.add(WhatsOnStage411.ApplicationConfig.DepartmentService.class);
        resources.add(WhatsOnStage411.ShowResource.class);
        
        
    }

}
