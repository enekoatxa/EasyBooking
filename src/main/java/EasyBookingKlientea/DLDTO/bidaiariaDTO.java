package EasyBookingKlientea.DLDTO;

public class bidaiariaDTO {

	private String nan;
	private String izena;
	private String abizena;
	private int adina;
	
	public bidaiariaDTO(String nan, String izena, String abizena, int adina) {
		this.nan=nan;
		this.izena=izena;
		this.abizena=abizena;
		this.adina=adina;
	}
	
	public String getNan() {
		return nan;
	}

	public void setNan(String nan) {
		this.nan = nan;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public int getAdina() {
		return adina;
	}

	public void setAdina(int adina) {
		this.adina = adina;
	}
}
