package br.com.artcruz.codeminerchallenge.api.controller;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.artcruz.codeminerchallenge.domain.service.ReportsService;
import br.com.artcruz.codeminerchallenge.helper.PlanetWeightReportHelper;

@RestController
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	private ReportsService reportsService;
	
	@GetMapping("/weightmovimentation")
	public ResponseEntity<?> teste() {
//		Entry<String, PlanetWeightReportHelper> abc = new AbstractMap.SimpleEntry<String, PlanetWeightReportHelper>("set", new PlanetWeightReportHelper(100, 110));
		
		Map<String, PlanetWeightReportHelper> mapTeste = reportsService.sentAndReceivedTotals();
		
		return null;
	}
	
	
}
