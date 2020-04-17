package EasyBookingZerbitzaria.DL;

import java.util.ArrayList;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class aireportua {
	@PrimaryKey
	private String kodea;

	private String izena;

	@Element(column = "GUSTOKO_AIR")
	private ArrayList<erabiltzailea> erabiltzaileak;

	public aireportua(String kodea, String izena) {
		super();
		erabiltzaileak = new ArrayList<erabiltzailea>();
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
		return izena + " (" + kodea + ")";
	}

	public void addErabiltzailea(erabiltzailea e) {
		erabiltzaileak.add(e);
	}

	public ArrayList<erabiltzailea> getErabiltzaileak() {
		return erabiltzaileak;
	}

	public void setErabiltzaileak(ArrayList<erabiltzailea> erabiltzaileak) {
		this.erabiltzaileak = erabiltzaileak;
	}

	public void gehituErabiltzailea(erabiltzailea e) {
		erabiltzaileak.add(e);
	}

}
