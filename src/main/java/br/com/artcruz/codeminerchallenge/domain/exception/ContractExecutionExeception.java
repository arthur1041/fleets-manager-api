package br.com.artcruz.codeminerchallenge.domain.exception;

/**
 * @author: Arthur Cruz
 */
public class ContractExecutionExeception extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ContractExecutionExeception() {
		super("There was problem executing the contract");
	}
	
	public ContractExecutionExeception(String message) {
		super(message);
	}
	
}
