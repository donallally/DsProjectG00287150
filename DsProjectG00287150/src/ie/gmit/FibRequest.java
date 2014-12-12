package ie.gmit;

public class FibRequest {

	private int JobNumber;
	private int max;
	
	public FibRequest(int JobNumber, int max){
		this.JobNumber = JobNumber;
		this.max = max;
	}

	public int getJobNumber() {
		return JobNumber;
	}

	public void setJobNumber(int jobNumber) {
		JobNumber = jobNumber;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
}