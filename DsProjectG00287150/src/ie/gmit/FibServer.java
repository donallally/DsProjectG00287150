package ie.gmit;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FibServer extends Remote{

	int add(int max) throws RemoteException;

	void addResult(FibRequest fr, String result) throws RemoteException;

	String getResult(int jobNumber) throws RemoteException;

	void genFib();


}