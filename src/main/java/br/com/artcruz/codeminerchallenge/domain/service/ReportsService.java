package br.com.artcruz.codeminerchallenge.domain.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.artcruz.codeminerchallenge.helper.PlanetWeightReportHelper;
import br.com.artcruz.codeminerchallenge.infrastructure.repository.ReportsRepository;

@Service
public class ReportsService {

	@Autowired
	private ReportsRepository reportsRepository;
	
	public Map<String, PlanetWeightReportHelper> sentAndReceivedTotals() {
		
		try {
			return reportsRepository.sentAndReceivedTotals();
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong while generating the report");
		}
		
	}
	
}
