package EasyBookingZerbitzaria.NL;

import java.rmi.RemoteException;

import org.json.simple.JSONObject;

public class OrdainketaGateway {
	public String ordaindu(String email, float kantitatea, String kontzeptua) throws RemoteException {
		String a = "";
		erabiltzaileaJSON(email, 0, kantitatea, kontzeptua, false);
		// VPN deia
		return a;
	};

	public boolean eguneratuMoneta(String email, float moneta) throws RemoteException {
		boolean a = true;
		erabiltzaileaJSON(email, moneta, 0, null, true);
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
