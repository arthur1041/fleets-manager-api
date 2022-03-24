package br.com.artcruz.codeminerchallenge.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import br.com.artcruz.codeminerchallenge.domain.model.entity.Ship;
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;

/**
 * @author: Arthur Cruz
 */
@Component
public class ShipRepositoryImpl implements IRepository<Ship> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Ship> list() {
		return entityManager.createQuery("from Ship", Ship.class).getResultList();
	}

	@Override
	public Ship findById(int id) {
		return entityManager.find(Ship.class, id);
	}

	@Override
	@Transactional
	public Ship createOrUpdate(Ship ship) {
		return entityManager.merge(ship);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Ship ship = findById(id);
		if(ship == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		entityManager.remove(ship);
	}

}
