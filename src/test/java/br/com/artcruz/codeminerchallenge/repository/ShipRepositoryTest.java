package br.com.artcruz.codeminerchallenge.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.artcruz.codeminerchallenge.domain.model.entity.Pilot;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Ship;
import br.com.artcruz.codeminerchallenge.domain.repository.GenericRepository;

/**
 * @author: Arthur Cruz
 */
@SpringBootTest
class ShipRepositoryTest {

	@Autowired
	private GenericRepository<Ship> shipRepository;
	
	@Autowired
	private GenericRepository<Pilot> pilotRepository;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void list() {
		assertTrue(shipRepository.list().size() > 0);
	}

	@Test
	public void create() {
		Ship ship = new Ship();

		
		ship.setFuelCapacity(1000);
		ship.setFuelLevel(1000);
		ship.setPilot(pilotRepository.findById(2));

		Ship shipDb = shipRepository.createOrUpdate(ship);

		assertNotNull(shipDb);

	}

	@Test
	public void update() {
		Ship ship = shipRepository.findById(1);
		
		ship.setPilot(pilotRepository.findById(1));
		
		shipRepository.createOrUpdate(ship);
		
		assertEquals(shipRepository.findById(1).getPilot().getId(), 1);
	}
	
	@Test
	public void findById() {
		assertNotNull(shipRepository.findById(1));
	}
	
	@Test
	public void delete() {
		shipRepository.delete(1);
		assertNull(shipRepository.findById(1));
	}
}
