package mecalDBS.dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	Connection conn = null;
    	String url = "jdbc:mysql://localhost:3306/mecal";
    	String usr = "root";
    	String pass = "root";
    	
   
    	try {
    	
    	    conn =
    	       DriverManager.getConnection(url,usr,pass);

    	    // Do something with the Connection
    	    

    
    	} catch (SQLException ex) {
    	    // handle any errors
    	    System.out.println("SQLException: " + ex.getMessage());
    	    System.out.println("SQLState: " + ex.getSQLState());
    	    System.out.println("VendorError: " + ex.getErrorCode());
    	}
    	
        return "Got it!";
    }
}
