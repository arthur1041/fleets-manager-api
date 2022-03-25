package br.com.artcruz.codeminerchallenge.domain.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.artcruz.codeminerchallenge.domain.enums.PlanetEnum;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Contract;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Resource;
import br.com.artcruz.codeminerchallenge.helper.PlanetWeightReportHelper;

@Service
public class ReportsService {

	@Autowired
	private IService<Contract> contractService;
	
	public Map<String, PlanetWeightReportHelper> sentAndReceivedTotals() {
		
		
		List<Contract> contracts = contractService.list();
		
		Map<String, Map<String, PlanetWeightReportHelper>> sentAndReceivedMap = new TreeMap<>();
		
	
		int sumRecAndvariFood = 0, sumSentAndvariFood = 0;
		int sumRecAndvariWater = 0, sumSentAndvariWater = 0;
		int sumRecAndvariMinerals = 0, sumSentAndvariMinerals = 0;
		int sumRecCalasFood = 0, sumSentCalasFood = 0;
		int sumRecCalasWater = 0, sumSentCalasWater = 0;
		int sumRecCalasMinerals = 0, sumSentCalasMinerals = 0;
		int sumRecDemeterFood = 0, sumSentDemeterFood = 0;
		int sumRecDemeterWater = 0, sumSentDemeterWater = 0;
		int sumRecDemeterMinerals = 0, sumSentDemeterMinerals = 0;
		int sumRecAquaFood = 0, sumSentAquaFood = 0;
		int sumRecAquaWater = 0, sumSentAquaWater = 0;
		int sumRecAquaMinerals = 0, sumSentAquaMinerals = 0;

		
		for (Contract contract : contracts) {		
			
			if(sentAndReceivedMap.containsKey(contract.getOriginPlanet())) {
				
			};
			
			if(PlanetEnum.ANDVARI.label.equalsIgnoreCase(contract.getDestinationPlanet())) {
				for (Resource resource : contract.getPayload()) {
					
				}
			}
			if(PlanetEnum.AQUA.label.equalsIgnoreCase(contract.getDestinationPlanet()));
			if(PlanetEnum.CALAS.label.equalsIgnoreCase(contract.getDestinationPlanet()));
			if(PlanetEnum.DEMETER.label.equalsIgnoreCase(contract.getDestinationPlanet()));
		}
		return null;
		
		
		
//		return sentAndReceivedMap;
	}
	
}
