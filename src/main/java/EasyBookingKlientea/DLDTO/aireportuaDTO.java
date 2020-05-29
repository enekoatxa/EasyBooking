package EasyBookingKlientea.DLDTO;

import java.io.Serializable;
import java.util.ArrayList;

import EasyBookingZerbitzaria.DL.erabiltzailea;

public class aireportuaDTO implements Serializable {

	private String kodea;
	private String izena;
	private ArrayList<erabiltzailea> erabiltzaileak;

	
	
	public aireportuaDTO(String kodea, String izena) {
		this.kodea = kodea;
		this.izena = izena;
		erabiltzaileak = new ArrayList<erabiltzailea>();
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

	public String toString() {
		return izena + " (" + kodea + ")";
	}

	public void gehituErabiltzailea(erabiltzailea e) {
		erabiltzaileak.add(e);
	}
	

	

	
}
