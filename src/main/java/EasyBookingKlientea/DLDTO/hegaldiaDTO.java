package EasyBookingKlientea.DLDTO;

import java.util.Date;

public class hegaldiaDTO {

	private aireportuaDTO irteera;
	private aireportuaDTO helmuga;
	private double denbora;
	private double prezioa;
	private Date data;
	private aerolineaDTO aerolinea;

	public hegaldiaDTO(aireportuaDTO irteera, aireportuaDTO helmuga, double denbora, double prezioa, Date data,
			aerolineaDTO aerolinea) {
		this.irteera = irteera;
		this.helmuga = helmuga;
		this.denbora = denbora;
		this.prezioa = prezioa;
		this.data = data;
		this.aerolinea = aerolinea;
	}

	public aireportuaDTO getIrteera() {
		return irteera;
	}

	public void setIrteera(aireportuaDTO irteera) {
		this.irteera = irteera;
	}

	public aireportuaDTO getHelmuga() {
		return helmuga;
	}

	public void setHelmuga(aireportuaDTO helmuga) {
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

	public aerolineaDTO getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(aerolineaDTO aerolinea) {
		this.aerolinea = aerolinea;
	}

}
