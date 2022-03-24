package br.com.artcruz.codeminerchallenge.domain.enums;

/**
 * @author: Arthur Cruz
 */
public enum PlanetEnum {
	ANDVARI("Andvari"),
	DEMETER("Demeter"),
	AQUA("Aqua"),
	CALAS("Calas");
	
	public final String label;
	
	private PlanetEnum(String label) {
		this.label = label;
	}
}
