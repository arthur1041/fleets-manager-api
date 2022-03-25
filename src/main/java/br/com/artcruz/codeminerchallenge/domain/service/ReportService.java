package br.com.artcruz.codeminerchallenge.domain.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.artcruz.codeminerchallenge.helper.PilotPercentageHelper;
import br.com.artcruz.codeminerchallenge.helper.PlanetWeightReportHelper;
import br.com.artcruz.codeminerchallenge.infrastructure.repository.ReportRepository;

@Service
public class ReportService {

	@Autowired
	private ReportRepository reportRepository;
	
	public Map<String, PlanetWeightReportHelper> sentAndReceivedTotals() {
		
		try {
			return reportRepository.sentAndReceivedTotals();
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong while generating the report");
		}
		
	}

	public Map<Integer, PilotPercentageHelper> pilotTravelsStats() {
		
		try {
			return reportRepository.pilotTravelsStats();
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong while generating the report");
		}
		
	}
	
}
