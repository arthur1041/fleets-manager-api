package br.com.artcruz.codeminerchallenge.helper;

import java.util.Map;
import java.util.TreeMap;

import br.com.artcruz.codeminerchallenge.domain.enums.PlanetEnum;

public class PlanetsHelper {

	public Map<Integer, String> getPlanetsMap(){
		Map<Integer, String> pMap = new TreeMap<Integer, String>();
		
		pMap.put(1, PlanetEnum.ANDAVARI.label);
		pMap.put(2, PlanetEnum.DEMETER.label);
		pMap.put(3, PlanetEnum.AQUA.label);
		pMap.put(4, PlanetEnum.CALAS.label);
		
		return pMap;
	}
	
}
