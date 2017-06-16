package com.dlizarra.starter.controllertests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.dlizarra.starter.cart.CartController;
import com.dlizarra.starter.product.ProductDto;
import com.dlizarra.starter.product.ProductService;
import com.dlizarra.starter.product.Total;

public class CartControllerTest {
	
	@Mock
	private ProductService productService;
	
	@InjectMocks
	private CartController cartController;

	@Mock
	private ProductDto prod1;
	private int prod1Id = 1;
	private int prod1Price = 200;
	private int prod1DealCount = 2;
	private int prod1DealPrice = 300;

	@Mock
	private ProductDto prod2;
	private int prod2Id = 2;
	private int prod2Price = 500;
	private int prod2DealCount = 3;
	private int prod2DealPrice = 1200;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Mockito.when(prod1.getPrice()).thenReturn(prod1Price);
		Mockito.when(prod1.getId()).thenReturn(prod1Id);
		Mockito.when(prod1.getDealCount()).thenReturn(prod1DealCount);
		Mockito.when(prod1.getDealPrice()).thenReturn(prod1DealPrice);
		Mockito.when(productService.getProduct(prod1Id)).thenReturn(prod1);
		Mockito.when(prod2.getPrice()).thenReturn(prod2Price);
		Mockito.when(prod2.getId()).thenReturn(prod2Id);
		Mockito.when(prod2.getDealCount()).thenReturn(prod2DealCount);
		Mockito.when(prod2.getDealPrice()).thenReturn(prod2DealPrice);
		Mockito.when(productService.getProduct(prod2Id)).thenReturn(prod2);
		productService.createProduct(prod1);
		productService.createProduct(prod2);
	}

	@Test
	public void testGetTotalOneEach() {
		cartController.buy(prod1.getId().toString());
		cartController.buy(prod2.getId().toString());
		Total total = cartController.getTotal();
		assertEquals(prod1Price + prod2Price, total.getCost());
	}
	
	@Test
	public void testGetTotalThreeEach() {
		for (int i = 0; i < 3; ++i) {
			cartController.buy(prod1.getId().toString());
		}
		for (int i = 0; i < 4; ++i) {
			cartController.buy(prod2.getId().toString());
		}
		Total total = cartController.getTotal();
		assertEquals(prod1Price + prod1DealPrice + prod2Price + prod2DealPrice, total.getCost());
	}
	
	@Test
	public void testBuy2Unbuy1() {
		for (int i = 0; i < 2; ++i) {
			cartController.buy(prod1.getId().toString());
		}
		cartController.unbuy(prod1.getId().toString());
		Total total = cartController.getTotal();
		assertEquals(prod1Price, total.getCost());
	}

}
