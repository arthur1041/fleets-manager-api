package br.com.artcruz.codeminerchallenge.helper;

import java.io.Serializable;

public class PlanetWeightReportHelper implements Serializable{

	private static final long serialVersionUID = 1L;

	public PlanetWeightReportHelper() {
		
	}
	
	public PlanetWeightReportHelper(int totalReceived, int totalSent) {
		super();
		this.totalReceived = totalReceived;
		this.totalSent = totalSent;
	}

	private int totalReceived;
	
	private int totalSent;

	public int getTotalReceived() {
		return totalReceived;
	}

	public void setTotalReceived(int totalReceived) {
		this.totalReceived = totalReceived;
	}

	public int getTotalSent() {
		return totalSent;
	}

	public void setTotalSent(int totalSent) {
		this.totalSent = totalSent;
	}

	@Override
	public String toString() {
		return "PlanetWeightReportHelper [totalReceived=" + totalReceived + ", totalSent=" + totalSent + "]";
	}
	
}
