package EasyBookingZerbitzaria.NL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import EasyBookingKlientea.DLDTO.hegaldiaDTO;

public interface HegaldiGateway
{

	ArrayList<hegaldiaDTO> hegaldiakBilatu(ArrayList<String> espezifikazioak) throws RemoteException;
	
}
