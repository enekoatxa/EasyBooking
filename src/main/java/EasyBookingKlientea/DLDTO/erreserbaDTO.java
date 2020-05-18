package EasyBookingKlientea.DLDTO;

public class erreserbaDTO {

	private String kodea;
	private int prezioa;
	private hegaldiaDTO heg;
	private int bidaiariKopurua;
	private erabiltzaileaDTO erabiltzailea;

	public erreserbaDTO(String kodea, int prezioa, hegaldiaDTO heg, int bidaiariKopurua) {
		this.kodea = kodea;
		this.prezioa = prezioa;
		this.heg = heg;
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

	public hegaldiaDTO getHeg() {
		return heg;
	}

	public void setHeg(hegaldiaDTO heg) {
		this.heg = heg;
	}

	public int getBidaiariKopurua() {
		return bidaiariKopurua;
	}

	public void setBidaiariKopurua(int bidaiariKopurua) {
		this.bidaiariKopurua = bidaiariKopurua;
	}

	public erabiltzaileaDTO getErabiltzailea() {
		return erabiltzailea;
	}

	public void setErabiltzailea(erabiltzaileaDTO erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}

}
