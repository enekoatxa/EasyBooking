package EasyBookingZerbitzaria.NL;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import EasyBookingZerbitzaria.DL.hegaldia;

public class EasyZerbitzaria extends UnicastRemoteObject implements IEasyZerbitzaria{

	protected EasyZerbitzaria() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean sortuErabiltzailea(String erabiltzailea, String pasahitza, String email, String izena,
			String abizena, int adina, String nan) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ezabatuErabiltzailea() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean pasahitzaAldatu(String email, String pasahitzZaharra, String pasahitzBerria) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean login(String erabiltzailea, String pasahitza, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<hegaldia> hegaldiakBilatu(ArrayList<String> espezifikazioak) {
		// TODO Auto-generated method stub
		return null;
	}

	public void ordaindu(String email, float kantitatea, String kontzeptua) {
		// TODO Auto-generated method stub
		
	}

	public boolean eguneratuMoneta(String email, float kantitatea) {
		// TODO Auto-generated method stub
		return false;
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

		try 
		{	
			IEasyZerbitzaria objServer = new EasyZerbitzaria();
			Registry registry = LocateRegistry.createRegistry((Integer.valueOf(args[1])));
			registry.rebind(name, objServer);
			System.out.println("* Zerbitzaria: '" + name + "' aktibatuta eta itxaroten...");
			System.out.println("Balioak: IP:" + args[0]+", port:"+args[1]+", name:"+args[2]);
		} 
		catch (Exception e) 
		{
			System.err.println("- Exzepzioa zerbitzarian: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
