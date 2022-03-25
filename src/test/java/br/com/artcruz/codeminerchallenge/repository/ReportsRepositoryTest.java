package br.com.artcruz.codeminerchallenge.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.artcruz.codeminerchallenge.infrastructure.repository.ReportRepository;

/**
 * @author: Arthur Cruz
 */
@SpringBootTest
class ReportsRepositoryTest {

	@Autowired
	private ReportRepository reportRepository;
	
	@Test
	public void sentAndReceivedTotals() {
		reportRepository.sentAndReceivedTotals();
	}
	
	@Test
	public void pilotTravelsStats() {
		reportRepository.pilotTravelsStats();
	}
}
