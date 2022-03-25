package br.com.artcruz.codeminerchallenge.unit;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.artcruz.codeminerchallenge.domain.model.entity.Pilot;

/**
 * @author: Arthur Cruz
 */
@SpringBootTest
class TablesGenerationTest {

	@PersistenceContext
	private EntityManager entityManager;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Test
	@Transactional
	public void testTablesCreation() {
		Pilot pilot = new Pilot();

		pilot.setBirthDate(LocalDate.now());
	
		pilot.setCredits(1000000);
		pilot.setLocationPlanet("Mars");
		pilot.setName("Peter Parker");
		pilot.setPilotCertification("0000000");

		entityManager.persist(pilot);
	}

}
