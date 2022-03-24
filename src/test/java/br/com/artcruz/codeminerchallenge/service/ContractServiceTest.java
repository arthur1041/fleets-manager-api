package br.com.artcruz.codeminerchallenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.artcruz.codeminerchallenge.domain.model.entity.Pilot;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Ship;
import br.com.artcruz.codeminerchallenge.domain.enums.PlanetEnum;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Contract;
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;
import br.com.artcruz.codeminerchallenge.domain.service.IService;

@SpringBootTest
class ContractServiceTest {

	@Autowired
	private IService<Contract> contractService;
	
	@Autowired
	private IService<Pilot> pilotService;
	
	@Autowired
	private IService<Ship> shipService;
	
	@Autowired
	private IRepository<Contract> contractRepository;

	@Test
	public void save() {
		Contract contract = new Contract();
	
		contract.setPilot(pilotService.find(1));
		contract.setShip(shipService.find(1));
		contract.setDescription("abc");
		contract.setDestinationPlanet(PlanetEnum.AQUA.label);
		contract.setOriginPlanet(PlanetEnum.ANDAVARI.label);
		contract.setValue(100);
		
		Contract contractDb = contractService.save(contract);
		
		assertNotNull(contractDb);
	}

	@Test
	public void update() {
		Contract contract = new Contract();

		contract.setDescription("A very valuable resource");
		
		Contract contractDb = contractService.update(1, contract);
		
		assertEquals(contractDb.getDescription(), contract.getDescription());
	}

	@Test
	public void list() {
		assertTrue(contractService.list().size() > 0);
	}
	
	@Test
	public void find() {
		assertNotNull(contractService.find(1));
	}

	@Test
	public void remove() {
		contractService.remove(1);
		
		assertNull(contractRepository.findById(1));
	}
	
}
