package ie.gmit;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Fibonacci extends UnicastRemoteObject implements RemoteFibonacci {
	private static final long serialVersionUID = 1L;

	protected Fibonacci(int port) throws RemoteException {
		super(port);
	}

	public String setFibonacciDequence(int max) throws RemoteException {
		
		return null;
	}
	public List<Integer> genFib(int number) throws RemoteException{
		List<Integer> results = new ArrayList<Integer>();
		for (int i=0; i<number; i++){
			results.add((int) Math.round(Math.pow(Math.sqrt(5)+1, i) / (Math.pow(2, i) * Math.sqrt(5))));
		}
		return results;
	}

	public String add(String parameter) {
		return null;
	}
}
