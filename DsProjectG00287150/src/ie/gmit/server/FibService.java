package ie.gmit.server;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FibService {
	private LinkedList<FibRequest> inQueue = new LinkedList<FibRequest>();
	private Map<Integer, String> outQueue = new HashMap<Integer, String>();

	public int add(int max) {
		// generate random JOB number
		int jobNumber = (int) Math.random();
		inQueue.add(new FibRequest(jobNumber, max));
		return jobNumber;
	}

	public void addResult(FibRequest fr, String result){
		this.outQueue.put(fr.getJobNum(), result);
	}
	
	public String getResult(int jobNumber) {
		if (outQueue.containsKey(jobNumber)) {
			String result = outQueue.get(jobNumber);
			outQueue.remove(jobNumber);
			return result;
		} else {
			return null;
		}
	}
}
