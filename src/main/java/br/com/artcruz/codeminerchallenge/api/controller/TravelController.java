package br.com.artcruz.codeminerchallenge.api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.artcruz.codeminerchallenge.domain.exception.BlockedRouteException;
import br.com.artcruz.codeminerchallenge.domain.exception.EntityNotFoundException;
import br.com.artcruz.codeminerchallenge.domain.exception.InvalidTravelDestinationException;
import br.com.artcruz.codeminerchallenge.domain.exception.NoShipsAvailableException;
import br.com.artcruz.codeminerchallenge.domain.exception.NotEnoughFuelException;
import br.com.artcruz.codeminerchallenge.domain.exception.PilotTooYoungException;
import br.com.artcruz.codeminerchallenge.domain.service.TravelService;
import br.com.artcruz.codeminerchallenge.helper.PlanetHelper;
import br.com.artcruz.codeminerchallenge.util.Utils;

@RestController
@RequestMapping("/travel")
public class TravelController {

	@Autowired
	private TravelService travelService;

	//3. Travel between planets
	@GetMapping("/from/{idFrom}/to/{idTo}/withpilot/{idPilot}")
	public ResponseEntity<?> freeTravel(@PathVariable("idFrom") Integer idFrom, @PathVariable("idTo") Integer idTo,
			@PathVariable("idPilot") Integer idPilot) {
		final HttpHeaders httpHeaders = new HttpHeaders();

		try {
			travelService.doFreeTravel(idFrom, idTo, idPilot);
		} catch (InvalidTravelDestinationException e) {
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders)
					.body(Utils.getJsonBody("Message", e.getMessage()));
		} catch (BlockedRouteException e) {
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders)
					.body(Utils.getJsonBody("Message", e.getMessage()));
		} catch (EntityNotFoundException e) {
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(httpHeaders)
					.body(Utils.getJsonBody("message", e.getMessage()));
		} catch (NoShipsAvailableException e) {
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders)
					.body(Utils.getJsonBody("Message", e.getMessage()));
		} catch (NotEnoughFuelException e) {
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders)
					.body(Utils.getJsonBody("Message", e.getMessage()));
		} catch (PilotTooYoungException e) {
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders)
					.body(Utils.getJsonBody("Message", e.getMessage()));
		}

		Map<Integer, String> planets = PlanetHelper.getPlanetsMap();

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(Utils.getJsonBody("Message",
				"Travel fufilled from " + planets.get(idFrom) + " to " + planets.get(idTo) + "!"));
	}
}
