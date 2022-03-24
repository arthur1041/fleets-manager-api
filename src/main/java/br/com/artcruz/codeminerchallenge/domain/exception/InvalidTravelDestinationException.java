package br.com.artcruz.codeminerchallenge.domain.exception;

public class InvalidTravelDestinationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidTravelDestinationException() {
		super("Invalid travel destination(s).");
	}
	
}
