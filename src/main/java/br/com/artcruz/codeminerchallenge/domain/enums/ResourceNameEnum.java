package br.com.artcruz.codeminerchallenge.domain.enums;

/**
 * @author: Arthur Cruz
 */
public enum ResourceNameEnum {
	MINERALS("Minerals"),
	WATER("Water"),
	FOOD("Food");
	
	public final String label;
	
	private ResourceNameEnum(String label) {
		this.label = label;
	}
}
