package ie.gmit.server;

public class FibRequest {

	private int jobNum;
	private int max;

	public FibRequest(int jobNumber, int max) {
		this.jobNum = jobNumber;
		this.max = max;
	}

	public int getJobNum() {
		return jobNum;
	}

	public void setJobNum(int jobNum) {
		this.jobNum = jobNum;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

}
