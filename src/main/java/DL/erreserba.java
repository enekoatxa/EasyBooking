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
	
	@NotPersistent
	private ArrayList<pertsona> bidaiariak;
	private int bidaiariKopurua;

	
	public erreserba(String kodea, int prezioa, hegaldia heg, 
			ArrayList<pertsona> bidaiariak) {
		super();
		this.kodea = kodea;
		this.prezioa = prezioa;
		this.heg = heg;
		this.bidaiariak = bidaiariak;
		this.bidaiariKopurua= bidaiariak.size();

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
