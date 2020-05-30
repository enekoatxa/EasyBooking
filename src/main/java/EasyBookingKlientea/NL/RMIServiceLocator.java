package EasyBookingKlientea.NL;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import EasyBookingZerbitzaria.NL.FacadeAppService.IEasyZerbitzaria;

public class RMIServiceLocator {
	private IEasyZerbitzaria service;

	public RMIServiceLocator() {
	}

	public void setService(String ip, String port, String serviceName) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			Registry registry = LocateRegistry.getRegistry(Integer.valueOf(port));
			String name = "//" + ip + ":" + port + "/" + serviceName;
			//service = (IEasyZerbitzaria) java.rmi.Naming.lookup(name);
			service = (IEasyZerbitzaria) registry.lookup(name);
			System.err.println("Klientea RMI zerbitzarira konektatu da ");

		} catch (Exception e) {
			System.err.println("- Klientean exzepzioa RMI zerbitzarira konektatzean " + e.getMessage());
			e.printStackTrace();
		}
	}

	public IEasyZerbitzaria getService() {
		return service;
	}

}
