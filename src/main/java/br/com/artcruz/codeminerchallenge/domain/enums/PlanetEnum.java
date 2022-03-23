package br.com.artcruz.codeminerchallenge.domain.enums;

/**
 * @author: Arthur Cruz
 */
public enum PlanetEnum {
	ANDAVARI("Andavari"),
	DEMETER("Demeter"),
	AQUA("Aqua"),
	CALAS("Calas");
	
	public final String label;
	
	private PlanetEnum(String label) {
		this.label = label;
	}
}
