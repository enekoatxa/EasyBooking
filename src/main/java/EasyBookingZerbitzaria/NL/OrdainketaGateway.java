package EasyBookingZerbitzaria.NL;

import java.rmi.RemoteException;

public interface OrdainketaGateway 
{
	boolean ordaindu(String email, float kantitatea, String kontzeptua) throws RemoteException;

	boolean eguneratuMoneta(String email, float kantitatea) throws RemoteException;

}
