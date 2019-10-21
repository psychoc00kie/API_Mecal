package com.mecal.mecalDBS;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("/LME")
public class LME_Resources {
	
	@GET
	@Path("/today")
	@Produces(MediaType.APPLICATION_JSON)
	public Precios_LME today_Lme()
	{
		Date hoy = new Date();
		Precios_LME temp = new Precios_LME();
		for(Precios_LME tem : DBS_Main._lme)
		{
			if(tem.getFecha().getDay()==hoy.getDay())
				temp =tem;
		}
		return temp;
	}

}
