package br.com.artcruz.codeminerchallenge.domain.enums;

/**
 * @author: Arthur Cruz
 */
public enum ResourceEnum {
	MINERALS("Minerals"),
	WATER("Water"),
	FOOD("Food");
	
	public final String label;
	
	private ResourceEnum(String label) {
		this.label = label;
	}
}
