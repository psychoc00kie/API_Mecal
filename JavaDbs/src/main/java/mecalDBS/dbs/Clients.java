package mecalDBS.dbs;

//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class Clients {

	public int _id;
	public String _nom;
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
	public Clients() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Clients(int _id, String _nom) {
		super();
		this._id = _id;
		this._nom = _nom;
	}
	
}
