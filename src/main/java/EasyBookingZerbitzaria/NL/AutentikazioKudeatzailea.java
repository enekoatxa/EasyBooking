package EasyBookingZerbitzaria.NL;

import java.rmi.RemoteException;

import EasyBookingKlientea.DLDTO.aireportuaDTO;
import EasyBookingZerbitzaria.DL.aireportua;
import EasyBookingZerbitzaria.DL.erabiltzailea;

public class AutentikazioKudeatzailea {

	private static AutentikazioKudeatzailea instance = new AutentikazioKudeatzailea();
	private DAO dao;
	private AutentikazioGateway gateway = new AutentikazioGateway();

	private AutentikazioKudeatzailea() {
		dao = DAO.getInstance();
	}

	public static AutentikazioKudeatzailea getInstance() {
		return instance;
	}

	public boolean sortuErabiltzailea(String email, String izena, String abizena, int adina, String nan, String nick,
			String pasahitza, aireportuaDTO gustokoAireportua) throws RemoteException {
		
		erabiltzailea e = new erabiltzailea(nan, izena, abizena, adina, email, nick, pasahitza);
		e.addGustokoAireportua(gustokoAireportua);

		dao.gordeErabiltzailea(e);
		return gateway.sortuErabiltzailea(email, izena, abizena, adina, nan, nick, pasahitza, gustokoAireportua);

	}

	public boolean ezabatuErabiltzailea(String email, String pasahitza) throws RemoteException {
		dao.ezabatuErabiltzailea(email);

		return gateway.ezabatuErabiltzailea(email, pasahitza);
	}

	public boolean pasahitzaAldatu(String email, String pasahitzZaharra, String pasahitzBerria) throws RemoteException {
		return gateway.pasahitzaAldatu(email, pasahitzZaharra, pasahitzBerria);
	}

	public boolean login(String email, String pasahitza) throws RemoteException {

		return gateway.login(email, pasahitza);

	}

}
