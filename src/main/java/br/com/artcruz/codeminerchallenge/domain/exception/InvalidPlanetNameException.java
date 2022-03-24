package br.com.artcruz.codeminerchallenge.domain.exception;

/**
 * @author: Arthur Cruz
 */
public class InvalidPlanetNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidPlanetNameException() {
		super("Invalid planet name");
	}
	
}
