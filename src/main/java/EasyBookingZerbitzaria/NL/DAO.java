package EasyBookingZerbitzaria.NL;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import EasyBookingZerbitzaria.DL.aerolinea;
import EasyBookingZerbitzaria.DL.aireportua;
import EasyBookingZerbitzaria.DL.erabiltzailea;
import EasyBookingZerbitzaria.DL.erreserba;

public class DAO {
	
	//Singleton patroia inplementatua
	private static DAO instance = new DAO();
	private PersistenceManagerFactory persistentManagerFactory;
	private PersistenceManager persistentManager;
	private Transaction transaction;
	
	private DAO() {
		persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	public static DAO getInstance() {
		return instance;
	}

	public boolean gordeErabiltzailea(erabiltzailea e) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			persistentManager.makePersistent(e);
			transaction.commit();
			return true;
		}catch(Exception ex) {
			return false;
		}finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}
	public boolean gordeAireportua(aireportua a) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			persistentManager.makePersistent(a);
			transaction.commit();
			return true;
		}catch(Exception ex) {
			return false;
		}finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}
	public boolean gordeAerolinea(aerolinea a) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			persistentManager.makePersistent(a);
			transaction.commit();
			return true;
		}catch(Exception ex) {
			return false;
		}finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}
	public boolean gordeErreserba(erreserba e) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			persistentManager.makePersistent(e);
			transaction.commit();
			return true;
		}catch(Exception ex) {
			return false;
		}finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}
	public boolean ezabatuErabiltzailea(String email) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		Query<erabiltzailea> e= persistentManager.newQuery("SELECT FROM " + erabiltzailea.class.getName() + " WHERE email == "+"'"+email+"'");
		try {
			transaction.begin();
			persistentManager.deletePersistent(e.executeList().get(0));
			transaction.commit();
			return true;
		}catch(Exception ex) {
			return false;
		}finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}
	public boolean ezabatuAireportua(String kodea) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		Query<aireportua> a= persistentManager.newQuery("SELECT FROM " + aireportua.class.getName() + " WHERE kodea == "+"'"+kodea+"'");
		try {
			transaction.begin();
			persistentManager.deletePersistent(a.executeList().get(0));
			transaction.commit();
			return true;
		}catch(Exception ex) {
			return false;
		}finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}
	public boolean ezabatuAerolinea(String kodea) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		Query<aerolinea> a= persistentManager.newQuery("SELECT FROM " + aerolinea.class.getName() + " WHERE kodea == "+"'"+kodea+"'");
		try {
			transaction.begin();
			persistentManager.deletePersistent(a.executeList().get(0));
			transaction.commit();
			return true;
		}catch(Exception ex) {
			return false;
		}finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}
	public boolean ezabatuErreserba(String kodea) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		Query<erreserba> e= persistentManager.newQuery("SELECT FROM " + erreserba.class.getName() + " WHERE kodea == "+"'"+kodea+"'");
		try {
			transaction.begin();
			persistentManager.deletePersistent(e.executeList().get(0));
			transaction.commit();
			return true;
		}catch(Exception ex) {
			return false;
		}finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}
}
