package br.com.artcruz.codeminerchallenge;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericController<T, R> {
	
	@Autowired
	protected R thisRepository;
	
	
	
}
