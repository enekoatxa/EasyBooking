package NL;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import DL.aerolinea;
import DL.aireportua;
import DL.erabiltzailea;
import DL.erreserba;
import DL.hegaldia;
import DL.pertsona;

public class MainORM {

	public static void main(String[] args)
	{
		
		try
        {
			PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			
			//Insert data in the DB
			PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();				
			
			try
            {

			    transaction.begin();
				aireportua a1 = new aireportua("a001", "Heathrow");
				aireportua a2 = new aireportua("a002", "Barajas");
				erabiltzailea e1 = new erabiltzailea("73037449Y", "Eneko", "Atxa", 21, "eneko.atxa@opendeusto.es", "enekoatxa", "enekoatxa");
				aerolinea l1 = new aerolinea("l001", "Iberia");
				hegaldia h1 = new hegaldia("h001", a1, a2, 1.5, 50, new java.util.Date(), 20, l1);

				ArrayList<pertsona>bidaiariak=new ArrayList<pertsona>();
				bidaiariak.add(e1);
				
			    	    

			    persistentManager.makePersistent(a1);
			    System.out.println(a1.getIzena() +"Aireportua sartuta");
			    persistentManager.makePersistent(a2);
			    System.out.println(a2.getIzena() +"Aireportua sartuta");
			    persistentManager.makePersistent(e1);
			    System.out.println(e1.getIzena() +"Erabiltzailea sartuta");
			    persistentManager.makePersistent(l1);
			    System.out.println(l1.getIzena() +"Aerolinea sartuta");
			 
			    			    
			    transaction.commit();
			    
			}

            catch(Exception ex)
			{
				System.err.println("* Exception inserting data into db: " + ex.getMessage());
				System.err.println("1. err");
			}
			
			finally
			{		    
				if (transaction.isActive()) 
				{
			        transaction.rollback();
			    }
			    
			    persistentManager.close();
			}
			
        }
		catch(Exception ex)
		{
			System.err.println("* Exception inserting data into db: " + ex.getMessage());
			System.err.println("2. err");
		}
	}
}