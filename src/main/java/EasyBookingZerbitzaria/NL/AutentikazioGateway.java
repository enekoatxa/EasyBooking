package EasyBookingZerbitzaria.NL;

import java.rmi.RemoteException;

import EasyBookingZerbitzaria.DL.aireportua;

public interface AutentikazioGateway
{
	public boolean sortuErabiltzailea(String email, String izena, String abizena, int adina, String nan, String nick, String pasahitza, aireportua gustokoAireportua)
			throws RemoteException;

	boolean ezabatuErabiltzailea(String kodea) throws RemoteException;

	boolean pasahitzaAldatu(String email, String pasahitzZaharra, String pasahitzBerria) throws RemoteException;

	boolean login(String email, String pasahitza, String autentikazioZerbitzua) throws RemoteException;

}
