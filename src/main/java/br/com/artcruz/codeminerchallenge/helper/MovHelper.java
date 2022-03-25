package br.com.artcruz.codeminerchallenge.helper;

import java.io.Serializable;

public class MovHelper implements Serializable {

	private static final long serialVersionUID = 1L;

	public Integer food = 0;
	public Integer water = 0;
	public Integer minerals = 0;
	
	
	@Override
	public String toString() {
		return "MovHelper [food=" + food + ", water=" + water + ", minerals=" + minerals + "]";
	}
}
