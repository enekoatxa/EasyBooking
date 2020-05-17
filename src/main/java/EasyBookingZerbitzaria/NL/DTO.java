package EasyBookingZerbitzaria.NL;

import java.util.ArrayList;

import EasyBookingKlientea.DLDTO.*;
import EasyBookingZerbitzaria.DL.*;

public class DTO {
	
	private static DTO instance = new DTO();

	private DTO() {}
	
	public static DTO getInstance() {
		return instance;
	}
	
	//Assemble metodoak listentzat
	ArrayList<erabiltzaileaDTO> assembleErabiltzaileak(ArrayList<erabiltzailea>erabiltzaileak) {
		ArrayList<erabiltzaileaDTO> ret = new ArrayList<erabiltzaileaDTO>();
		for(erabiltzailea e: erabiltzaileak) {
			ret.add(new erabiltzaileaDTO(e.getEmaila(), e.getNick(), e.getPasahitza()));
		}
		return ret;
	}
	
	ArrayList<bidaiariaDTO> assembleBidaidariak(ArrayList<bidaiaria>bidaiariak) {
		ArrayList<bidaiariaDTO> ret = new ArrayList<bidaiariaDTO>();
		for(bidaiaria b: bidaiariak) {
			ret.add(new bidaiariaDTO(b.getNan(), b.getIzena(), b.getAbizena(), b.getAdina()));
		}
		return ret;
	}
	
	ArrayList<aerolineaDTO> assembleAerolineak(ArrayList<aerolinea>aerolineak) {
		ArrayList<aerolineaDTO> ret = new ArrayList<aerolineaDTO>();
		for(aerolinea a: aerolineak) {
			ret.add(new aerolineaDTO(a.getKodea(), a.getIzena()));
		}
		return ret;
	}
	
	ArrayList<aireportuaDTO> assembleAireportuak(ArrayList<aireportua>aireportuak) {
		ArrayList<aireportuaDTO> ret = new ArrayList<aireportuaDTO>();
		for(aireportua a: aireportuak) {
			ret.add(new aireportuaDTO(a.getKodea(), a.getIzena()));
		}
		return ret;
	}
	
	ArrayList<erreserbaDTO> assembleErreserbak(ArrayList<erreserba>erreserbak) {
		ArrayList<erreserbaDTO> ret = new ArrayList<erreserbaDTO>();
		for(erreserba e : erreserbak) {
			ret.add(new erreserbaDTO(e.getKodea(), e.getPrezioa(), assembleHegaldia(e.getHeg()), e.getBidaiariKopurua()));
		}
		return ret;
	}
	
	ArrayList<hegaldiaDTO> assembleHegaldiak(ArrayList<hegaldia>hegaldiak) {
		ArrayList<hegaldiaDTO> ret = new ArrayList<hegaldiaDTO>();
		for(hegaldia h: hegaldiak) {
			ret.add(new hegaldiaDTO(assembleAireportua(h.getIrteera()), assembleAireportua(h.getHelmuga()), h.getDenbora(), h.getPrezioa(), h.getData(), assembleAerolinea(h.getAerolinea())));
		}
		return ret;
	}
	
	//Assemble metodoak objektu indibidualentzat
	
	erabiltzaileaDTO assembleErabiltzailea(erabiltzailea e) {
		return new erabiltzaileaDTO(e.getEmaila(), e.getNick(), e.getPasahitza());
	}
	bidaiariaDTO assembleBidaidaria(bidaiaria b) {
		return new bidaiariaDTO(b.getNan(), b.getIzena(), b.getAbizena(), b.getAdina());
	}
	aerolineaDTO assembleAerolinea(aerolinea a) {
		return new aerolineaDTO(a.getKodea(), a.getIzena());
	}
	aireportuaDTO assembleAireportua(aireportua a) {
		return new aireportuaDTO(a.getKodea(), a.getIzena());
	}
	erreserbaDTO assembleErreserba(erreserba e) {
		return new erreserbaDTO(e.getKodea(), e.getPrezioa(), assembleHegaldia(e.getHeg()), e.getBidaiariKopurua());
	}
	hegaldiaDTO assembleHegaldia(hegaldia h) {
		return new hegaldiaDTO(assembleAireportua(h.getIrteera()), assembleAireportua(h.getHelmuga()), h.getDenbora(), h.getPrezioa(), h.getData(), assembleAerolinea(h.getAerolinea()));
	}
}
