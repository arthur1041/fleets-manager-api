package br.com.artcruz.codeminerchallenge.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.artcruz.codeminerchallenge.domain.enums.ResourceEnum;
import br.com.artcruz.codeminerchallenge.domain.model.entity.Resource;
import br.com.artcruz.codeminerchallenge.domain.repository.Repository;

/**
 * @author: Arthur Cruz
 */
@SpringBootTest
class ResourceRepositoryTest {

	@Autowired
	private Repository<Resource> resourceRepository;

	@Test
	public void list() {
		assertTrue(resourceRepository.list().size() > 0);
	}

	@Test
	public void create() {
		Resource resource = new Resource();

		
		resource.setName(ResourceEnum.MINERALS.label);
		resource.setWeight(100);

		Resource resourceDb = resourceRepository.createOrUpdate(resource);

		assertNotNull(resourceDb);

	}

	@Test
	public void update() {
		Resource resource = resourceRepository.findById(1);
		
		resource.setName(ResourceEnum.FOOD.label);
		
		resourceRepository.createOrUpdate(resource);
		
		assertEquals(resourceRepository.findById(1).getName(), ResourceEnum.FOOD.label);
	}
	
	@Test
	public void findById() {
		assertNotNull(resourceRepository.findById(1));
	}
	
	@Test
	public void delete() {
		resourceRepository.delete(1);
		assertNull(resourceRepository.findById(1));
	}
}
