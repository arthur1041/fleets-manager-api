package br.com.artcruz.codeminerchallenge.util;

import br.com.artcruz.codeminerchallenge.domain.enums.PlanetEnum;
import br.com.artcruz.codeminerchallenge.domain.enums.ResourceEnum;

public class Utils {

	public static boolean validatePlanetName(String name) {
		if (PlanetEnum.ANDAVARI.label.equals(name) || PlanetEnum.AQUA.label.equals(name)
				|| !PlanetEnum.CALAS.label.equals(name) || !PlanetEnum.DEMETER.label.equals(name))
			return true;

		return false;
	}

	public static boolean validateResourceName(String name) {
		if (ResourceEnum.FOOD.label.equals(name) || ResourceEnum.MINERALS.label.equals(name)
				|| ResourceEnum.WATER.label.equals(name))
			return true;

		return false;
	}

}
