package com.mecal.mecalDBS;

import java.sql.Date;

public class Precios_LME {

	int _id;
	Date fecha;
	int _precio;
	String _nom;
	public Precios_LME(int _id, Date fecha, int _precio, String _nom) {
		super();
		this._id = _id;
		this.fecha = fecha;
		this._precio = _precio;
		this._nom = _nom;
	}
	
	public Precios_LME()
	{
		super();
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int get_precio() {
		return _precio;
	}
	public void set_precio(int _precio) {
		this._precio = _precio;
	}
	public String get_nom() {
		return _nom;
	}
	public void set_nom(String _nom) {
		this._nom = _nom;
	}
}
