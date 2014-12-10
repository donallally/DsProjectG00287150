package ie.gmit.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteFibonacci extends Remote{

	public String setFibonacciDequence(int max) throws RemoteException;
}
