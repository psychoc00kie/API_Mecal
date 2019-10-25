package mecalDBS.dbs;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.core.Response;

import java.sql.*;

public class DBS_Main {
	
	public static List<Clients> _clients = new LinkedList<Clients> (); 
	public static List<Mestre_Producte> _mestreProducte = new LinkedList<Mestre_Producte> ();
	public static List<Precios_LME> _lme = new LinkedList<Precios_LME> ();
	public static List<SubProducto> _subProductos = new LinkedList<SubProducto> ();
	public static List<Precios_Clientes> _preciosClientes = new LinkedList<Precios_Clientes>();
	public static List<Factura_Cabecera> _facturaCabecera = new LinkedList<Factura_Cabecera>();
	public static List<Factura_Productos> _facturaProductos = new LinkedList<Factura_Productos>();

	public static void main(){
		
		
		
		
	}
	
	public static void addClients(Clients cli)
	{
		_clients.add(cli); // add clients a lista local
		try {
			Connection myConection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mecal","root","root");
			//once we are conected to dbs we genereate statement 
			Statement myStatement = myConection.createStatement();
			String sql ="insert into clients(idClients,Nom) values("+cli.get_id()+",'"+cli.get_nom()+"')";
			myStatement.executeLargeUpdate(sql);
			myConection.close();
			
		}catch(Exception excp){
			excp.printStackTrace();
		}
		
	}
	
	public static void addProductes(Mestre_Producte prod)
	{
		_mestreProducte.add(prod); // anadir producto a lista local mestre producte
		
		try {
			Connection myConection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mecal","root","root");
			//once we are conected to dbs we genereate statement 
			Statement myStatement = myConection.createStatement();
			String sql ="insert into Mestre_Producte(idMestre_Producte,Nom) values("+prod.get_id()+",'"+prod.get_nom()+"')";
			myStatement.executeLargeUpdate(sql);
			myConection.close();
			
			
		}catch(Exception excp){
			excp.printStackTrace();
		}
		
	}
	
	public static void addSubProductes(SubProducto prod)
	{
		_subProductos.add(prod); // anadir producto a lista local mestre producte
		
		try {
			Connection myConection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mecal","root","root");
			//once we are conected to dbs we genereate statement 
			Statement myStatement = myConection.createStatement();
			String sql ="insert into SubProducto(idSubproducto,idMestre,Nom) values("+prod.get_idSubProd()+","+prod.get_idMestre()+",'"+prod.get_nom()+"')";
			myStatement.executeLargeUpdate(sql);
			myConection.close();
			
			
		}catch(Exception excp){
			excp.printStackTrace();
		}
		
	}
	
	//Generar una lista de precios DEFAULT para nuevos clientes
	
	public static void listaPreciosDefault(int id)
	{
		try {
			Connection myConection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mecal","root","root");
			//once we are conected to dbs we genereate statement 
			Statement myStatement = myConection.createStatement();
			
			int i = _subProductos.size();
			for( i = 1; i<=13;i++)
			{
				String sql = "insert into Preus_Client (idClient,idSubPro,Percentatje) values("+id+","+i+",0.5)";
				myStatement.executeUpdate(sql);
			}

			
		}catch(Exception excp)
		{
			excp.printStackTrace();
		}
	}
	
	// carga los datos de la base de datos tanto para load como update
	/*
	 *  1) clientes
	 *  2) mestre product
	 *  3)lme
	 *  4)subprod
	 *  5) precios clientes
	 *  6) fact cabecera
	 *  7) factrua productos
	 */
	public static void load(int opt)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection myConection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mecal","root","root");
			System.out.println("connected!!");
			
			// create a statement
			Statement myStatement = myConection.createStatement();
			ResultSet result = myStatement.executeQuery("select * from Clients");
			
			// copy tables
		if(opt ==1) {
			// tabla clientes 
			System.out.println("Tabla Clientes \n");
			while(result.next()){
				
				Clients temp = new Clients();
				temp.set_id(Integer.parseInt(result.getString("idClients")));
				temp.set_nom(result.getNString("Nom"));
				_clients.add(temp);	
			}
			
			for( int i= 0;i<_clients.size();i++)
			{
				System.out.println(_clients.get(i).get_id()+"	"+_clients.get(i).get_nom());
			}
		}else if(opt ==2) {
			
			// tabla Mestre Producte
			System.out.println("\n Tabla Mestre Producte \n");

			
			result = myStatement.executeQuery("select * from Mestre_Producte");
			while(result.next())
			{
				Mestre_Producte _mestre = new Mestre_Producte();
				_mestre.set_id(Integer.parseInt(result.getString("idMestre_Producte")));
				_mestre.set_nom(result.getString("Nom"));
				_mestreProducte.add(_mestre);
			}
			for(int i =0;i<_mestreProducte.size();i++)
			{
				System.out.println(_mestreProducte.get(i).get_id()+"	"+_mestreProducte.get(i).get_nom());
			}
		}else if(opt ==3) {	
			
			// Tabla LME 
			
			System.out.println("\n Tabla LME \n");
			result = myStatement.executeQuery("select * from Preus_LME");
			
			while(result.next())
			{
				Precios_LME lme = new Precios_LME();
				lme.set_id(Integer.parseInt(result.getString("idPreus_LME")));
				lme.set_nom(result.getString("Nom"));
				lme.set_precio(Integer.parseInt(result.getString("Preu")));
				lme.setFecha(result.getDate("Data"));
				_lme.add(lme);
			}
			
			for(int i = 0;i<_lme.size();i++)
			{
				System.out.println(_lme.get(i).get_id()+"	"+_lme.get(i).get_nom()+"	"+_lme.get(i).get_precio()+"	"+_lme.get(i).getFecha());
			}
		}else if(opt ==4) {
			// Tabla Subproductos
			
			System.out.println("\n Tabla SubProductos \n");
			result = myStatement.executeQuery("select * from Subproducto");
			
			while(result.next())
			{
				SubProducto _subpro = new SubProducto();
				_subpro.set_idMestre(Integer.parseInt(result.getString("idMestre")));
				_subpro.set_idSubProd(Integer.parseInt(result.getString("idSubPro")));
				_subpro.set_nom(result.getString("Nom"));
				_subProductos.add(_subpro);
			}
			
			for(int i = 0;i<_subProductos.size();i++)
			{
				System.out.println(_subProductos.get(i).get_idSubProd()+"	"+_subProductos.get(i).get_idMestre()+"		"+_subProductos.get(i).get_nom());
			}
		}else if(opt ==5) {
			// Tabla Precios Cliente
			
			System.out.println("\n Tabla de precios para clientes \n");
			result = myStatement.executeQuery("select * from Preus_Client");
			
			while(result.next())
			{
				Precios_Clientes preus = new Precios_Clientes();
				preus.set_idClient(Integer.parseInt(result.getString("idClient")));
				preus.set_idSubProduct(Integer.parseInt(result.getString("idSubPro")));
				preus.set_porcentaje(Float.parseFloat(result.getString("percentatje")));
				_preciosClientes.add(preus);
				
			}
			
			for(Precios_Clientes precios : _preciosClientes)
			{
				System.out.println(precios.get_idClient()+"		"+precios.get_idSubProduct()+"		"+precios.get_porcentaje());
			}
		}else if(opt==6) {	
			// tabla factura cabecera 
			
			System.out.println("\n Tabla de Factura Cabecera \n");
			result =myStatement.executeQuery("select * from FRA_Cabecera");
			
			while(result.next())
			{
				Factura_Cabecera factura = new Factura_Cabecera();
				factura.set_idFactura(Integer.parseInt(result.getString("idFactura")));
				factura.set_idClient(Integer.parseInt(result.getString("idCliente")));
				factura.set_fechaFac(result.getDate("Fecha"));
				_facturaCabecera.add(factura);
			}
			
			for(Factura_Cabecera factura : _facturaCabecera)
			{
				System.out.println(factura.get_idFactura()+"	"+factura.get_idClient()+"	"+factura.get_fechaFac());
			}
		}else if(opt == 7) {	
			// tabla factura productos
			
			System.out.println("\n Tabla de Factura Productos \n");
			result = myStatement.executeQuery("select * from Items_Factura");
			
			while(result.next())
			{
				Factura_Productos factura = new Factura_Productos();
				factura.set_idFactura(Integer.parseInt(result.getString("idFactura")));
				factura.set_idSubProd(Integer.parseInt(result.getString("idSubProd")));
				factura.set_kilos(Float.parseFloat(result.getString("Kilos")));
				factura.set_porcentaje(Float.parseFloat(result.getString("Porcent")));
				factura.set_precio(Float.parseFloat(result.getString("Precio")));
				_facturaProductos.add(factura);
			}
			
			for(Factura_Productos factura : _facturaProductos)
			{
				System.out.println(factura.get_idFactura()+"	"+factura.get_idSubProd()+"	"+factura.get_kilos()+"	"+factura.get_porcentaje()+"	"+factura.get_precio());
			}

		}	
			myConection.close();
			
			
		}catch(Exception excp){
			excp.printStackTrace();
			
		}
		
		
		
	}
	
	// actualiza los datos de la base de datos con los datos del programa
	public static void update(int opt)
	{
		switch(opt)
		{
		case 1:
			_clients = new LinkedList<Clients>();
			load(1);
			break;
			
		case 2:
			_mestreProducte = new LinkedList<Mestre_Producte> ();
			load(2);
			break;
			
		case 3:
			_lme = new LinkedList<Precios_LME> ();
			load(3);
			break;
			
		case 4:
			_subProductos = new LinkedList<SubProducto> ();
			load(4);
			break;
			
		case 5:
			_preciosClientes = new LinkedList<Precios_Clientes>();
			load(5);
			break;
			
		case 6:
			_facturaCabecera = new LinkedList<Factura_Cabecera>();
			load(6);
			break;
			
		case 7:
			_facturaProductos = new LinkedList<Factura_Productos>();
			load(7);
			break;
		}
		
	}
	
	public static void SubProNom()
	{
		for(Precios_Clientes precio: _preciosClientes) {
			for(SubProducto sub:_subProductos) {
				
				if(precio.get_idSubProduct()==sub.get_idSubProd()) {
					precio.set_nomSubProd(sub.get_nom());
				}
				
			}
			
		}
	}
	
	public static Clients selectClient(String id)
	{
		for (Clients client : DBS_Main._clients)
		{
			if(client.get_id()==Integer.parseInt(id))
			{
				System.out.println(client.toString());
				return client;
				
			}
				
		}
		return null;
	}
	
	
}


 
