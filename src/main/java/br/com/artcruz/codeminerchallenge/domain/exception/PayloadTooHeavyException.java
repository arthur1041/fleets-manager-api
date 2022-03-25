package br.com.artcruz.codeminerchallenge.domain.exception;

/**
 * @author: Arthur Cruz
 */
public class PayloadTooHeavyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PayloadTooHeavyException() {
		super("No ships with the required weight capacity available");
	}
	
}
