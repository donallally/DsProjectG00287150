package ie.gmit;

import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
public class FibServiceImpl extends UnicastRemoteObject implements FibServer {

	private static final long serialVersionUID = 1L;
	private LinkedList<FibRequest> inQueue = new LinkedList<FibRequest>();//creates a LinkedList that takes in FibRequests (job numbers)
	private Map<Integer, String> outQueue = new HashMap<Integer, String>();//creates a hash map that links the job number to the result
	private static RemoteFibonacci rf;

	public FibServiceImpl() throws Exception {
		try {
			rf = (RemoteFibonacci) Naming.lookup("rmi://127.0.0.1:1090/Start");//look at this port
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int add(int max) {
		// generate random JOB number
		Random rand = new Random();
		int jobNumber = rand.nextInt(1000) + 1; // generate a number between 0
												// and 1000 ,+1 prevents the
												// generator from generating 0
		inQueue.add(new FibRequest(jobNumber, max));
		System.out.println(inQueue.toString() + "Job No: " + jobNumber + ", Max No:" + max);//print the job number on the server console
		return jobNumber;
	}

	public void addResult(FibRequest fr, String result) {
		this.outQueue.put(fr.getJobNumber(), result);//add the result to the finished list of jobs
	}

	public String getResult(int jobNumber) {//retrieve the result from the outQueue
		if (outQueue.containsKey(jobNumber)) {//if the jobNumber is found then take it out
			String result = outQueue.get(jobNumber);
			outQueue.remove(jobNumber);//remove the job number from the finished list
			System.out.println(inQueue.toString());//print it out onto the server console
			return result;
		}
		else{
			return null;
		}
	}	
	
	public void genFib(){//generate the sequence
		try{
			FibRequest value = inQueue.poll();
			String result = rf.genFib(value.getMax());
			addResult(value, result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	
	}
	
}