package br.com.artcruz.codeminerchallenge.domain.exception;

public class InvalidResourceNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidResourceNameException() {
		super("Invalid resource name"); 
	}
}
