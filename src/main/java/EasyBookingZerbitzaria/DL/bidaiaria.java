package EasyBookingZerbitzaria.DL;

import java.io.Serializable;

public class bidaiaria extends pertsona implements Serializable{

	public bidaiaria(String nan, String izena, String abizena, int adina) {
		this.setNan(nan);
		this.setIzena(izena);
		this.setAbizena(abizena);
		this.setAdina(adina);
	}

	@Override
	public String toString() {
		return "Izena: " + this.getIzena() + "Abizena: " + this.getAbizena();
	}

}
