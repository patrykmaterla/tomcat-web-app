package webservices;

import com.google.gson.Gson;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.annotation.PostConstruct;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import pl.webapplicationservlet.data.*;


@Path("webservices")
public class WebserviceDane {

  @Context
  private UriInfo context;
  
  public WebserviceDane() {}

  @PostConstruct
  public void webServiceDaneInitialize() {
	 context.getBaseUri().toString();
  }
  
  /**
   * Retrieves representation of an instance of webservices.WebserviceDane
   * @return an instance of java.lang.String
   */
//  @GET
//  @Produces(MediaType.APPLICATION_JSON)
//	 @Produces({"application/json"})
//  public List<User> getJson() {
//	 return UserDAO.selectAllUsers();
//  }
  
  @GET
//@Produces(MediaType.APPLICATION_JSON)
  public String getJson() {
	 String json = new Gson().toJson(UserDAO.selectAllUsers());
	 return json;
  }

  /**
   * PUT method for updating or creating an instance of WebserviceDane
   * @param content representation for the resource
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public void putJson(String content) {}
}