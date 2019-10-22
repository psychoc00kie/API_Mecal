package mecalDBS.dbs;




import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("Clients") 
public class ClientResources {
	
	@GET
	@Path("/load")
	@Produces(MediaType.APPLICATION_JSON)
	public void load()
	{
		for (int i =1;i<8;i++)
			DBS_Main.load(i);
	}
	
	@GET
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	public void update()
	{
		for(int i =1;i<=7;i++)
			DBS_Main.update(i);

	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Clients> getClient()
	{
		
		return DBS_Main._clients;
	}
	
	@GET
	@Path("/select/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response select(@PathParam("name")String name)
	{
		for (Clients client : DBS_Main._clients)
		{
			if(client.get_nom().equalsIgnoreCase(name))
				return Response.status(200).entity(client).build();
		}

		return Response.status(404).entity("client not found").build();
	}
	
	@GET
	@Path("/select/{name}/precios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Precios_Clientes> selectprecios(@PathParam("name")String name)
	{
		List<Precios_Clientes> temp = new ArrayList<Precios_Clientes>();
		
		for (Clients client : DBS_Main._clients)
		{
			if(client.get_nom().equalsIgnoreCase(name))
			{
				for(Precios_Clientes precios : DBS_Main._preciosClientes)
				{
					if(precios.get_idClient() == client.get_id()) 
					{
						temp.add(precios);
					}
				}
			}
				
		}
		
		return temp;
		
		
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addClient(Clients c1)
	{
		c1.set_id(DBS_Main._clients.get(DBS_Main._clients.size()-1).get_id()+1);
		DBS_Main.addClients(c1);
		DBS_Main.listaPreciosDefault(c1.get_id());
		DBS_Main.update(1);
		DBS_Main.update(5);
	}

}
