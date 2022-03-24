package br.com.artcruz.codeminerchallenge.domain.service;

import java.util.List;

/**
 * @author: Arthur Cruz
 */
public interface IService<T> {

	public T save(T obj);
	
	public T update(Integer id, T obj);

	public T find(Integer id);
	
	public List<T> list();
	
	public void remove(int id);

}
