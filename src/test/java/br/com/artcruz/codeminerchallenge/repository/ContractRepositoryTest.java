package br.com.artcruz.codeminerchallenge.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.artcruz.codeminerchallenge.domain.model.entity.Ship;
import br.com.artcruz.codeminerchallenge.domain.enums.PlanetEnum;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Contract;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Resource;
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;

/**
 * @author: Arthur Cruz
 */
@SpringBootTest
class ContractRepositoryTest {

	@Autowired
	private IRepository<Contract> contractRepository;
	
	@Autowired
	private IRepository<Ship> shipRepository;

	@Autowired
	private IRepository<Resource> resourceRepository;

	@Test
	public void list() {
		assertTrue(contractRepository.list().size() > 0);
	}

	@Test
	public void create() {
		Contract contract = new Contract();

		Ship ship = shipRepository.findById(2); 
		
		contract.setPilot(ship.getPilot());
		contract.setShip(ship);
		contract.setDescription("blablabla");
		contract.setOriginPlanet(PlanetEnum.DEMETER.label);
		contract.setDestinationPlanet(PlanetEnum.AQUA.label);
		contract.setValue(10000);
		contract.setPayload(resourceRepository.list());
		

		Contract contractDb = contractRepository.createOrUpdate(contract);

		assertNotNull(contractDb);
	}

	@Test
	public void update() {
		Contract contract = contractRepository.findById(1);
		
		Ship ship = shipRepository.findById(2);
		
		contract.setShip(ship);
		contract.setPilot(ship.getPilot());
		
		contractRepository.createOrUpdate(contract);
		
		assertEquals(contractRepository.findById(1).getPilot().getId(), ship.getPilot().getId());
	}
	
	@Test
	public void findById() {
		assertNotNull(contractRepository.findById(1));
	}
	
	@Test
	public void delete() {
		contractRepository.delete(1);
		assertNull(contractRepository.findById(1));
	}
}
