package br.com.artcruz.codeminerchallenge.helper;

import java.io.Serializable;

public class RefuelBodyHelper implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer value;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "RefuelBodyHelper [value=" + value + "]";
	}

}
