package EasyBookingZerbitzaria.DL;

import java.util.Date;

public class hegaldia implements Comparable<hegaldia> {

	private String kodea;
	private aireportua irteera;
	private aireportua helmuga;
	private double denbora;
	private double prezioa;
	private Date data;
	private int eserlekuLibreak;
	private aerolinea aerolinea;

	public hegaldia(String kodea, aireportua irteera, aireportua helmuga, double denbora, double prezioa, Date data,
			int eserlekuLibreak, aerolinea aerolinea) {
		super();
		this.kodea = kodea;
		this.irteera = irteera;
		this.helmuga = helmuga;
		this.denbora = denbora;
		this.prezioa = prezioa;
		this.data = data;
		this.eserlekuLibreak = eserlekuLibreak;
		this.aerolinea = aerolinea;
	}

	public String getKodea() {
		return kodea;
	}

	public void setKodea(String kodea) {
		this.kodea = kodea;
	}

	public aireportua getIrteera() {
		return irteera;
	}

	public void setIrteera(aireportua irteera) {
		this.irteera = irteera;
	}

	public aireportua getHelmuga() {
		return helmuga;
	}

	public void setHelmuga(aireportua helmuga) {
		this.helmuga = helmuga;
	}

	public double getDenbora() {
		return denbora;
	}

	public void setDenbora(double denbora) {
		this.denbora = denbora;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getEserlekuLibreak() {
		return eserlekuLibreak;
	}

	public void setEserlekuLibreak(int eserlekuLibreak) {
		this.eserlekuLibreak = eserlekuLibreak;
	}

	public aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	public int compareTo(hegaldia o) {
		if (this.prezioa < o.prezioa) {
			return -1;
		}
		if (this.prezioa > o.prezioa) {
			return 1;
		}
		return 0;
	}

}
