package br.com.artcruz.codeminerchallenge.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import br.com.artcruz.codeminerchallenge.domain.model.entity.Contract;
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;

/**
 * @author: Arthur Cruz
 */
@Component
public class ContractRepositoryImpl implements IRepository<Contract> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Contract> list() {
		return entityManager.createQuery("from Contract", Contract.class).getResultList();
	}

	@Override
	public Contract findById(Integer id) {
		return entityManager.find(Contract.class, id);
	}

	@Override
	@Transactional
	public Contract createOrUpdate(Contract contract) {
		return entityManager.merge(contract);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Contract contract = findById(id);
		if(contract == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		entityManager.remove(contract);
	}

	@SuppressWarnings("unchecked")
	public List<Contract> listNotAccomplishedContracts() {
		Query q = entityManager.createQuery("from Contract c where c.accomplished is false", Contract.class);
		
		
		return (List<Contract>) q.getResultList();
	}
	
	
}
