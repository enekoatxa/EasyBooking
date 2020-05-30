package EasyBookingZerbitzaria.NL.Kudeatzaileak;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;

import EasyBookingKlientea.DLDTO.aireportuaDTO;
import EasyBookingKlientea.DLDTO.hegaldiaDTO;
import EasyBookingZerbitzaria.DL.aireportua;
import EasyBookingZerbitzaria.DL.hegaldia;
import EasyBookingZerbitzaria.NL.DAO.DAO;
import EasyBookingZerbitzaria.NL.Gateway.HegaldiGateway;

public class HegaldiKudeatzailea {

	private static HegaldiKudeatzailea instance = new HegaldiKudeatzailea();
	private DAO dao;
	private HegaldiGateway gateway = new HegaldiGateway();

	private HegaldiKudeatzailea() {
		dao = DAO.getInstance();
	}

	public static HegaldiKudeatzailea getInstance() {
		return instance;
	}

	public ArrayList<hegaldiaDTO> hegaldiakBilatu(ArrayList<String> espezifikazioak) throws RemoteException {
		return gateway.hegaldiakBilatu(espezifikazioak);
	}

	/*
	 * Hegaldi merkeena aukeratzen duen metodoa. Erabiltzaileak helmuga
	 * aireportu bakarra ahalko du jarri, baina irteera aireportuak nahi
	 * bezainbeste ahalko ditu jarri, konparazio hobeago bat egin ahal izateko.
	 */

	public static ArrayList<hegaldia> merkeenak(ArrayList<aireportua> irteera, aireportua helmuga) {

		ArrayList<hegaldia> hegaldiak = new ArrayList<hegaldia>(); // Hegaldi
																	// guztiak
																	// izango
																	// dituen
																	// ArrayList-a.
		boolean irteerak = false;
		boolean b = false;
		int u = 0;

		/*
		 * Nahi ditugun irteera eta helmugako aireportuak dituzten hegaldiak
		 * lortzeko metodoa
		 */

		for (int i = 0; i < hegaldiak.size(); i++) {
			if (b == true) {
				i = u;
			}
			b = false;
			if (hegaldiak.get(i).getHelmuga().getIzena().equals(helmuga.getIzena())) {
			} else {
				hegaldiak.remove(i);
				u = i;
				b = true;
			}
			if (i <= hegaldiak.size() - 1) {
				for (int o = 0; o < irteera.size(); o++) {
					if (irteera.get(o).getIzena().equals(hegaldiak.get(i).getIrteera().getIzena())) {
						irteerak = true;

					} else {
						irteerak = false;
					}
				}
				if (irteerak == false) {
					hegaldiak.remove(i);
					u = i;
					b = true;
				}
				if ((b == true) && (i == hegaldiak.size() - 1)) {
					i = i - 1;
				}
			}

		}
		System.out.println("ordenauta");
		Collections.sort(hegaldiak);
		for (int i = 0; i < hegaldiak.size(); i++) {
			System.out.println("hg" + hegaldiak.get(i).getPrezioa());
		}
		return hegaldiak;

	}

	public ArrayList<aireportuaDTO> kargatuAireportuak() {
		return dao.kargatuAireportuak();
	}
}
