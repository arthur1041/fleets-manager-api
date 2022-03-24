package br.com.artcruz.codeminerchallenge.domain.exception;

public class ContractNotAcceptedExeception extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ContractNotAcceptedExeception() {
		super("Cannot start travel because the contract is not accepted yet");
	}
	
}
