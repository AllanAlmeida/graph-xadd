package br.radixeng.exception;

public class GraphException extends Exception {
		
	private static final long serialVersionUID = 1L;

	public GraphException(String message) {
		super(message);
	}

	public GraphException(String message, Exception e) {
		super(message, e);
	}
}
