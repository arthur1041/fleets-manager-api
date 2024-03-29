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

import br.com.artcruz.codeminerchallenge.domain.model.entity.Contract;
import br.com.artcruz.codeminerchallenge.domain.service.ContractService;
import br.com.artcruz.codeminerchallenge.domain.service.IService;
import br.com.artcruz.codeminerchallenge.util.Utils;

/**
 * @author: Arthur Cruz
 */
@RestController
@RequestMapping("/contracts")
public class ContractController {

	@Autowired
	private IService<Contract> contractService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Contract> list() {
		return contractService.list();
	}

	// 4. List open contracts
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/open")
	public List<Contract> listOpen() {
		return ((ContractService) contractService).listOpenContracts();
	}

	// 5. Accept transport contracts
	@PutMapping("/accept/{contractId}")
	public ResponseEntity<?> acceptContract(@PathVariable("contractId") Integer id) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		try {
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			((ContractService) contractService).acceptContract(id);
			return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders)
					.body(Utils.getJsonBody("Message", "Contract accepet succesfully! Now you can execute it."));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(httpHeaders)
					.body(Utils.getJsonBody("message", e.getMessage()));
		}

	}

	@PutMapping("/execute/{contractId}")
	public ResponseEntity<?> executeContract(@PathVariable("contractId") Integer id) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		Contract contract = null;
		
		try {
			contract = contractService.find(id);
			((ContractService) contractService).executeContract(contract);
		} catch (RuntimeException e) {
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders)
					.body(Utils.getJsonBody("Message", e.getMessage()));
		}
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(Utils.getJsonBody("Message",
				"Travel fufilled from " + contract.getOriginPlanet() + " to " + contract.getDestinationPlanet() + "!"));
	}

	@GetMapping("/{contractId}")
	public ResponseEntity<?> find(@PathVariable("contractId") Integer id) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		try {
			return ResponseEntity.status(HttpStatus.OK).body(contractService.find(id));
		} catch (RuntimeException e) {
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(httpHeaders)
					.body(Utils.getJsonBody("message", e.getMessage()));
		}
	}

	// 2. Publish transport contracts
	@PostMapping
	public ResponseEntity<?> add(@RequestBody Contract contract) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(contractService.save(contract));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders)
					.body(Utils.getJsonBody("Message", e.getMessage()));
		}
	}

}
