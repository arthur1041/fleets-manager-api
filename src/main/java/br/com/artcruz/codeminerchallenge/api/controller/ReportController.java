package br.com.artcruz.codeminerchallenge.api.controller;

import java.util.Map;

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
	
	@GetMapping("/weightmov")
	public ResponseEntity<?> teste() {
			
		Map<String, PlanetWeightReportHelper> mapTeste = reportsService.sentAndReceivedTotals();
		
		return ResponseEntity.status(HttpStatus.OK).body(mapTeste);
	}
	
	
}
