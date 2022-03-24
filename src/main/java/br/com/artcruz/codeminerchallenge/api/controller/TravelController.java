package br.com.artcruz.codeminerchallenge.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travel")
public class TravelController {

	@GetMapping("/from/{idFrom}/to/{idTo}")
	public void freeTravel(@PathVariable("idFrom") Integer idFrom, @PathVariable("idFrom") Integer idTo) {
		
	}
}
