package br.com.artcruz.codeminerchallenge.domain.exception;

/**
 * @author: Arthur Cruz
 */
public class NotEnoughFuelException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NotEnoughFuelException() {
		super("The pilot doesn't have any ship with enough fuel");
	}
	
}
