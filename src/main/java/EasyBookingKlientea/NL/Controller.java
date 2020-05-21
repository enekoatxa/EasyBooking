package EasyBookingKlientea.NL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import EasyBookingKlientea.PL.lHasi;
import EasyBookingZerbitzaria.DL.aireportua;

public class Controller {

	private RMIServiceLocator rsl = null;

	public Controller(String[] args) throws RemoteException {
		rsl = new RMIServiceLocator();
		rsl.setService(args[0], args[1], args[2]);
		lHasi hasi = new lHasi();
		hasi.setVisible(true);
	}

	public static void main(String[] args) throws RemoteException {
		Controller c = new Controller(args);
	}

	public void exit() {
		System.exit(0);
	}

	public void sortuErabiltzailea(String email, String izena, String abizena, int adina, String nan, String nick,
			String pasahitza, aireportua gustokoAireportua) {
		try {
			rsl.getService().sortuErabiltzailea(email, izena, abizena, adina, nan, nick, pasahitza, gustokoAireportua);
		} catch (Exception e) {
			System.err.println("Errorea erabiltzailea sortzerako garaian: " + e.getMessage());
		}
	}

	public void ezabatuErabiltzailea(String kodea) throws RemoteException {
		try {
			rsl.getService().ezabatuErabiltzailea(kodea);
		} catch (Exception e) {
			System.err.println("Errorea erabiltzailea ezabatzerako garaian: " + e.getMessage());
		}
	}

	public void pasahitzaAldatu(String email, String pasahitzZaharra, String pasahitzBerria) throws RemoteException {
		try {
			rsl.getService().pasahitzaAldatu(pasahitzBerria, pasahitzBerria, pasahitzBerria);
		} catch (Exception e) {
			System.err.println("Errorea pasahitza aldatzerako garaian: " + e.getMessage());
		}
	}

	public void login(String email, String pasahitza, String autentikazioZerbitzua) throws RemoteException {
		try {
			rsl.getService().login(email, pasahitza, autentikazioZerbitzua);
		} catch (Exception e) {
			System.err.println("Errorea login egiterako garaian: " + e.getMessage());
		}
	}

	public void hegaldiakBilatu(ArrayList<String> espezifikazioak) throws RemoteException {
		try {
			rsl.getService().hegaldiakBilatu(espezifikazioak);
		} catch (Exception e) {
			System.err.println("Errorea helgaldiak bilatzerako garaian: " + e.getMessage());
		}
	}

	public void eguneratuMoneta(String email, float kantitatea) throws RemoteException {
		try {
			rsl.getService().eguneratuMoneta(email, kantitatea);
		} catch (Exception e) {
			System.err.println("Errorea helgaldiak bilatzerako garaian: " + e.getMessage());
		}
		
	}
	
	public void ordaindu(String email, float kantitatea, String kontzeptua) throws RemoteException {
		
		try {
			rsl.getService().ordaindu(email, kantitatea, kontzeptua);
		} catch (Exception e) {
			System.err.println("Errorea ordaintzerako garaian: " + e.getMessage());
	} 
		
}}
