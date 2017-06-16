package com.dlizarra.starter.product;

public class ProductNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -6614752524844098781L;

	public ProductNotFoundException(final Integer id) {
		super("Could not find Product with id: " + id);
	}
}
