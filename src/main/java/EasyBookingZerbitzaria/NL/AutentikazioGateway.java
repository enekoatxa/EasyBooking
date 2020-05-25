package EasyBookingZerbitzaria.NL;

import java.rmi.RemoteException;

import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import EasyBookingKlientea.DLDTO.aireportuaDTO;
import EasyBookingZerbitzaria.DL.aireportua;

public class AutentikazioGateway {

	JSONObject json_encoded;

	public boolean sortuErabiltzailea(String email, String izena, String abizena, int adina, String nan, String nick,
			String pasahitza, aireportuaDTO gustokoAireportua) throws RemoteException {
		
		
		JSONObject obj= sortuJSON(izena, abizena, email);

		// VPN deia

        Response response = null;
		String hostname = "192.168.6.31";
		String port_auth = "5000";

		RestClient_konexioa c1 = new RestClient_konexioa(hostname, port_auth);

		String path="";
		 path = "/Authentication/Create_user";
	        System.out.println("Trying POST at " + path + " (Create user)");
	        System.out.println("CURL call: curl http://192.168.6.31:5000/Authentication/Create_user -d '{\"name\":\"Inigo\", \"last_name\":\"Lopez-Gazpio\", \"email\":\"inigo.lopezgazpio@deusto.es\"}' -X POST -H \"Content-Type: application/json\" -v");

	      


	        Simple_pass_result result_class_password = null;
	        try {
	            response =
	            		c1.makePostRequest(
	            				c1.createInvocationBuilder(path), obj
	                    );
	        }
	        catch (Exception e) { e.printStackTrace(); e.toString(); }

	        String reply = response.readEntity(String.class);

	        // Create a JSONObject to parse the respond inside the Simple_pass_result
	        try {
	            result_class_password = new Simple_pass_result(reply);
	        } catch (Exception e) {e.printStackTrace(); e.toString(); }

	        result_class_password.print();

	        long password = result_class_password.getContentNumber();
	        
	        System.out.println(password);
			return false;

	}

	public boolean ezabatuErabiltzailea(String email, String pasahitza) throws RemoteException {
		boolean a = true;
		erabiltzaileaJSON(email, pasahitza, null, true);
		// VPN deia
		return a;
	}

	public boolean pasahitzaAldatu(String email, String pasahitzZaharra, String pasahitzBerria) throws RemoteException {
		boolean a = true;
		erabiltzaileaJSON(email, pasahitzZaharra, pasahitzBerria, false);
		// VPN deia
		return a;
	}

	public boolean login(String email, String pasahitza) throws RemoteException {
		boolean a = true;
		erabiltzaileaJSON(email, pasahitza, null, true);
		// VPN deia
		return a;
	}

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

	private static JSONObject sortuJSON(String izena, String abizena, String email) {
		JSONObject erabiltzailea = new JSONObject();

		erabiltzailea.put("name", izena);
		erabiltzailea.put("last_name", abizena);
		erabiltzailea.put("email", email);

		return erabiltzailea;
	}



}
