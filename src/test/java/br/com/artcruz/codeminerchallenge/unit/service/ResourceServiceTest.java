package br.com.artcruz.codeminerchallenge.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.artcruz.codeminerchallenge.domain.enums.ResourceEnum;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Contract;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Resource;
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;
import br.com.artcruz.codeminerchallenge.domain.service.IService;

/**
 * @author: Arthur Cruz
 */
@SpringBootTest
class ResourceServiceTest {

	@Autowired
	private IService<Resource> resourceService;
	
	@Autowired
	private IService<Contract> contractService;
	
	@Autowired
	private IRepository<Resource> resourceRepository;

	@Test
	public void save() {
		Resource resource = new Resource();

		resource.setName(ResourceEnum.MINERALS.label);
		resource.setWeight(100);
		resource.setContract(contractService.find(1));
		
		Resource resourceDb = resourceService.save(resource);
		
		assertNotNull(resourceDb);
	}

	@Test
	public void update() {
		Resource resource = new Resource();

		resource.setName(ResourceEnum.FOOD.label);
		
		Resource resourceDb = resourceService.update(1, resource);
		
		assertEquals(resourceDb.getName(), resource.getName());
	}

	@Test
	public void list() {
		assertTrue(resourceService.list().size() > 0);
	}
	
	@Test
	public void find() {
		assertNotNull(resourceService.find(1));
	}

	@Test
	public void remove() {
		resourceService.remove(1);
		
		assertNull(resourceRepository.findById(1));
	}
	
}
