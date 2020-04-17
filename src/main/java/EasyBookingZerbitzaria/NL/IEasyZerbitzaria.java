package EasyBookingZerbitzaria.NL;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import EasyBookingZerbitzaria.DL.hegaldia;

public interface IEasyZerbitzaria extends Remote {

	// Erabiltzaileen inguruko metodoak

	boolean sortuErabiltzailea(String erabiltzailea, String pasahitza, String email, String izena, String abizena,
			int adina, String nan) throws RemoteException;

	boolean ezabatuErabiltzailea() throws RemoteException;

	boolean pasahitzaAldatu(String email, String pasahitzZaharra, String pasahitzBerria) throws RemoteException;

	boolean login(String erabiltzailea, String pasahitza, String email) throws RemoteException;

	// Hegaldien inguruko metodoak

	ArrayList<hegaldia> hegaldiakBilatu(ArrayList<String> espezifikazioak) throws RemoteException;

	// Erosketaren inguruko metodoak

	void ordaindu(String email, float kantitatea, String kontzeptua) throws RemoteException;
	// emaila automatikoki bidaltzeko aukera

	boolean eguneratuMoneta(String email, float kantitatea) throws RemoteException;

}
