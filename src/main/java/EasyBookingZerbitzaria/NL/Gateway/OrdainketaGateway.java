package EasyBookingZerbitzaria.NL.Gateway;

import java.rmi.RemoteException;

import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import EasyBookingZerbitzaria.NL.Rest.RestClient_konexioa;

public class OrdainketaGateway {
	private final String hostname = "192.168.6.31";
	private final String port_auth = "5001";

	public String ordaindu(String email, float kantitatea, String kontzeptua) throws RemoteException {

		JSONObject obj = erabiltzaileaJSON(email, 0, kantitatea, kontzeptua, false);

		Response response = null;
		RestClient_konexioa c1 = new RestClient_konexioa(hostname, port_auth);

		String path = "/Payments/Make_payment";
		System.out.println("Trying POST at " + path + " (Make payment)");

		try {
			response = c1.makePostRequest(c1.createInvocationBuilder(path), obj);
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}

		String reply = response.readEntity(String.class);
		return reply;
	};

	public boolean eguneratuMoneta(String email, float moneta) throws RemoteException {
		JSONObject obj = erabiltzaileaJSON(email, moneta, 0, null, true);

		Response response = null;

		RestClient_konexioa c1 = new RestClient_konexioa(hostname, port_auth);

		String path = "/Payments/Update_currency";
		System.out.println("Trying POST at " + path + " (Update currency)");
		try {
			response = c1.makePostRequest(c1.createInvocationBuilder(path), obj);
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}
		String reply = response.readEntity(String.class);

		return Boolean.valueOf(reply);
	};

	private JSONObject erabiltzaileaJSON(String email, float moneta, float kantitatea, String kontzeptua, boolean a) {
		JSONObject erabiltzailea = new JSONObject();
		if (a == true) {
			erabiltzailea.put("email", email);
			erabiltzailea.put("currency", moneta);

		} else if (a == false) {
			erabiltzailea.put("email", email);
			erabiltzailea.put("total_amount", kantitatea);
			erabiltzailea.put("concept", kontzeptua);
		}
		return erabiltzailea;
	}
}
