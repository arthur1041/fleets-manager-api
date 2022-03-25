package br.com.artcruz.codeminerchallenge.unit.repository;


import static org.junit.jupiter.api.Assertions.assertTrue;

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
		assertTrue(reportRepository.sentAndReceivedTotals().size()>0);
	}
	
	@Test
	public void pilotTravelsStats() {
		assertTrue(reportRepository.sentAndReceivedTotals().size()>0);
	}
}
