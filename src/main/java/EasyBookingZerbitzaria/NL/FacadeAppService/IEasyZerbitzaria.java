package EasyBookingZerbitzaria.NL.FacadeAppService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import EasyBookingKlientea.DLDTO.aireportuaDTO;
import EasyBookingKlientea.DLDTO.hegaldiaDTO;

public interface IEasyZerbitzaria extends Remote {

	// Erabiltzaileen inguruko metodoak

	public String sortuErabiltzailea(String email, String izena, String abizena, int adina, String nan, String nick,
			String pasahitza, aireportuaDTO gustokoAireportua) throws RemoteException;

	public boolean ezabatuErabiltzailea(String email, String pasahitza) throws RemoteException;

	public boolean pasahitzaAldatu(String email, String pasahitzZaharra, String pasahitzBerria) throws RemoteException;

	public boolean login(String email, String pasahitza) throws RemoteException;

	// Hegaldien inguruko metodoak

	public ArrayList<hegaldiaDTO> hegaldiakBilatu(ArrayList<String> espezifikazioak) throws RemoteException;

	// Erosketaren inguruko metodoak

	public String ordaindu(String email, float kantitatea, String kontzeptua) throws RemoteException;
	// emaila automatikoki bidaltzeko aukera

	public ArrayList<aireportuaDTO> kargatuAireportuak() throws RemoteException;

}