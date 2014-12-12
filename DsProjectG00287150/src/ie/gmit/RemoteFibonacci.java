package ie.gmit;

import java.rmi.*;

public interface RemoteFibonacci extends Remote{
	
	public String genFib(int number) throws RemoteException ;
}