package DL;

import java.util.ArrayList;

import javax.jdo.annotations.*;

@PersistenceCapable
public class erreserba 
{
	@PrimaryKey
	private String kodea;
	@NotPersistent
	private int prezioa;
	@NotPersistent
	private hegaldia heg;
	@Column(name="ID_ERABILTZAILEA")
	private erabiltzailea erabiltzailea;
	@NotPersistent
	private ArrayList<pertsona> bidaiariak;
	private int bidaiariKopurua;
	@Column(name="ID_AEROLINEA")
	private aerolinea aerolinea;
	
	public erreserba(String kodea, int prezioa, hegaldia heg, DL.erabiltzailea erabiltzailea,
			ArrayList<pertsona> bidaiariak, aerolinea aerolinea) {
		super();
		this.kodea = kodea;
		this.prezioa = prezioa;
		this.heg = heg;
		this.erabiltzailea = erabiltzailea;
		this.bidaiariak = bidaiariak;
		this.bidaiariKopurua= bidaiariak.size();
		this.aerolinea=aerolinea;
	}

	
	public aerolinea getAerolinea() {
		return aerolinea;
	}


	public void setAerolinea(aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}


	public int getBidaiariKopurua() {
		return bidaiariKopurua;
	}


	public void setBidaiariKopurua(int bidaiariKopurua) {
		this.bidaiariKopurua = bidaiariKopurua;
	}


	public String getKodea() {
		return kodea;
	}

	public void setKodea(String kodea) {
		this.kodea = kodea;
	}

	public int getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(int prezioa) {
		this.prezioa = prezioa;
	}

	public hegaldia getHeg() {
		return heg;
	}

	public void setHeg(hegaldia heg) {
		this.heg = heg;
	}

	public erabiltzailea getErabiltzailea() {
		return erabiltzailea;
	}

	public void setErabiltzailea(erabiltzailea erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}

	public ArrayList<pertsona> getBidaiariak() {
		return bidaiariak;
	}

	public void setBidaiariak(ArrayList<pertsona> bidaiariak) {
		this.bidaiariak = bidaiariak;
	}

	
	
	
}
