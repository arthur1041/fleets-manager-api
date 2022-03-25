package br.com.artcruz.codeminerchallenge.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.artcruz.codeminerchallenge.domain.exception.EntityNotFoundException;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Ship;
import br.com.artcruz.codeminerchallenge.domain.service.IService;
import br.com.artcruz.codeminerchallenge.domain.service.ShipService;
import br.com.artcruz.codeminerchallenge.helper.RefuelBodyHelper;
import br.com.artcruz.codeminerchallenge.util.Utils;

@RestController
@RequestMapping("/ships")
public class ShipController {

	@Autowired
	private IService<Ship> shipService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Ship> list() {
		return shipService.list();
	}

	@GetMapping("/{shipId}")
	public ResponseEntity<?> find(@PathVariable("shipId") Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(shipService.find(id));
		} catch (EntityNotFoundException e) {
			final HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(httpHeaders)
					.body(Utils.getJsonBody("message", e.getMessage()));
		}
	}

	//1. Add pilots and their ships to the system.
	@PostMapping
	public ResponseEntity<?> add(@RequestBody Ship ship) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(shipService.save(ship));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body(Utils.getJsonBody("Message", e.getMessage()));
		}
	}

	//7. Register a refill of the fuel
	@PutMapping("/refuel/{shipId}")
	public ResponseEntity<?> addFuel(@PathVariable("shipId") Integer shipId, @RequestBody RefuelBodyHelper refuel){
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		try {
			((ShipService) shipService).refuel(shipService.find(shipId), refuel.getValue());
			return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(Utils.getJsonBody("Message", "Successfully refueled"));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body(Utils.getJsonBody("Message", e.getMessage()));
		}
	}
	
}
