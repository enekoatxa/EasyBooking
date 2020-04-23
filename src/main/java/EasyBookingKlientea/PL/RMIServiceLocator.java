package EasyBookingKlientea.PL;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServiceLocator 
{
	private IEasyZerbitzaria service = null;

	
	 public RMIServiceLocator() { }
	  
	 
	 public  void setService(String ip, String port, String serviceName) 
	    {    
	    	
			// Add your code to locate and initialize the SERVICE reference
		 try {
				Registry registry = LocateRegistry.getRegistry(Integer.valueOf(port));
				String name = "//" + ip + ":" + port + "/" + service;
				service = (IEasyZerbitzaria) java.rmi.Naming.lookup(name);
				service = (IEasyZerbitzaria) registry.lookup(name);
				
				System.err.println("Klientean RMI zerbitzarira konektatu da ");

			} catch (Exception e) {
				System.err.println("- Klientean exzepzioa RMI zerbitzarira konektatzean " + e.getMessage());
				e.printStackTrace();
			}
	    }
	    
	    public IEasyZerbitzaria getService() 
	    {    	
	     	return service;
	    }
	   
	
}
