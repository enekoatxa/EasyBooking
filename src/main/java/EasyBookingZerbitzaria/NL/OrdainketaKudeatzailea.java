package EasyBookingZerbitzaria.NL;

public class OrdainketaKudeatzailea {
	
	private static OrdainketaKudeatzailea instance = new OrdainketaKudeatzailea();
	private DAO dao;
	
	private OrdainketaKudeatzailea() {
		dao = DAO.getInstance();
	}
	
	public static OrdainketaKudeatzailea getInstance() {
		return instance;
	}
	
	public boolean ordaindu(String email, float kantitatea, String kontzeptua) {
		// deitu mikrozerbitzura
		return false;
	}

	public boolean eguneratuMoneta(String email, float kantitatea) {
		//deitu mikrozerbitzura
		return false;
	}
}
