package br.com.artcruz.codeminerchallenge.domain.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.artcruz.codeminerchallenge.domain.enums.PlanetEnum;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Contract;
import br.com.artcruz.codeminerchallenge.helper.PlanetWeightReportHelper;

@Service
public class ReportsService {

	@Autowired
	private IService<Contract> contractService;
	
	public Map<String, PlanetWeightReportHelper> sentAndReceivedTotals() {
		
		List<Contract> contracts = contractService.list();
		
		Map<String, PlanetWeightReportHelper> sentAndReceivedMap = new TreeMap<>();
		
		int sumRecAndvari = 0, sumSentAndvari = 0;
		int sumRecAqua = 0, sumSentAqua = 0;
		int sumRecCalas = 0, sumSentCalas = 0;
		int sumRecDemeter = 0, sumSentDemeter = 0;
		
		for (Contract contract : contracts) {
			if(PlanetEnum.ANDVARI.label.equalsIgnoreCase(contract.getDestinationPlanet()))
				sumRecAndvari = contract.getResourcesTotalWeight();
			if(PlanetEnum.AQUA.label.equalsIgnoreCase(contract.getDestinationPlanet()))
				sumRecAqua = contract.getResourcesTotalWeight();
			if(PlanetEnum.CALAS.label.equalsIgnoreCase(contract.getDestinationPlanet()))
				sumRecCalas = contract.getResourcesTotalWeight();
			if(PlanetEnum.DEMETER.label.equalsIgnoreCase(contract.getDestinationPlanet()))
				sumRecDemeter = contract.getResourcesTotalWeight();
		}
		
		for (Contract contract : contracts) {
			if(PlanetEnum.ANDVARI.label.equalsIgnoreCase(contract.getOriginPlanet()))
				sumSentAndvari = contract.getResourcesTotalWeight();
			if(PlanetEnum.AQUA.label.equalsIgnoreCase(contract.getOriginPlanet()))
				sumSentAqua = contract.getResourcesTotalWeight();
			if(PlanetEnum.CALAS.label.equalsIgnoreCase(contract.getOriginPlanet()))
				sumSentCalas = contract.getResourcesTotalWeight();
			if(PlanetEnum.DEMETER.label.equalsIgnoreCase(contract.getOriginPlanet()))
				sumSentDemeter = contract.getResourcesTotalWeight();
		}
		
		sentAndReceivedMap.put(PlanetEnum.ANDVARI.label, new PlanetWeightReportHelper(sumRecAndvari, sumSentAndvari));
		sentAndReceivedMap.put(PlanetEnum.AQUA.label, new PlanetWeightReportHelper(sumRecAqua, sumSentAqua));
		sentAndReceivedMap.put(PlanetEnum.CALAS.label, new PlanetWeightReportHelper(sumRecCalas, sumSentCalas));
		sentAndReceivedMap.put(PlanetEnum.DEMETER.label, new PlanetWeightReportHelper(sumRecDemeter, sumSentDemeter));
		
		return sentAndReceivedMap;
	}
	
}
