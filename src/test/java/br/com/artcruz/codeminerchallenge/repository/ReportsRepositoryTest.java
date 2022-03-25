package br.com.artcruz.codeminerchallenge.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.artcruz.codeminerchallenge.infrastructure.repository.ReportsRepository;

/**
 * @author: Arthur Cruz
 */
@SpringBootTest
class ReportsRepositoryTest {

	@Autowired
	private ReportsRepository reportsRepository;
	
	@Test
	public void sentAndReceivedTotals() {
		reportsRepository.sentAndReceivedTotals();
	}
	
	@Test
	public void pilotTravelsStats() {
		reportsRepository.pilotTravelsStats();
	}
}
