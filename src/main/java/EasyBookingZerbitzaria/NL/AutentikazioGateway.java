package EasyBookingZerbitzaria.NL;

import java.rmi.RemoteException;

import org.json.simple.JSONObject;

import EasyBookingZerbitzaria.DL.aireportua;

public class AutentikazioGateway {
	
	
	 JSONObject json_encoded;

	    
	public boolean sortuErabiltzailea(String email, String izena, String abizena, int adina, String nan, String nick,
			String pasahitza, aireportua gustokoAireportua) throws RemoteException {
		boolean a = true;
		sortuJSON(izena, abizena, email);
		
		// VPN deia
		
				String hostname = "127.0.0.1";
				String port_auth = "5000";



				RestClient_konexioa c1 = new RestClient_konexioa(hostname, port_auth);
				
				try {
					// Hau ping requests Bat besterik ez da!!!!!!!!!!!
					
					// make request metodoaren bitartez ping-ak egin beharrean ya datuak eskatu eta bidali
					//behar dira
					c1.makeGetRequest("/");
					c1.makeGetRequest("/Authentication/Log_in");				
					
				} catch (Exception e) {
					System.out.println("Catched exception: " + e.getMessage());
				}
				
				
				
				
		return a;
	};

	
	boolean ezabatuErabiltzailea(String email, String pasahitza) throws RemoteException {
		boolean a = true;
		erabiltzaileaJSON(email, pasahitza, null, true);
		// VPN deia
		return a;
	};

	
	boolean pasahitzaAldatu(String email, String pasahitzZaharra, String pasahitzBerria) throws RemoteException {
		boolean a = true;
		erabiltzaileaJSON(email, pasahitzZaharra, pasahitzBerria, false);
		// VPN deia
		return a;
	};

	
	boolean login(String email, String pasahitza) throws RemoteException {
		boolean a = true;
		erabiltzaileaJSON(email, pasahitza, null, true);
		// VPN deia
		return a;
	};

	
	private JSONObject erabiltzaileaJSON(String email, String pasahitza, String pasahitzBerria, boolean a) {
		JSONObject erabiltzailea = new JSONObject();
		if (a == true) {
			erabiltzailea.put("email", email);
			erabiltzailea.put("password", pasahitza);

		} else if (a == false) {
			erabiltzailea.put("email", email);
			erabiltzailea.put("password", pasahitza);
			erabiltzailea.put("password_new", pasahitzBerria);
		}
		return erabiltzailea;
	}

	
	private JSONObject sortuJSON(String izena, String abizena, String email) {
		JSONObject erabiltzailea = new JSONObject();

		erabiltzailea.put("name", izena);
		erabiltzailea.put("last_name", abizena);
		erabiltzailea.put("email", email);

		return erabiltzailea;
	}

	
}
