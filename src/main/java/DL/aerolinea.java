package DL;

import java.util.ArrayList;

import javax.jdo.annotations.*;
@PersistenceCapable
public class aerolinea {

	@PrimaryKey
	private String kodea;
	private String izena;
	
	@Element(column="AEROLINEA_ID")
    private ArrayList<erreserba> erreserbak;
    
	public aerolinea(String kodea, String izena) {
		super();
		this.kodea = kodea;
		this.izena = izena;
		this.erreserbak= new ArrayList<erreserba>();
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
		return izena + " (" + kodea +")";
	}
	
	public void addErreserba(erreserba e) {
		erreserbak.add(e);
	}

	public ArrayList<erreserba> getErreserbak() {
		return erreserbak;
	}

	public void setErreserbak(ArrayList<erreserba> erreserbak) {
		this.erreserbak = erreserbak;
	}
	
}
