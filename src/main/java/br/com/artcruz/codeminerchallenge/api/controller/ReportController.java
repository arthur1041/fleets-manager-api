package br.com.artcruz.codeminerchallenge.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.artcruz.codeminerchallenge.domain.model.entity.Transaction;
import br.com.artcruz.codeminerchallenge.domain.service.ReportService;
import br.com.artcruz.codeminerchallenge.helper.PilotPercentageHelper;
import br.com.artcruz.codeminerchallenge.helper.PlanetWeightReportHelper;
import br.com.artcruz.codeminerchallenge.util.Utils;

@RestController
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	private ReportService reportService;

	@GetMapping("/weightmovimentation")
	public ResponseEntity<?> weightmov() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		try {
			Map<String, PlanetWeightReportHelper> map = reportService.sentAndReceivedTotals();

			return ResponseEntity.status(HttpStatus.OK).body(map);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(httpHeaders)
					.body(Utils.getJsonBody("Message", e.getMessage()));
		}
	}

	@GetMapping("/pilotspercentages")
	public ResponseEntity<?> pilotsstats() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		try {
			Map<Integer, PilotPercentageHelper> map = reportService.pilotTravelsStats();

			return ResponseEntity.status(HttpStatus.OK).body(map);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(httpHeaders)
					.body(Utils.getJsonBody("Message", e.getMessage()));
		}
	}
	
	@GetMapping("/transactions")
	public ResponseEntity<?> transactions() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		try {
			List<Transaction> transactions = reportService.transactionHistory();

			return ResponseEntity.status(HttpStatus.OK).body(transactions);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(httpHeaders)
					.body(Utils.getJsonBody("Message", e.getMessage()));
		}
	}
	
}
