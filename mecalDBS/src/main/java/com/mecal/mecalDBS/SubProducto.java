package com.mecal.mecalDBS;

public class SubProducto {
	
	int _idSubProd;
	int _idMestre;
	String _nom;
	public SubProducto(int _idSubProd, int _idMestre, String _nom) {
		super();
		this._idSubProd = _idSubProd;
		this._idMestre = _idMestre;
		this._nom = _nom;
	}
	public SubProducto()
	{
		super();
	}
	
	public int get_idSubProd() {
		return _idSubProd;
	}
	public void set_idSubProd(int _idSubProd) {
		this._idSubProd = _idSubProd;
	}
	public int get_idMestre() {
		return _idMestre;
	}
	public void set_idMestre(int _idMestre) {
		this._idMestre = _idMestre;
	}
	public String get_nom() {
		return _nom;
	}
	public void set_nom(String _nom) {
		this._nom = _nom;
	}
	

}
