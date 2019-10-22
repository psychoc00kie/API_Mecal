package mecalDBS.dbs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Productes")
public class Product_Resources {
	
	@GET
	@Path("allMestre")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Mestre_Producte> getProductes()
	{
		return DBS_Main._mestreProducte;
	}
	
	@GET
	@Path("allSubProd")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SubProducto> getSubProd()
	{
		return DBS_Main._subProductos;
	}
	
	@POST
	@Path("addMestre")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addMestre(Mestre_Producte me)
	{
		DBS_Main.addProductes(me);
		DBS_Main.update(2);
		
	}
	
	@POST
	@Path("addSubProd")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addSub(SubProducto sub)
	{
		DBS_Main.addSubProductes(sub);
		DBS_Main.update(4);
	}
	
}
