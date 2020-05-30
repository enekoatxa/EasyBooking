package EasyBookingZerbitzaria.NL.Kudeatzaileak;

import java.rmi.RemoteException;

import EasyBookingKlientea.DLDTO.aireportuaDTO;
import EasyBookingZerbitzaria.DL.aireportua;
import EasyBookingZerbitzaria.DL.erabiltzailea;
import EasyBookingZerbitzaria.NL.DAO.DAO;
import EasyBookingZerbitzaria.NL.Gateway.AutentikazioGateway;

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

	public String sortuErabiltzailea(String email, String izena, String abizena, int adina, String nan, String nick, String pasahitza, aireportuaDTO gustokoAireportua) throws RemoteException {
		erabiltzailea e = new erabiltzailea(nan, izena, abizena, adina, email, nick, pasahitza);
		aireportua aBerria = new aireportua(gustokoAireportua.getKodea(), gustokoAireportua.getIzena());
		e.addGustokoAireportua(aBerria);
		String pass = gateway.sortuErabiltzailea(email, izena, abizena, adina, nan, nick, pasahitza, gustokoAireportua);
		e.setPasahitza(pass);
		dao.gordeErabiltzailea(e);
		return pass;

	}

	public boolean ezabatuErabiltzailea(String email, String pasahitza) throws RemoteException {
		dao.ezabatuErabiltzailea(email);
		return gateway.ezabatuErabiltzailea(email, pasahitza);
	}

	public boolean pasahitzaAldatu(String email, String pasahitzZaharra, String pasahitzBerria) throws RemoteException {
		boolean ret = gateway.pasahitzaAldatu(email, pasahitzZaharra, pasahitzBerria);
		if (ret) dao.aldatuPasahitza(email, pasahitzBerria);
		return ret;
	}

	public boolean login(String email, String pasahitza) throws RemoteException {
		return gateway.login(email, pasahitza);

	}

}
