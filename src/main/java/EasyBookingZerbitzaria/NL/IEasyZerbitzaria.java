package EasyBookingZerbitzaria.NL;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import EasyBookingKlientea.DLDTO.hegaldiaDTO;
import EasyBookingZerbitzaria.DL.aireportua;

public interface IEasyZerbitzaria extends Remote {

	// Erabiltzaileen inguruko metodoak

	public boolean sortuErabiltzailea(String email, String izena, String abizena, int adina, String nan, String nick, String pasahitza, aireportua gustokoAireportua)
			throws RemoteException;

	boolean ezabatuErabiltzailea(String kodea) throws RemoteException;

	boolean pasahitzaAldatu(String email, String pasahitzZaharra, String pasahitzBerria) throws RemoteException;

	boolean login(String email, String pasahitza) throws RemoteException;

	// Hegaldien inguruko metodoak

	ArrayList<hegaldiaDTO> hegaldiakBilatu(ArrayList<String> espezifikazioak) throws RemoteException;

	// Erosketaren inguruko metodoak

	boolean ordaindu(String email, float kantitatea, String kontzeptua) throws RemoteException;
	// emaila automatikoki bidaltzeko aukera

	boolean eguneratuMoneta(String email, float kantitatea) throws RemoteException;

}
