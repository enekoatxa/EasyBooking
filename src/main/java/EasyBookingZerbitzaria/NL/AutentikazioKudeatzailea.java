package EasyBookingZerbitzaria.NL;

import EasyBookingZerbitzaria.DL.aireportua;
import EasyBookingZerbitzaria.DL.erabiltzailea;

public class AutentikazioKudeatzailea {

	private static AutentikazioKudeatzailea instance = new AutentikazioKudeatzailea();
	private DAO dao;
	
	private AutentikazioKudeatzailea() {
		dao = DAO.getInstance();
	}
	
	public static AutentikazioKudeatzailea getInstance() {
		return instance;
	}
	
	public boolean sortuErabiltzailea(String email, String izena, String abizena, int adina, String nan, String nick, String pasahitza, aireportua gustokoAireportua) {
		erabiltzailea e = new erabiltzailea(nan, izena, abizena, adina, email, nick, pasahitza);
		e.addGustokoAireportua(gustokoAireportua);
		
		//deitu mikrozerbitzura

		dao.gordeErabiltzailea(e);
		return false;
	}

	public boolean ezabatuErabiltzailea(String email) {
		//
		
		dao.ezabatuErabiltzailea(email);
		
		//deitu mikrozerbitzura
		return false;
	}

	public boolean pasahitzaAldatu(String email, String pasahitzZaharra, String pasahitzBerria) {
		//deitu mikrozerbitzura
		return false;
	}

	public boolean login(String email, String pasahitza) {
		//deitu mikrozerbitzura
		return false;
	}
	
}
