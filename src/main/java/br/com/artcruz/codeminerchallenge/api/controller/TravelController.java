package br.com.artcruz.codeminerchallenge.api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.artcruz.codeminerchallenge.domain.service.TravelService;
import br.com.artcruz.codeminerchallenge.util.PlanetUtils;
import br.com.artcruz.codeminerchallenge.util.Utils;

/**
 * @author: Arthur Cruz
 */
@RestController
@RequestMapping("/travel")
public class TravelController {

	@Autowired
	private TravelService travelService;

	//3. Travel between planets
	@PutMapping("/from/{idFrom}/to/{idTo}/withpilot/{idPilot}")
	public ResponseEntity<?> freeTravel(@PathVariable("idFrom") Integer idFrom, @PathVariable("idTo") Integer idTo,
			@PathVariable("idPilot") Integer idPilot) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		try {
			travelService.doTravel(idFrom, idTo, idPilot);
		} catch (RuntimeException e) {
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders)
					.body(Utils.getJsonBody("Message", e.getMessage()));
		} 

		Map<Integer, String> planets = PlanetUtils.getPlanetsMap();

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(Utils.getJsonBody("Message",
				"Travel fufilled from " + planets.get(idFrom) + " to " + planets.get(idTo) + "!"));
	}
}
