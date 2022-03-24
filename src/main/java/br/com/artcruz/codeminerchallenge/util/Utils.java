package br.com.artcruz.codeminerchallenge.util;

import br.com.artcruz.codeminerchallenge.domain.enums.PlanetEnum;
import br.com.artcruz.codeminerchallenge.domain.enums.ResourceEnum;

/**
 * @author: Arthur Cruz
 */
public class Utils {

	public static boolean validatePlanetName(String name) {
		if (PlanetEnum.ANDAVARI.label.equalsIgnoreCase(name) || PlanetEnum.AQUA.label.equalsIgnoreCase(name)
				|| PlanetEnum.CALAS.label.equalsIgnoreCase(name) || PlanetEnum.DEMETER.label.equalsIgnoreCase(name))
			return true;

		return false;
	}

	public static boolean validateResourceName(String name) {
		if (ResourceEnum.FOOD.label.equalsIgnoreCase(name) || ResourceEnum.MINERALS.label.equalsIgnoreCase(name)
				|| ResourceEnum.WATER.label.equalsIgnoreCase(name))
			return true;

		return false;
	}
	
	public static String getJsonBody(String attribute, String value) {
		return "{ \"" + attribute + "\": \"" + value + "\" }";
	}

}
