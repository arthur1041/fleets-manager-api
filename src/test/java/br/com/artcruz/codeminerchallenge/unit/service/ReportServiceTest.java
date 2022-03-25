package br.com.artcruz.codeminerchallenge.unit.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.artcruz.codeminerchallenge.domain.service.ReportService;

/**
 * @author: Arthur Cruz
 */
@SpringBootTest
public class ReportServiceTest {

	@Autowired
	private ReportService reportService;
	
	@Test
	public void transactionHistory() {
		assertTrue(reportService.transactionHistory().size()>0);
	}
	
}
