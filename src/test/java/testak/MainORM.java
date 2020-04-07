package testak;

import java.util.ArrayList;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import DL.aerolinea;
import DL.aireportua;
import DL.bidaiaria;
import DL.erabiltzailea;
import DL.erreserba;
import DL.hegaldia;
import DL.pertsona;

public class MainORM {

	public static void main(String[] args)
	{
		if(args.length!=1){
			System.err.println("Argumentu bakarra jaso dezake main honek.");
		}
		else {
			int aukera = Integer.parseInt(args[0]);
			
			try
	        {
				PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
				PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
				Transaction transaction = persistentManager.currentTransaction();				
						
				//Datuak datubasera sartzeko
				if(aukera==1) {
					try
		            {

					    transaction.begin();
						aireportua a1 = new aireportua("a001", "Heathrow");
						aireportua a2 = new aireportua("a002", "Barajas");
						aireportua a3 = new aireportua("a003", "JFK");
						aireportua a4 = new aireportua("a004", "Loiu");
						aireportua a5 = new aireportua("a005", "Praga-Ruzyne");
						erabiltzailea e1 = new erabiltzailea("73037449Y", "Eneko", "Atxa", 21, "eneko.atxa@opendeusto.es", "enekoatxa", "enekoatxa");
						erabiltzailea e2 = new erabiltzailea("34564587F", "Imanol", "Aizpuru", 22, "ima.aizpuru@opendeusto.es", "imanolaizpuru", "imanolaizpuru");
						erabiltzailea e3 = new erabiltzailea("98547567L", "Mikel", "Martinez", 21, "mikelmartinezz@opendeusto.es", "mikelmartinez", "mikelmartinez");
						e1.addGustokoAireportua(a1);
						e2.addGustokoAireportua(a2);
						e3.addGustokoAireportua(a3);
						bidaiaria b1 = new bidaiaria("12345678A", "Miren", "Markez", 26);
						bidaiaria b2 = new bidaiaria("23452345B", "Jon", "Aizpurua", 27);
						bidaiaria b3 = new bidaiaria("84755463C", "Jokin", "Lopetegi", 32);
						bidaiaria b4 = new bidaiaria("88447563D", "Martin", "Irizar", 22);
						aerolinea l1 = new aerolinea("l001", "Iberia");
						aerolinea l2 = new aerolinea("l002", "Ryanair");
						aerolinea l3 = new aerolinea("l003", "EasyJet");
						aerolinea l4= new aerolinea("l004", "American Airlines");
						hegaldia h1 = new hegaldia("h001", a1, a2, 1.5, 50, new java.util.Date(), 20, l1);
						hegaldia h2 = new hegaldia("h002", a1, a3, 3, 250, new java.util.Date(), 30, l2);
						hegaldia h3 = new hegaldia("h003", a3, a4, 12, 350, new java.util.Date(), 30, l3);
						hegaldia h4 = new hegaldia("h004", a4, a2, 13, 350, new java.util.Date(), 22, l4);
						ArrayList<pertsona>bidaiariak1=new ArrayList<pertsona>();
						bidaiariak1.add(e1);
						ArrayList<pertsona>bidaiariak2=new ArrayList<pertsona>();
						bidaiariak2.add(e2);
						bidaiariak2.add(b1);
						bidaiariak2.add(b2);
						ArrayList<pertsona>bidaiariak3=new ArrayList<pertsona>();
						bidaiariak3.add(e3);
						bidaiariak3.add(b3);
						ArrayList<pertsona>bidaiariak4=new ArrayList<pertsona>();
						bidaiariak4.add(e1);
						bidaiariak4.add(b4);
						erreserba r1 = new erreserba("r001", 50, h1, bidaiariak1, e1);
					    erreserba r2 = new erreserba("r002", 750, h2, bidaiariak2, e2);
						erreserba r3 = new erreserba("r003", 700, h3, bidaiariak3, e3);
						erreserba r4 = new erreserba("r004", 700, h4, bidaiariak4, e1);	    
					    persistentManager.makePersistent(a1);
					    persistentManager.makePersistent(a2);
					    persistentManager.makePersistent(a3);
					    persistentManager.makePersistent(a4);
					    persistentManager.makePersistent(a5);
					    System.out.println("5 Aireportu sartuta");
					    persistentManager.makePersistent(e1);
					    persistentManager.makePersistent(e2);
					    persistentManager.makePersistent(e3);
					    System.out.println("3 Erabiltzaile sartuta");
					    persistentManager.makePersistent(l1);
					    persistentManager.makePersistent(l2);
					    persistentManager.makePersistent(l3);
					    persistentManager.makePersistent(l4);
					    System.out.println("4 Aerolinea sartuta");
					    persistentManager.makePersistent(r1);
					    System.out.println(r1.getKodea() +" Kodedun erreserba sartuta");
					    persistentManager.makePersistent(r2);
					    System.out.println(r2.getKodea() +" Kodedun erreserba sartuta");
					    persistentManager.makePersistent(r3);
					    System.out.println(r3.getKodea() +" Kodedun erreserba sartuta");
					    persistentManager.makePersistent(r4);
					    System.out.println(r4.getKodea() +" Kodedun erreserba sartuta");
					    System.out.println("Datu sarketa guztia amaitu da."); 
					    transaction.commit();
					    
					}

		            catch(Exception ex)
					{
						System.err.println("* Exception inserting data into db: " + ex.getMessage());
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
				//73037449Y nan dun erabiltzailea bilatu
				else if(aukera==2) {
					persistentManager = persistentManagerFactory.getPersistenceManager();
					transaction = persistentManager.currentTransaction();
						
					try
		            {
					    transaction.begin();
			
					    @SuppressWarnings("unchecked")
						Query<erabiltzailea> erabiltzaileQuerya = persistentManager.newQuery("SELECT FROM " + erabiltzailea.class.getName() + " WHERE nan == '73037449Y'");
					    System.out.println("Querya erabiltzen duen datu bilaketa");
					    System.out.println("73037449Y NAN dun erabiltzailea");
					    for (erabiltzailea e : erabiltzaileQuerya.executeList()) 
					    {
					        System.out.println("- Izena: " + e.getIzena() + " NAN: " + e.getNan());
					    }
					    transaction.commit();
					}

					catch(Exception ex)
					{
						System.err.println("* Exception executing a query: " + ex.getMessage());
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
				//Extent bidezko bilaketa
				else if(aukera==3) {
					try 
					{
						System.out.println("Extenta erabiltzen duen datu bilaketa");			

						persistentManager = persistentManagerFactory.getPersistenceManager();
						transaction = persistentManager.currentTransaction();	

						transaction.begin();
					
						Extent<erabiltzailea> extent = persistentManager.getExtent(erabiltzailea.class, true);			
						
						for (erabiltzailea e : extent) 
						{
							System.out.println("  -> " + e);
						}

						transaction.commit();
					}

					catch (Exception ex) 
					{
						System.err.println(" $ Error retrieving users using an 'Extent': " + ex.getMessage());
					}

					finally 
					{
						if (transaction != null && transaction.isActive()) 
						{
							transaction.rollback();
						}
						
						if (persistentManager != null && !persistentManager.isClosed()) 
						{
							persistentManager.close();
						}
					}
				}
				//2 bidaiari baino gehiagoko erreserbak ezabatu, querya erabiliz
				else if(aukera==4) {
					try
			        {
					    transaction.begin();
					    @SuppressWarnings("unchecked")
						Query<erreserba> erreserbaQuerya = persistentManager.newQuery("SELECT FROM " 
					    + erreserba.class.getName() + " WHERE bidaiariKopurua > 2 ORDER BY bidaiariKopurua ASC");
					    System.out.println("Querya erabiltzen duen datu ezabaketa");
					    System.out.println("2 bidaiari baino gehiagoko erreserbak ezabatuko dira");
					    for (erreserba e : erreserbaQuerya.executeList()) 
					    {
					        System.out.println("- erreserba: " + e.getKodea() + " bidaiari kopurua: " + e.getBidaiariKopurua() + " ezabatuko da.");
					        persistentManager.deletePersistent(e);
					    }
					    System.out.println("2 bidaiari baino gehiagoko hegaldiak ezabatu dira.");
					    transaction.commit();
					}

					catch(Exception ex)
					{
						System.err.println("* Exception executing a query: " + ex.getMessage());
					}
				}
				//Iberia aerolineari izena aldatzeko, IberiaBerria jarriz
				else if(aukera==5) {
					try
			        {
						transaction.begin();
					    aerolinea a = persistentManager.getObjectById(aerolinea.class, "l001");
					    a.setIzena("IberiaBerria");
						System.out.println("Querya erabiltzen duen datu aldaketa");
					    System.out.println("Izena aldatu zaio iberia aerolineari.");
					    transaction.commit();
					}

					catch(Exception ex)
					{
						System.err.println("* Exception executing a query: " + ex.getMessage());
					}
				}
	        }
			catch(Exception ex)
			{
				System.err.println("* Exception inserting data into db: " + ex.getMessage());
			}
		}
		
	}
}