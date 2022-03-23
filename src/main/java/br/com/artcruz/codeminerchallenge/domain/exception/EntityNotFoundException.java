package br.com.artcruz.codeminerchallenge.domain.exception;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException() {
		super("Enity not found");
	}

	public EntityNotFoundException(Class<?> _class, int id) {
		super("No " + _class.getSimpleName().toLowerCase() + " was found with id " + id);
	}
	
	public EntityNotFoundException(String message) {
		super(message);
	}
	
}
