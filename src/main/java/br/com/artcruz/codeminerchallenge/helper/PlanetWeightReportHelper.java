package br.com.artcruz.codeminerchallenge.helper;

import java.io.Serializable;

/**
 * @author: Arthur Cruz
 */
public class PlanetWeightReportHelper implements Serializable{

	private static final long serialVersionUID = 1L;

	public PlanetWeightReportHelper() {

	}
	
	public PlanetWeightReportHelper(MovHelper received, MovHelper sent) {
		super();
		this.received = received;
		this.sent = sent;
	}

	public MovHelper received;
	
	public MovHelper sent;

	@Override
	public String toString() {
		return "PlanetWeightReportHelper [received=" + received + ", sent=" + sent + "]";
	}

}
