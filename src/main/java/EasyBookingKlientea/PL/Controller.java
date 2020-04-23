package EasyBookingKlientea.PL;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import java.rmi.RemoteException;


public class Controller {

	
private RMIServiceLocator rsl = null;
	
	public Controller(String[] args) throws RemoteException 
	{		
		// Add your related code for the initialization of the Service Locator
	
        // Add your code for the initialization of the windows
		rsl = new RMIServiceLocator();
		rsl.setService(args[0], args[1], args[2]);
		lHasi hasi = new lHasi(args[0], args[1], args[2]);
		hasi.setVisible(true);
	}
	
	//main-a
	public static void main(String[] args) throws RemoteException 
	{
		new Controller(args);
	}
	
	public void exit() 
	{
		System.exit(0);
	}
	
	public void sortuErabiltzailea(String email, String izena, String abizena, int adina, String nan)
	throws RemoteException
			{
				try {
		    		rsl.getService().sortuErabiltzailea(email, izena, abizena, adina, nan);
		    	} catch (Exception e){
		    		System.err.println("Errorea erabiltzailea sortzerako garaian: " + e.getMessage());
		    	}	
			}
	
	public void ezabatuErabiltzailea() throws RemoteException
	{
		try {
	    		rsl.getService().ezabatuErabiltzailea();
	    	} catch (Exception e){
	    		System.err.println("Errorea erabiltzailea ezabatzerako garaian: " + e.getMessage());
	    	}	
	}
	
	public void  pasahitzaAldatu(String email, String pasahitzZaharra, String pasahitzBerria)
	throws RemoteException
	{
	try {
	    		rsl.getService().pasahitzaAldatu(pasahitzBerria, pasahitzBerria, pasahitzBerria);
	    } catch (Exception e){
	    		System.err.println("Errorea pasahitza aldatzerako garaian: " + e.getMessage());
	    }	
	}
	
	public void login(String email, String pasahitza, String autentikazioZerbitzua) throws RemoteException
	{
		try {
	    		rsl.getService().login(email, pasahitza, autentikazioZerbitzua);
	    	} catch (Exception e){
	    		System.err.println("Errorea login egiterako garaian: " + e.getMessage());
	    	}	
	}
	
	public void hegaldiakBilatu(ArrayList<String> espezifikazioak) throws RemoteException
	{
			try {
	    		rsl.getService().hegaldiakBilatu(espezifikazioak);
	    	} catch (Exception e){
	    		System.err.println("Errorea helgaldiak bilatzerako garaian: " + e.getMessage());
	    	}	
	}
	
	public void eguneratuMoneta(String email, float kantitatea) throws RemoteException
	{
		try {
    		rsl.getService().eguneratuMoneta(email, kantitatea);
    	} catch (Exception e){
    		System.err.println("Errorea helgaldiak bilatzerako garaian: " + e.getMessage());
    	}	
	}	
}
