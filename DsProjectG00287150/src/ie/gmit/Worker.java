package ie.gmit;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Worker implements Runnable {

	private static FibServer fs;
	
	public Worker(){
	

		try {
			fs = (FibServer) Naming.lookup("rmi://127.0.0.1:1090/FibServer");//look at this location
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void run() {
	
		while(true){
			try {
				fs.genFib();//generate the fibonacci number
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try{
				Thread.sleep(10000);//tell the thread to sleep for 10 seconds
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}

}
