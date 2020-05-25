package EasyBookingKlientea.DLDTO;

import java.io.Serializable;

public class aireportuaDTO implements Serializable {

	private String kodea;
	private String izena;

	public aireportuaDTO(String kodea, String izena) {
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

	public String toString() {
		return izena + " (" + kodea + ")";
	}

	public void gehituErabiltzailea(erabiltzaileaDTO erabiltzailea) {
		// TODO Auto-generated method stub
		
	}

	
}
