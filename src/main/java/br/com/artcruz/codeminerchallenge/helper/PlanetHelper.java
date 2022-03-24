package br.com.artcruz.codeminerchallenge.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.com.artcruz.codeminerchallenge.domain.enums.PlanetEnum;

public class PlanetHelper {

	final static int ANDVARI = 1;
	final static int DEMETER = 2;
	final static int AQUA = 3;
	final static int CALAS = 4;
	
	public static Map<Integer, String> getPlanetsMap(){
		Map<Integer, String> pMap = new TreeMap<Integer, String>();
		
		pMap.put(1, PlanetEnum.ANDVARI.label);
		pMap.put(2, PlanetEnum.DEMETER.label);
		pMap.put(3, PlanetEnum.AQUA.label);
		pMap.put(4, PlanetEnum.CALAS.label);
		
		return pMap;
	}
	
	public static List<RouteHelper> getRoutesInfo() {
		List<RouteHelper> rh = new ArrayList<RouteHelper>();
		
		rh.add(new RouteHelper(ANDVARI, DEMETER, 0, true));
		rh.add(new RouteHelper(ANDVARI, AQUA, 13, false));
		rh.add(new RouteHelper(ANDVARI, CALAS, 23, false));
		rh.add(new RouteHelper(DEMETER, ANDVARI, 0, true));
		rh.add(new RouteHelper(DEMETER, AQUA, 22, false));
		rh.add(new RouteHelper(DEMETER, AQUA, 25, false));
		rh.add(new RouteHelper(CALAS, ANDVARI, 20, false));
		rh.add(new RouteHelper(CALAS, DEMETER, 25, false));
		rh.add(new RouteHelper(CALAS, AQUA, 15, false));
		
		return rh;
	}

	public static int getPlanetIdByName(String name) {
		Map<Integer, String> pMap = getPlanetsMap();
	
		int index = 0;
		
		for (Map.Entry<Integer, String> entry : pMap.entrySet()) {
		    if(entry.getValue().equals(name))
		    	index = entry.getKey();
		}
		
		return index;
	}
	
}
