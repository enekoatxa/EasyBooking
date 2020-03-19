package DL;

import java.util.ArrayList;

public class erabiltzailea extends pertsona
{
	private String emaila;
	private String nick;
	private String pasahitza;
	private aireportua gustokoAir;
	
	public erabiltzailea(String nan, String izena, String abizena, int adina, String emaila, String nick, String pasahitza, aireportua gustokoAir){
		this.setNan(nan);
		this.setIzena(izena);
		this.setAbizena(abizena);
		this.setAdina(adina);
		this.emaila=emaila;
		this.nick=nick;
		this.pasahitza=pasahitza;
		this.gustokoAir=gustokoAir;
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

	public aireportua getGustokoAir() {
		return gustokoAir;
	}

	public void setGustokoAir(aireportua gustokoAir) {
		this.gustokoAir = gustokoAir;
	}
	
	

}
