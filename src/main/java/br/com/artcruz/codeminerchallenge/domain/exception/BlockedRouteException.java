package br.com.artcruz.codeminerchallenge.domain.exception;

public class BlockedRouteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BlockedRouteException() {
		super("Route is blocked");
	}
	
}
