package br.com.artcruz.codeminerchallenge.domain.enums;

/**
 * @author: Arthur Cruz
 */
public enum PlanetEnum {
	ANDVARI("andvari"),
	DEMETER("demeter"),
	AQUA("aqua"),
	CALAS("calas");
	
	public final String label;
	
	private PlanetEnum(String label) {
		this.label = label;
	}
}
