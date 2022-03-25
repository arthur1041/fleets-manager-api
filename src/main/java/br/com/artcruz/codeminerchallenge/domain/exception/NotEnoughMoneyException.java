package br.com.artcruz.codeminerchallenge.domain.exception;

public class NotEnoughMoneyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotEnoughMoneyException() {
		super("Pilot doesn't have enough money");
	}
	
}
