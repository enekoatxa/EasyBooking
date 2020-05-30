package EasyBookingZerbitzaria.NL.DAO;

import java.util.ArrayList;
import java.util.Iterator;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import EasyBookingKlientea.DLDTO.aireportuaDTO;
import EasyBookingZerbitzaria.DL.aerolinea;
import EasyBookingZerbitzaria.DL.aireportua;
import EasyBookingZerbitzaria.DL.erabiltzailea;
import EasyBookingZerbitzaria.DL.erreserba;
import EasyBookingZerbitzaria.NL.DTO.DTO;

public class DAO {

	// Singleton patroia inplementatua
	private static DAO instance = new DAO();
	private DTO dto;
	private DAO() {
		dto= DTO.getInstance();
	}

	public static DAO getInstance() {
		return instance;
	}

	public boolean gordeErabiltzailea(erabiltzailea e) {
		
		boolean ret=false;
		try {
			PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
			Transaction transaction = persistentManager.currentTransaction();
			try {
				transaction.begin();
				persistentManager.makePersistent(e);
				transaction.commit();
				ret = true;
			} catch (Exception ex) {
				ret = false;
			} finally {
				if (transaction.isActive()) {
					transaction.rollback();
				}
				persistentManager.close();
			}
		} catch (Exception ex) {
			System.out.println("ERror inserting data");
		}
		
		return ret;
	}

	public boolean gordeAireportua(aireportua a) {
		PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
		Transaction transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			persistentManager.makePersistent(a);
			transaction.commit();
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}

	public boolean gordeAerolinea(aerolinea a) {
		PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
		Transaction transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			persistentManager.makePersistent(a);
			transaction.commit();
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}

	public boolean gordeErreserba(erreserba e) {
		PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
		Transaction transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			persistentManager.makePersistent(e);
			transaction.commit();
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}

	public boolean ezabatuErabiltzailea(String email) {
		PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
		Transaction transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Query<erabiltzailea> e = persistentManager.newQuery("SELECT FROM " + erabiltzailea.class.getName() + " WHERE email == " + "'" + email + "'");
			persistentManager.deletePersistent(e.executeList().get(0));
			transaction.commit();
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}

	public boolean ezabatuAireportua(String kodea) {
		PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
		Transaction transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Query<aireportua> a = persistentManager.newQuery("SELECT FROM " + aireportua.class.getName() + " WHERE kodea == " + "'" + kodea + "'");
			persistentManager.deletePersistent(a.executeList().get(0));
			transaction.commit();
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}

	public boolean ezabatuAerolinea(String kodea) {
		PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
		Transaction transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Query<aerolinea> a = persistentManager.newQuery("SELECT FROM " + aerolinea.class.getName() + " WHERE kodea == " + "'" + kodea + "'");
			persistentManager.deletePersistent(a.executeList().get(0));
			transaction.commit();
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}

	public boolean ezabatuErreserba(String kodea) {
		PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
		Transaction transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Query<erreserba> e = persistentManager.newQuery("SELECT FROM " + erreserba.class.getName() + " WHERE kodea == " + "'" + kodea + "'");
			persistentManager.deletePersistent(e.executeList().get(0));
			transaction.commit();
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}

	public void aldatuPasahitza(String email, String pasahitzBerria) {
		PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
		Transaction transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Query<erabiltzailea> e = persistentManager.newQuery("SELECT FROM " + erabiltzailea.class.getName() + " WHERE email == " + "'" + email + "'");
			e.executeList().get(0).setPasahitza(pasahitzBerria);
			transaction.commit();
		} catch (Exception ex) {
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			persistentManager.close();
		}
		
	}

	public ArrayList<aireportuaDTO> kargatuAireportuak() {
		ArrayList<aireportuaDTO>DTOaireportuak= new ArrayList<aireportuaDTO>();
	

		PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
		Transaction transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Extent<aireportua> extent = persistentManager.getExtent(aireportua.class, true);
			Iterator it = extent.iterator();
			while(it.hasNext()) {
				DTOaireportuak.add(dto.assembleAireportua((aireportua)it.next()));
			}
			transaction.commit();
		} catch (Exception ex) {
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		return DTOaireportuak;
	}
}
