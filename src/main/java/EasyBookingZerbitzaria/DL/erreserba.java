package EasyBookingZerbitzaria.DL;

import java.util.ArrayList;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class erreserba {
	@PrimaryKey
	private String kodea;
	@NotPersistent
	private int prezioa;
	@NotPersistent
	private hegaldia heg;
	@NotPersistent
	private ArrayList<pertsona> bidaiariak;
	private int bidaiariKopurua;
	@NotPersistent
	private erabiltzailea erabiltzailea;

	public erreserba(String kodea, int prezioa, hegaldia heg, ArrayList<pertsona> bidaiariak,
			erabiltzailea erabiltzailea) {
		super();
		this.kodea = kodea;
		this.prezioa = prezioa;
		this.heg = heg;
		this.bidaiariak = bidaiariak;
		this.bidaiariKopurua = bidaiariak.size();
		this.erabiltzailea = erabiltzailea;
		erabiltzailea.addErreserba(this);
		heg.getAerolinea().addErreserba(this);

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

	public ArrayList<pertsona> getBidaiariak() {
		return bidaiariak;
	}

	public void setBidaiariak(ArrayList<pertsona> bidaiariak) {
		this.bidaiariak = bidaiariak;
	}

}
