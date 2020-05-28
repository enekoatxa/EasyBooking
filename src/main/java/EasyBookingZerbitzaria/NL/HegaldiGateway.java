package EasyBookingZerbitzaria.NL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import EasyBookingKlientea.DLDTO.hegaldiaDTO;

public class HegaldiGateway {

	public ArrayList<hegaldiaDTO> hegaldiakBilatu(ArrayList<String> espezifikazioak) throws RemoteException {
		ArrayList<hegaldiaDTO> hegaldiak = new ArrayList<hegaldiaDTO>();
		// GARRANTZITSUA!! ESPEZIFIKAZIOAK ORDENATUTA EGON BEHAR DUTE!
		espezifikazioJSON(espezifikazioak);

		Response response = null;
		String hostname = "192.168.6.31";
		String port_auth = "5002";

		RestClient_konexioa c1 = new RestClient_konexioa(hostname, port_auth);

		String path = "/Airlines/Search_Flights";
		System.out.println("Trying POST at " + path + " (Search flights)");
		// VPN deia
		return hegaldiak;
	};

	private JSONObject espezifikazioJSON(ArrayList<String> espez) {
		JSONObject espezifikazioak = new JSONObject();
		espezifikazioak.put("airport_departure_name", espez.get(0));
		espezifikazioak.put("airport_arrival_name", espez.get(1));
		if (espez.size() > 2) {
			espezifikazioak.put("free_seats", espez.get(2));
		}
		if (espez.size() > 3) {
			espezifikazioak.put("price", espez.get(3));
		}
		if (espez.size() > 4) {
			espezifikazioak.put("departure_date", espez.get(4));
		}
		return espezifikazioak;
	}
}
