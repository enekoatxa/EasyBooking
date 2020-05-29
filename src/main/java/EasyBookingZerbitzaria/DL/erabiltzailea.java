package EasyBookingZerbitzaria.DL;

import java.io.Serializable;
import java.util.ArrayList;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;

import EasyBookingKlientea.DLDTO.aireportuaDTO;

@PersistenceCapable
public class erabiltzailea extends pertsona implements Serializable  {
	@NotPersistent
	private String emaila;
	@NotPersistent
	private String nick;
	@NotPersistent
	private String pasahitza;

	@Element(column = "ERABILTZAILEA_ID")
	ArrayList<erreserba> erreserbak;

	public erabiltzailea(String nan, String izena, String abizena, int adina, String emaila, String nick,
			String pasahitza) {
		this.setNan(nan);
		this.setIzena(izena);
		this.setAbizena(abizena);
		this.setAdina(adina);
		this.emaila = emaila;
		this.nick = nick;
		this.pasahitza = pasahitza;
		erreserbak = new ArrayList<erreserba>();
	}

	public String getEmaila() {
		return emaila;
	}

	public void setEmaila(String emaila) {
		this.emaila = emaila;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public void addErreserba(erreserba e) {
		erreserbak.add(e);
	}

	public void addGustokoAireportua(aireportua a) {
		a.gehituErabiltzailea(this);
	}

	public void addGustokoAireportua(aireportuaDTO a) {
		a.gehituErabiltzailea(this);
		
	}

}
