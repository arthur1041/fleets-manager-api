package br.com.artcruz.codeminerchallenge.domain.exception;

public class PayloadTooHeavyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PayloadTooHeavyException() {
		super("No ships with the required weight capacity available");
	}
	
}
