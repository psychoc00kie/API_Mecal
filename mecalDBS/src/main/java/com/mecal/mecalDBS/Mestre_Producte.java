package com.mecal.mecalDBS;

public class Mestre_Producte {

	int _id;
	String _nom;
	
	public Mestre_Producte(int _id, String _nom) {
		super();
		this._id = _id;
		this._nom = _nom;
	}
	public Mestre_Producte()
	{
		super();
	}
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String get_nom() {
		return _nom;
	}
	public void set_nom(String _nom) {
		this._nom = _nom;
	}
	
}
