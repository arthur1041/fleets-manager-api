package br.com.artcruz.codeminerchallenge.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import br.com.artcruz.codeminerchallenge.domain.model.entity.Resource;
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;

/**
 * @author: Arthur Cruz
 */
@Component
public class ResourceRepositoryImpl implements IRepository<Resource> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Resource> list() {
		return entityManager.createQuery("from Resource", Resource.class).getResultList();
	}

	@Override
	public Resource findById(int id) {
		return entityManager.find(Resource.class, id);
	}

	@Override
	@Transactional
	public Resource createOrUpdate(Resource resource) {
		return entityManager.merge(resource);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Resource resource = findById(id);
		if(resource == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		entityManager.remove(resource);
	}

}
