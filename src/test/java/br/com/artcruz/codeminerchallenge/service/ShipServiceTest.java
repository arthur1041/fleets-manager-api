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
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;
import br.com.artcruz.codeminerchallenge.domain.service.IService;

@SpringBootTest
class ShipServiceTest {

	@Autowired
	private IService<Ship> shipService;
	
	@Autowired
	private IService<Pilot> pilotService;
	
	@Autowired
	private IRepository<Ship> shipRepository;

	@Test
	public void save() {
		Ship ship = new Ship();

		ship.setFuelCapacity(1);
		ship.setFuelLevel(1);
		ship.setPilot(pilotService.find(1));
		ship.setWeightCapacity(1);
		
		Ship shipDb = shipService.save(ship);
		
		assertNotNull(shipDb);
	}

	@Test
	public void update() {
		Ship ship = new Ship();

		ship.setFuelCapacity(10);
		
		Ship shipDb = shipService.update(1, ship);
		
		assertEquals(shipDb.getFuelCapacity(), ship.getFuelCapacity());
	}

	@Test
	public void list() {
		assertTrue(shipService.list().size() > 0);
	}
	
	@Test
	public void find() {
		assertNotNull(shipService.find(1));
	}

	@Test
	public void remove() {
		shipService.remove(1);
		
		assertNull(shipRepository.findById(1));
	}
	
}
