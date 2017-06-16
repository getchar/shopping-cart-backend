package com.dlizarra.starter.controllertests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.dlizarra.starter.product.ProductController;
import com.dlizarra.starter.product.ProductDto;
import com.dlizarra.starter.product.ProductService;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@Transactional
public class ProductControllerTest {
	
	@Mock
	private ProductService productService;
	
	@InjectMocks
	private ProductController productController;
	
	@Mock
	private ProductDto prod1;
	@Mock
	private ProductDto prod2;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getProducts() {
		List<ProductDto> productDtos = new ArrayList<>();
		productDtos.add(prod1);
		productDtos.add(prod1);
		Mockito.when(productService.getProducts()).thenReturn(productDtos);
		assertEquals(2, productController.findAll().size());
	}

}
