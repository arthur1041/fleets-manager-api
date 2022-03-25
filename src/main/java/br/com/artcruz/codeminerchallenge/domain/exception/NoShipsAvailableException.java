package br.com.artcruz.codeminerchallenge.domain.exception;

/**
 * @author: Arthur Cruz
 */
public class NoShipsAvailableException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoShipsAvailableException() {
		super("The pilot doesn't have any ships");
	}
}
