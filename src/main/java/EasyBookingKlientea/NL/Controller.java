package EasyBookingKlientea.NL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import EasyBookingKlientea.DLDTO.aireportuaDTO;
import EasyBookingKlientea.DLDTO.hegaldiaDTO;
import EasyBookingKlientea.PL.lHasi;

public class Controller {

	private RMIServiceLocator rsl = null;

	public Controller(String[] args) throws RemoteException {
		rsl = new RMIServiceLocator();
		rsl.setService(args[0], args[1], args[2]);

		lHasi hasi = new lHasi(this);
		hasi.setVisible(true);

	}

	public static void main(String[] args) throws RemoteException {
		Controller c = new Controller(args);
	}

	public void exit() {
		System.exit(0);
	}

	public String sortuErabiltzailea(String email, String izena, String abizena, int adina, String nan, String nick,
			String pasahitza, aireportuaDTO a2) {
		String a = "";
		try {
			a = rsl.getService().sortuErabiltzailea(email, izena, abizena, adina, nan, nick, pasahitza, a2);
		} catch (Exception e) {
			System.err.println("Errorea erabiltzailea sortzerako garaian: " + e.getMessage());
			e.printStackTrace();
		}
		return a;
	}

	public boolean ezabatuErabiltzailea(String email, String pasahitza) throws RemoteException {
		boolean a = true;
		try {
			a = rsl.getService().ezabatuErabiltzailea(email, pasahitza);
		} catch (Exception e) {
			System.err.println("Errorea erabiltzailea ezabatzerako garaian: " + e.getMessage());
		}
		return a;
	}

	public boolean pasahitzaAldatu(String email, String pasahitzZaharra, String pasahitzBerria) throws RemoteException {
		boolean a = true;
		try {
			rsl.getService().pasahitzaAldatu(pasahitzBerria, pasahitzBerria, pasahitzBerria);
		} catch (Exception e) {
			System.err.println("Errorea pasahitza aldatzerako garaian: " + e.getMessage());
		}
		return a;
	}

	public boolean login(String email, String pasahitza) throws RemoteException {
		boolean a = true;
		try {
			a = rsl.getService().login(email, pasahitza);
		} catch (Exception e) {
			System.err.println("Errorea login egiterako garaian: " + e.getMessage());
			e.printStackTrace();
		}
		return a;
	}

	public ArrayList<hegaldiaDTO> hegaldiakBilatu(ArrayList<String> espezifikazioak) throws RemoteException {
		ArrayList<hegaldiaDTO> hegaldiak = new ArrayList<hegaldiaDTO>();
		try {
			hegaldiak = rsl.getService().hegaldiakBilatu(espezifikazioak);
		} catch (Exception e) {
			System.err.println("Errorea helgaldiak bilatzerako garaian: " + e.getMessage());
		}
		return hegaldiak;
	}

	public String ordaindu(String email, float kantitatea, String kontzeptua) throws RemoteException {
		String a = "";
		try {
			a = rsl.getService().ordaindu(email, kantitatea, kontzeptua);
		} catch (Exception e) {
			System.err.println("Errorea ordaintzerako garaian: " + e.getMessage());
		}
		return a;
	}

	public ArrayList<aireportuaDTO> kargatuAireportuak() {
		ArrayList<aireportuaDTO> aireportuak = null;
		try {
			aireportuak = rsl.getService().kargatuAireportuak();
		} catch (Exception e) {
			System.err.println("Errorea aireportuak kargatzerako garaian: " + e.getMessage());
			e.printStackTrace();
		}
		return aireportuak;
	}
}
