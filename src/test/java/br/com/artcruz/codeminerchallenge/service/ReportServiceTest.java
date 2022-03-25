package br.com.artcruz.codeminerchallenge.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.artcruz.codeminerchallenge.domain.service.ReportsService;

/**
 * @author: Arthur Cruz
 */
@SpringBootTest
class ReportServiceTest {

	@Autowired
	private ReportsService reportsService;
	
	@Test
	public void sentAndReceivedTotals() {
		reportsService.sentAndReceivedTotals();
	}
}
