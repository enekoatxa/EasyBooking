package EasyBookingKlientea.DLDTO;

import java.io.Serializable;

public class erabiltzaileaDTO implements Serializable {

	private String emaila;
	private String nick;
	private String pasahitza;

	public erabiltzaileaDTO(String emaila, String nick, String pasahitza) {
		this.emaila = emaila;
		this.nick = nick;
		this.pasahitza = pasahitza;
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
