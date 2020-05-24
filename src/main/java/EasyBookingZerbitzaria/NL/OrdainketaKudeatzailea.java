package EasyBookingZerbitzaria.NL;

import java.rmi.RemoteException;

public class OrdainketaKudeatzailea {

	private static OrdainketaKudeatzailea instance = new OrdainketaKudeatzailea();
	private DAO dao;
	private OrdainketaGateway gateway = new OrdainketaGateway();

	private OrdainketaKudeatzailea() {
		dao = DAO.getInstance();
	}

	public static OrdainketaKudeatzailea getInstance() {
		return instance;
	}

	public String ordaindu(String email, float kantitatea, String kontzeptua) throws RemoteException {
		return gateway.ordaindu(email, kantitatea, kontzeptua);
	}

	public boolean eguneratuMoneta(String email, float moneta) throws RemoteException {
		return gateway.eguneratuMoneta(email, moneta);
	}
}
