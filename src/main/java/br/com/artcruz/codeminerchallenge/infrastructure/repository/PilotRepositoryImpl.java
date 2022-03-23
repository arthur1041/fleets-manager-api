package br.com.artcruz.codeminerchallenge.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import br.com.artcruz.codeminerchallenge.domain.model.entity.Pilot;
import br.com.artcruz.codeminerchallenge.domain.repository.GenericRepository;

/**
 * @author: Arthur Cruz
 */
@Component
public class PilotRepositoryImpl implements GenericRepository<Pilot> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Pilot> list() {
		return entityManager.createQuery("from Pilot", Pilot.class).getResultList();
	}

	@Override
	public Pilot findById(int id) {
		return entityManager.find(Pilot.class, id);
	}

	@Override
	@Transactional
	public Pilot createOrUpdate(Pilot pilot) {
		return entityManager.merge(pilot);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Pilot pilot = findById(id);
		if(pilot == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		entityManager.remove(pilot);
	}

}
