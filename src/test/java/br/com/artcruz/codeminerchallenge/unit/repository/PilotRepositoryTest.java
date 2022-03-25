package br.com.artcruz.codeminerchallenge.unit.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.artcruz.codeminerchallenge.domain.model.entity.Pilot;
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;

/**
 * @author: Arthur Cruz
 */
@SpringBootTest
class PilotRepositoryTest {

	@Autowired
	private IRepository<Pilot> pilotRepository;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void list() {
		assertTrue(pilotRepository.list().size() > 0);
	}

	@Test
	public void create() {
		Pilot pilot = new Pilot();

		pilot.setBirthDate(LocalDate.now());

		pilot.setCredits(1000000);
		pilot.setLocationPlanet("Mars");
		pilot.setName("Peter Parker");
		pilot.setPilotCertification("0000000");

		Pilot pilotDb = pilotRepository.createOrUpdate(pilot);

		assertNotNull(pilotDb);

	}

	@Test
	public void update() {
		Pilot pilot = pilotRepository.findById(1);
		
		pilot.setName("Mark");
		
		pilotRepository.createOrUpdate(pilot);
		
		assertEquals(pilotRepository.findById(1).getName(), "Mark");
	}
	
	@Test
	public void findById() {
		assertNotNull(pilotRepository.findById(1));
	}
	
	@Test
	public void delete() {
		pilotRepository.delete(1);
		assertNull(pilotRepository.findById(1));
	}
}
