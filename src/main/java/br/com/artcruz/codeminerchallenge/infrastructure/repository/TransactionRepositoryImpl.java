package br.com.artcruz.codeminerchallenge.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import br.com.artcruz.codeminerchallenge.domain.model.entity.Transaction;
import br.com.artcruz.codeminerchallenge.domain.repository.IRepository;

/**
 * @author: Arthur Cruz
 */
@Component
public class TransactionRepositoryImpl implements IRepository<Transaction> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Transaction> list() {
		return entityManager.createQuery("from Transaction", Transaction.class).getResultList();
	}

	@Override
	public Transaction findById(Integer id) {
		return entityManager.find(Transaction.class, id);
	}

	@Override
	@Transactional
	public Transaction createOrUpdate(Transaction object) {
		return entityManager.merge(object);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Transaction transaction = findById(id);
		if(transaction == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		entityManager.remove(transaction);		
	}

}
