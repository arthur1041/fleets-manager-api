package br.com.artcruz.codeminerchallenge.domain.repository;

import java.util.List;

/**
 * @author: Arthur Cruz
 */
public interface GenericRepository<T> {

	List<T> list();
	T findById(int id);
	T createOrUpdate(T object);
	void delete(int id);
	
}
