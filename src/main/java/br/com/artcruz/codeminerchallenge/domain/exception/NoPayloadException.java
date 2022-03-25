package br.com.artcruz.codeminerchallenge.domain.exception;

/**
 * @author: Arthur Cruz
 */
public class NoPayloadException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoPayloadException() {
		super("No payload to be carried");
	}
	
}
