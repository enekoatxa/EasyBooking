package DL;

import java.util.ArrayList;

public class erreserba 
{
	private String kodea;
	private int prezioa;
	private hegaldia heg;
	private erabiltzailea erabiltzailea;
	private ArrayList<bidaiaria> bidaiariak;
	
	public erreserba(String kodea, int prezioa, hegaldia heg, DL.erabiltzailea erabiltzailea,
			ArrayList<bidaiaria> bidaiariak) {
		super();
		this.kodea = kodea;
		this.prezioa = prezioa;
		this.heg = heg;
		this.erabiltzailea = erabiltzailea;
		this.bidaiariak = bidaiariak;
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

	public ArrayList<bidaiaria> getBidaiariak() {
		return bidaiariak;
	}

	public void setBidaiariak(ArrayList<bidaiaria> bidaiariak) {
		this.bidaiariak = bidaiariak;
	}

	
	
	
}
