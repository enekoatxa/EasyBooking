package EasyBookingZerbitzaria.NL;

import java.rmi.Remote;
import java.util.ArrayList;

import EasyBookingZerbitzaria.DL.*;

public interface IEasyZerbitzaria extends Remote
{
	
	// Erabiltzaileen inguruko metodoak
	
		boolean sortuErabiltzailea(String erabiltzailea, String pasahitza, String email, String izena, 
		String abizena, int adina, String nan);
		
		boolean ezabatuErabiltzailea();
		
		boolean pasahitzaAldatu (String email, String pasahitzZaharra, String pasahitzBerria);
		
		boolean login(String erabiltzailea, String pasahitza, String email);
		
		// Hegaldien inguruko metodoak
				
		ArrayList <hegaldia> hegaldiakBilatu (ArrayList <String> espezifikazioak);
		
		// Erosketaren inguruko metodoak
		
		void ordaindu(String email, float kantitatea, String kontzeptua); 
		//emaila automatikoki bidaltzeko aukera
		
		boolean eguneratuMoneta(String email, float kantitatea );
		
		
		
	
	
	
}
