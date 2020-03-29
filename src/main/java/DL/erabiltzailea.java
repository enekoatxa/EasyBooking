package DL;

import java.util.Collection;

import javax.jdo.annotations.*;

@PersistenceCapable
public class erabiltzailea extends pertsona
{
	@NotPersistent
	private String emaila;
	@NotPersistent
	private String nick;
	@NotPersistent
	private String pasahitza;
	
	@Element(column="Erabiltzailea_ID")
    Collection<erreserba> erreserbak;
	
	public erabiltzailea(String nan, String izena, String abizena, int adina, String emaila, String nick, String pasahitza){
		this.setNan(nan);
		this.setIzena(izena);
		this.setAbizena(abizena);
		this.setAdina(adina);
		this.emaila=emaila;
		this.nick=nick;
		this.pasahitza=pasahitza;
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
	
	

}
