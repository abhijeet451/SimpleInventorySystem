package com.inventory.system.expections;

public class ProductIdRequiredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductIdRequiredException(String msg) {
		super(msg);
	}
	
	public ProductIdRequiredException() {
		super();
	}
}
