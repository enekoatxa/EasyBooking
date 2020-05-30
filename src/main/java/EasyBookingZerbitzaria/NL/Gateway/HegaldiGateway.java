package EasyBookingZerbitzaria.NL.Gateway;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import EasyBookingKlientea.DLDTO.aerolineaDTO;
import EasyBookingKlientea.DLDTO.aireportuaDTO;
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

		hegaldiak = unmarshallHegaldiak(response);
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

	private ArrayList<hegaldiaDTO> unmarshallHegaldiak(Response response) {
		ArrayList<hegaldiaDTO> ret = new ArrayList<hegaldiaDTO>();

		try {
			String json_string = response.readEntity(String.class);
			JSONParser myParser = new JSONParser();
			JSONArray flightsArray = (JSONArray) myParser.parse(json_string);
			List<JSON_Hegaldia> heg;

			heg = (List) flightsArray.stream().map(element -> new JSON_Hegaldia(element)).collect(Collectors.toList());

			for (int i = 0; i < heg.size(); i++) {
				aireportuaDTO irteera = new aireportuaDTO(heg.get(i).getAirportDepartureCode(),
						heg.get(i).getAirportDepartureCity());
				aireportuaDTO helmuga = new aireportuaDTO(heg.get(i).getAirportArrivalCode(),
						heg.get(i).getAirportArrivalCity());
				long prezioa = heg.get(i).getPrice();
				LocalDateTime data = heg.get(i).getDepartureDate(true);
				hegaldiaDTO h = new hegaldiaDTO(irteera, helmuga, 0, prezioa, convertToDateViaSqlTimestamp(data),
						new aerolineaDTO(" ", " "));
				ret.add(h);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}

		return ret;

	}

	public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
		return java.sql.Timestamp.valueOf(dateToConvert);
	}
}
