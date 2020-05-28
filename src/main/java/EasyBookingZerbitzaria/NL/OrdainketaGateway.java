package EasyBookingZerbitzaria.NL;

import java.rmi.RemoteException;

import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

public class OrdainketaGateway {
	public String ordaindu(String email, float kantitatea, String kontzeptua) throws RemoteException {
		String a = "";
		erabiltzaileaJSON(email, 0, kantitatea, kontzeptua, false);

		Response response = null;
		String hostname = "192.168.6.31";
		String port_auth = "5001";

		RestClient_konexioa c1 = new RestClient_konexioa(hostname, port_auth);

		String path = "/Payments/Make_payment";
		System.out.println("Trying POST at " + path + " (Make payment)");
		// VPN deia
		return a;
	};

	public boolean eguneratuMoneta(String email, float moneta) throws RemoteException {
		boolean a = true;
		erabiltzaileaJSON(email, moneta, 0, null, true);

		Response response = null;
		String hostname = "192.168.6.31";
		String port_auth = "5001";

		RestClient_konexioa c1 = new RestClient_konexioa(hostname, port_auth);

		String path = "/Payments/Update_currency";
		System.out.println("Trying POST at " + path + " (Update currency)");
		// VPN deia
		return a;
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
