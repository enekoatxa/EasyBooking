package EasyBookingZerbitzaria.NL.Gateway;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import EasyBookingKlientea.DLDTO.hegaldiaDTO;
import EasyBookingZerbitzaria.NL.Rest.RestClient_konexioa;

public class HegaldiGateway {

	private final String hostname = "192.168.6.31";
	private final String port_auth = "5002";
	public ArrayList<hegaldiaDTO> hegaldiakBilatu(ArrayList<String> espezifikazioak) throws RemoteException {
		ArrayList<hegaldiaDTO> hegaldiak;
		// GARRANTZITSUA!! ESPEZIFIKAZIOAK ORDENATUTA EGON BEHAR DUTE!
		JSONObject obj = espezifikazioJSON(espezifikazioak);

		Response response = null;
		
		RestClient_konexioa c1 = new RestClient_konexioa(hostname, port_auth);

		String path = "/Airlines/Search_Flights";
		System.out.println("Trying POST at " + path + " (Search flights)");
		
		try {
			response = c1.makePostRequest(c1.createInvocationBuilder(path), obj);
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}

		hegaldiak=unmarshallHegaldiak(response);
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
	
	private ArrayList<hegaldiaDTO> unmarshallHegaldiak(Response response){
		ArrayList<hegaldiaDTO>ret  = new ArrayList<hegaldiaDTO>();
		//UNMARSHALLLLLL!!!
		return ret;
		
	}
}
