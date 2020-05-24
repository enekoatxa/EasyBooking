package EasyBookingZerbitzaria.NL;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import EasyBookingKlientea.DLDTO.hegaldiaDTO;
import EasyBookingZerbitzaria.DL.aireportua;

public class EasyZerbitzaria extends UnicastRemoteObject implements IEasyZerbitzaria {

	private AutentikazioKudeatzailea autentikazioKud;
	private HegaldiKudeatzailea hegaldiKud;
	private OrdainketaKudeatzailea ordainketaKud;

	protected EasyZerbitzaria() throws RemoteException {
		autentikazioKud = AutentikazioKudeatzailea.getInstance();
		hegaldiKud = HegaldiKudeatzailea.getInstance();
		ordainketaKud = OrdainketaKudeatzailea.getInstance();
	}

	public boolean sortuErabiltzailea(String email, String izena, String abizena, int adina, String nan, String nick,
			String pasahitza, aireportua gustokoAireportua) throws RemoteException {
		return autentikazioKud.sortuErabiltzailea(email, izena, abizena, adina, nan, nick, pasahitza,
				gustokoAireportua);
	}

	public boolean ezabatuErabiltzailea(String email, String pasahitza) throws RemoteException {
		return autentikazioKud.ezabatuErabiltzailea(email, pasahitza);
	}

	public boolean pasahitzaAldatu(String email, String pasahitzZaharra, String pasahitzBerria) throws RemoteException {
		return autentikazioKud.pasahitzaAldatu(email, pasahitzZaharra, pasahitzBerria);
	}

	public boolean login(String email, String pasahitza) throws RemoteException {
		return autentikazioKud.login(email, pasahitza);
	}

	public ArrayList<hegaldiaDTO> hegaldiakBilatu(ArrayList<String> espezifikazioak) throws RemoteException {
		return hegaldiKud.hegaldiakBilatu(espezifikazioak);
	}

	public String ordaindu(String email, float kantitatea, String kontzeptua) throws RemoteException {
		return ordainketaKud.ordaindu(email, kantitatea, kontzeptua);
	}

	public boolean eguneratuMoneta(String email, float kantitatea) throws RemoteException {
		return ordainketaKud.eguneratuMoneta(email, kantitatea);
	}

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("usage: java [policy] [codebase] server.Server [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IEasyZerbitzaria objServer = new EasyZerbitzaria();
			Registry registry = LocateRegistry.createRegistry((Integer.valueOf(args[1])));
			registry.rebind(name, objServer);
			System.out.println("* Zerbitzaria: '" + name + "' aktibatuta eta itxaroten...");
			System.out.println("Balioak: IP:" + args[0] + ", port:" + args[1] + ", name:" + args[2]);
		} catch (Exception e) {
			System.err.println("- Exzepzioa zerbitzarian: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
