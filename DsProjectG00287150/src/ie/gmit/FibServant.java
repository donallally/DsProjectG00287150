package ie.gmit;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class FibServant {

	public static void main(String[] args) throws Exception {

		LocateRegistry.createRegistry(1090);//port number
		Naming.rebind("Start", new Fibonacci());
		Naming.rebind("FibServer", new FibServiceImpl());
		System.out.println("Server ready...");
		Worker worker = new Worker();//create a new worker
		worker.run();//run the code in the worker class
		
	}
}
