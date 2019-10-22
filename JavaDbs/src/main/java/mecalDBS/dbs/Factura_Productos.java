package mecalDBS.dbs;

public class Factura_Productos {
	

	int _idFactura;
	int	_idSubProd;
	float _porcentaje;
	float _kilos;
	float _precio;
	
	public Factura_Productos()
	{
		super();
	}
	
	public Factura_Productos(int _idFactura, int _idSubProd, float _porcentaje, float _kilos, float _precio) {
		super();
		this._idFactura = _idFactura;
		this._idSubProd = _idSubProd;
		this._porcentaje = _porcentaje;
		this._kilos = _kilos;
		this._precio = _precio;
	}
	public int get_idFactura() {
		return _idFactura;
	}
	public void set_idFactura(int _idFactura) {
		this._idFactura = _idFactura;
	}
	public int get_idSubProd() {
		return _idSubProd;
	}
	public void set_idSubProd(int _idSubProd) {
		this._idSubProd = _idSubProd;
	}
	public float get_porcentaje() {
		return _porcentaje;
	}
	public void set_porcentaje(float _porcentaje) {
		this._porcentaje = _porcentaje;
	}
	public float get_kilos() {
		return _kilos;
	}
	public void set_kilos(float _kilos) {
		this._kilos = _kilos;
	}
	public float get_precio() {
		return _precio;
	}
	public void set_precio(float _precio) {
		this._precio = _precio;
	}
	

}
