package mecalDBS.dbs;

import java.sql.Date;

public class Factura_Cabecera {
	public Factura_Cabecera() {
		super();
		// TODO Auto-generated constructor stub
	}
	int _idFactura;
	Date _fechaFac;
	int _idClient;
	public Factura_Cabecera(int _idFactura, Date _fechaFac, int _idClient) {
		super();
		this._idFactura = _idFactura;
		this._fechaFac = _fechaFac;
		this._idClient = _idClient;
	}
	public int get_idFactura() {
		return _idFactura;
	}
	public void set_idFactura(int _idFactura) {
		this._idFactura = _idFactura;
	}
	public Date get_fechaFac() {
		return _fechaFac;
	}
	public void set_fechaFac(Date _fechaFac) {
		this._fechaFac = _fechaFac;
	}
	public int get_idClient() {
		return _idClient;
	}
	public void set_idClient(int _idClient) {
		this._idClient = _idClient;
	}

}
