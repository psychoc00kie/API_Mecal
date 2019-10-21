package com.mecal.mecalDBS;

public class Precios_Clientes {

	int _idClient;
	int _idSubProduct;
	float _porcentaje;
	
	public Precios_Clientes(int _idClient, int _idSubProduct, float _porcentaje) {
		super();
		this._idClient = _idClient;
		this._idSubProduct = _idSubProduct;
		this._porcentaje = _porcentaje;
	}
	
	public Precios_Clientes()
	{
		super();
	}
	
	public int get_idClient() {
		return _idClient;
	}
	public void set_idClient(int _idClient) {
		this._idClient = _idClient;
	}
	public int get_idSubProduct() {
		return _idSubProduct;
	}
	public void set_idSubProduct(int _idSubProduct) {
		this._idSubProduct = _idSubProduct;
	}
	public float get_porcentaje() {
		return _porcentaje;
	}
	public void set_porcentaje(float _porcentaje) {
		this._porcentaje = _porcentaje;
	}

	@Override
	public String toString() {
		return "Precios_Clientes [_idClient=" + _idClient + ", _idSubProduct=" + _idSubProduct + ", _porcentaje="
				+ _porcentaje + "]";
	}
}
