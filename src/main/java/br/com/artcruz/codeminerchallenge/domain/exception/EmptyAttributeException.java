package br.com.artcruz.codeminerchallenge.domain.exception;

/**
 * @author: Arthur Cruz
 */
public class EmptyAttributeException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EmptyAttributeException(String attr) {
		super("Attribute " + attr + " can't be empty.");
	}
	
}
