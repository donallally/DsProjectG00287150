package ie.gmit;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Fibonacci extends UnicastRemoteObject implements RemoteFibonacci {
	private static final long serialVersionUID = 1L;

	public Fibonacci() throws RemoteException {
		super();
	}

	public String setFibonacciDequence(int max) throws RemoteException {

		return null;
	}

	public String genFib(int number) throws RemoteException {
		List<Integer> results = new ArrayList<Integer>();//creates a list of results looping and and keeps adding until the desired length of the sequence is reached
		for (int i = 0; i < number; i++) {
			results.add((int) Math.round(Math.pow(Math.sqrt(5) + 1, i) / (Math.pow(2, i) * Math.sqrt(5))));//formula for the sequence
		}
		return results.toString();//return the results parsed into a string value to make it easier for output
	}
}
