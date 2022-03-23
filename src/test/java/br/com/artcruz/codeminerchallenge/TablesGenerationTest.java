package br.com.artcruz.codeminerchallenge;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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

		try {
			pilot.setAge(sdf.parse("29/06/2002"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pilot.setCredits(1000000);
		pilot.setLocationPlanet("Mars");
		pilot.setName("Peter Parker");
		pilot.setPilotCertification("0000000");

		entityManager.persist(pilot);
	}

}
