package br.com.artcruz.codeminerchallenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.artcruz.codeminerchallenge.domain.model.entity.Pilot;
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;
import br.com.artcruz.codeminerchallenge.domain.service.IService;

/**
 * @author: Arthur Cruz
 */
@SpringBootTest
class PilotServiceTest {

	@Autowired
	private IService<Pilot> pilotService;
	
	@Autowired
	private IRepository<Pilot> pilotRepository;

	@Test
	public void save() {
		Pilot pilot = new Pilot();

		pilot.setName("Adam");
		pilot.setBirthDate(new Date());
		pilot.setCredits(1000);
		pilot.setLocationPlanet("Aqua");
		pilot.setPilotCertification("0000000");

		Pilot pilotDb = pilotService.save(pilot);
		
		assertNotNull(pilotDb);
	}

	@Test
	public void update() {
		Pilot pilot = new Pilot();

		pilot.setName("Louis");
		
		Pilot pilotDb = pilotService.update(1, pilot);
		
		assertEquals(pilotDb.getName(), pilot.getName());
	}

	@Test
	public void list() {
		assertTrue(pilotService.list().size() > 0);
	}
	
	@Test
	public void find() {
		assertNotNull(pilotService.find(1));
	}

	@Test
	public void remove() {
		pilotService.remove(1);
		
		assertNull(pilotRepository.findById(1));
	}
	
}
