package br.com.artcruz.codeminerchallenge.domain.exception;

public class PilotTooYoungException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PilotTooYoungException() {
		super("The pilot is too young to fly.");
	}
	
}
