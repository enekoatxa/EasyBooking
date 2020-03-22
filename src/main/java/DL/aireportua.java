package DL;

import javax.jdo.annotations.*;
@PersistenceCapable
public class aireportua {
	@PrimaryKey
	private String kodea;
	
	private String izena;
	
	public aireportua(String kodea, String izena) {
		super();
		this.kodea = kodea;
		this.izena = izena;
	}

	public String getKodea() {
		return kodea;
	}

	public void setKodea(String kodea) {
		this.kodea = kodea;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	@Override
	public String toString() {
		return izena + " (" + kodea + ")" ;
	}
	
	
}
