package com.inventory.system.expections;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String msg) {
		super(msg);
	}
	
	public ProductNotFoundException() {
		super();
	}


}
