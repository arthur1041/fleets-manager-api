package br.com.artcruz.codeminerchallenge.api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.artcruz.codeminerchallenge.domain.service.ReportsService;
import br.com.artcruz.codeminerchallenge.helper.PlanetWeightReportHelper;
import br.com.artcruz.codeminerchallenge.util.Utils;

@RestController
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	private ReportsService reportsService;

	@GetMapping("/weightmovimentation")
	public ResponseEntity<?> teste() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		try {
			Map<String, PlanetWeightReportHelper> mapTeste = reportsService.sentAndReceivedTotals();

			return ResponseEntity.status(HttpStatus.OK).body(mapTeste);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(httpHeaders)
					.body(Utils.getJsonBody("Message", e.getMessage()));
		}
	}

}
