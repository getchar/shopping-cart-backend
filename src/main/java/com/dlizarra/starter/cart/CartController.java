package com.dlizarra.starter.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dlizarra.starter.product.ProductDto;
import com.dlizarra.starter.product.ProductService;
import com.dlizarra.starter.product.Total;

@RestController
public class CartController {

	@Autowired
	private ProductService productService;
	
	private List<Purchase> purchases = new ArrayList<Purchase>();
		
	@RequestMapping(value = "/purchases/all", method = RequestMethod.GET) 
	public List<Purchase> getPurchases() {
		return purchases;
	}
	
	@RequestMapping(value = "/cart/buy/{productIdString}", method = RequestMethod.GET)
	public void buy(@PathVariable("productIdString") String productIdString) {
		ProductDto productDto = productService.getProduct(Integer.parseInt(productIdString));
		Purchase purchase = getPurchase(productDto.getId(), true);
		purchase.setQuantity(purchase.getQuantity() + 1);
	}
	
	@RequestMapping(value = "/cart/unbuy/{productIdString}", method = RequestMethod.GET)
	public void unbuy(@PathVariable("productIdString") String productIdString) {
		ProductDto productDto = productService.getProduct(Integer.parseInt(productIdString));
		Purchase purchase = getPurchase(productDto.getId(), false);
		if (purchase != null) {
			purchase.setQuantity(purchase.getQuantity() - 1);
		}
		if (purchase.getQuantity() == 0) {
			purchases.remove(purchase); 
		}
	}
	
	@RequestMapping(value = "/cart/total", method = RequestMethod.GET)
	public Total getTotal() {
		Total total = new Total();
		int totalCost = 0;
		for (Purchase purchase: purchases) {
			ProductDto productDto = productService.getProduct(purchase.getProductId());
			int quantity = purchase.getQuantity();
			total.addTotalItem(quantity, productDto.getName());
			if (productDto.getDealCount() > 0) {
				totalCost += (quantity / productDto.getDealCount()) * productDto.getDealPrice();
				quantity %= productDto.getDealCount();
			}
			totalCost += quantity * productDto.getPrice();
		}
		total.setCost(totalCost);
		return total;
	}
	
	private Purchase getPurchase(Integer productId, boolean create) {
		for (Purchase purchase: purchases) {
			if (purchase.getProductId() == productId) {
				return purchase;
			}
		}
		if (!create) {
			return null;
		}
		Purchase purchase = new Purchase(productId);
		purchases.add(purchase);
		return purchase;
	}
}
