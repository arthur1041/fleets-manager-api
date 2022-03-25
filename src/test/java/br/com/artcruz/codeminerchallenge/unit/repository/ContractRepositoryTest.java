package br.com.artcruz.codeminerchallenge.unit.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.artcruz.codeminerchallenge.domain.enums.PlanetEnum;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Contract;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Pilot;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Resource;
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;
import br.com.artcruz.codeminerchallenge.infrastructure.repository.ContractRepositoryImpl;

/**
 * @author: Arthur Cruz
 */
@SpringBootTest
class ContractRepositoryTest {

	@Autowired
	private IRepository<Contract> contractRepository;
	
	@Autowired
	private IRepository<Pilot> pilotRepository;

	@Autowired
	private IRepository<Resource> resourceRepository;

	@Test
	public void list() {
		assertTrue(contractRepository.list().size() > 0);
	}

	@Test
	public void listNotAccomplishedContracts() {
		assertTrue(((ContractRepositoryImpl) contractRepository).listNotAccomplishedContracts().size() > 0);
	}
	
	@Test
	public void create() {
		Contract contract = new Contract();

		contract.setPilot(pilotRepository.findById(2));
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
		
		contract.setPilot(pilotRepository.findById(2));
		
		contractRepository.createOrUpdate(contract);
		
		assertEquals(contractRepository.findById(1).getPilot().getId(), pilotRepository.findById(2).getId());
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
