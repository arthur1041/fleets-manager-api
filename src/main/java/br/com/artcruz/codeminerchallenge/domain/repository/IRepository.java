package br.com.artcruz.codeminerchallenge.domain.repository;

import java.util.List;

/**
 * @author: Arthur Cruz
 */
public interface IRepository<T> {

	List<T> list();
	T findById(Integer id);
	T createOrUpdate(T object);
	void delete(Integer id);
	
}
