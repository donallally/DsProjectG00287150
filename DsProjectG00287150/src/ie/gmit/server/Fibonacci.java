package ie.gmit.server;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci extends UnicastRemoteObject implements RemoteFibonacci {
	private static final long serialVersionUID = 6492214887329898525L;

	public Fibonacci() throws RemoteException{
		super();
	}
	
	public String genFib(int number){
		List<Integer> results = new ArrayList<Integer>();
		for (int i=0; i<number; i++){
			results.add((int) Math.round(Math.pow(Math.sqrt(5)+1, i) / (Math.pow(2, i) * Math.sqrt(5))));
		}
		return results.toString();
	}
}
