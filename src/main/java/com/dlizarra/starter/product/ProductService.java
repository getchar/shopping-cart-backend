package com.dlizarra.starter.product;

import java.util.List;

public interface ProductService {
	void createProduct(ProductDto Product);
	void updateProduct(ProductDto Product);
	void deleteProduct(Integer id);
	Product getProduct(ProductDto productDto);
	ProductDto getProduct(Integer id);
	List<ProductDto> getProducts();
}
