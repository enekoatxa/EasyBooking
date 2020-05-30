package EasyBookingZerbitzaria.NL.Gateway;

import java.rmi.RemoteException;

import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import EasyBookingKlientea.DLDTO.aireportuaDTO;
import EasyBookingZerbitzaria.NL.Rest.RestClient_konexioa;

public class AutentikazioGateway {

	private final String hostname = "192.168.6.31";
	private final String port_auth = "5000";
	
	public String sortuErabiltzailea(String email, String izena, String abizena, int adina, String nan, String nick, String pasahitza, aireportuaDTO gustokoAireportua) throws RemoteException {

		JSONObject obj = sortuJSON(izena, abizena, email);

		Response response = null;
		
		RestClient_konexioa c1 = new RestClient_konexioa(hostname, port_auth);

		String path = "/Authentication/Create_user";
		System.out.println("Trying POST at " + path + " (Create user)");

		try {
			response = c1.makePostRequest(c1.createInvocationBuilder(path), obj);
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}

		String reply = response.readEntity(String.class);

		return reply;

	}

	public boolean ezabatuErabiltzailea(String email, String pasahitza) throws RemoteException {
		JSONObject obj = erabiltzaileaJSON(email, pasahitza, null, true);

		Response response = null;

		RestClient_konexioa c1 = new RestClient_konexioa(hostname, port_auth);

		String path = "/Authentication/Delete_user";
		System.out.println("Trying POST at " + path + " (Delete user)");

		try {
			response = c1.makePostRequest(c1.createInvocationBuilder(path), obj);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		String reply = response.readEntity(String.class);
		System.out.println(reply);
		return Boolean.valueOf(reply);
	}

	public boolean pasahitzaAldatu(String email, String pasahitzZaharra, String pasahitzBerria) throws RemoteException {
		JSONObject obj = erabiltzaileaJSON(email, pasahitzZaharra, pasahitzBerria, false);

		Response response = null;

		RestClient_konexioa c1 = new RestClient_konexioa(hostname, port_auth);

		String path = "/Authentication/Change_password";
		System.out.println("Trying POST at " + path + " (Change password)");

		try {
			response = c1.makePostRequest(c1.createInvocationBuilder(path), obj);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		String reply = response.readEntity(String.class);
		System.out.println(reply);
		return Boolean.valueOf(reply);
	}

	public boolean login(String email, String pasahitza) throws RemoteException {
		String path = "/Authentication/Log_in";
		RestClient_konexioa c1 = new RestClient_konexioa(hostname, port_auth);
		System.out.println("Trying POST at " + path + " (Login)");
		JSONObject obj = erabiltzaileaJSON(email, pasahitza, null, true);

		Response response = null;
		try {
			response = c1.makePostRequest(c1.createInvocationBuilder(path), obj);
		}catch (Exception e) {
			e.printStackTrace();
		}
		String reply = response.readEntity(String.class);
		System.out.println(reply);
		return Boolean.valueOf(reply);
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
