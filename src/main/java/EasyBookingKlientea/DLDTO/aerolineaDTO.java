package EasyBookingKlientea.DLDTO;

public class aerolineaDTO {

	private String kodea;
	private String izena;

	public aerolineaDTO(String kodea, String izena) {
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
}
