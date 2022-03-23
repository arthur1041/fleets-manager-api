package br.com.artcruz.codeminerchallenge.domain.service;

import java.util.List;

public interface Service<T> {

	public T save(T obj);
	
	public T update(int id, T obj);

	public T find(int id);
	
	public List<T> list();
	
	public void remove(int id);

}
