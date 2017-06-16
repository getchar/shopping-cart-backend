package com.dlizarra.starter.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlizarra.starter.support.orika.OrikaBeanMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrikaBeanMapper mapper;

	@Transactional
	@Override
	public void createProduct(final ProductDto productDto) {
		final Product product = mapper.map(productDto, Product.class);
		productRepository.save(product);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductDto> getProducts() {
		final List<Product> products = productRepository.findAll(new Sort("id"));
		final List<ProductDto> productDtos = new ArrayList<ProductDto>();
		products.forEach(x -> productDtos.add(mapper.map(x, ProductDto.class)));
		return productDtos;
	}

	@Transactional(readOnly = true)
	@Override
	public ProductDto getProduct(final Integer id) {
		return mapper.map(find(id), ProductDto.class);
	}

	@Transactional
	@Override
	public void updateProduct(final ProductDto productDto) {
		deleteProduct(productDto.getId());
		createProduct(productDto);
	}

	@Transactional
	@Override
	public void deleteProduct(final Integer id) {
		productRepository.delete(id);
	}

	@Transactional(readOnly = true)
	private Product find(final Integer id) {
		final Optional<Product> productOpt = productRepository.findOne(id);
		return productOpt.orElseThrow(() -> new ProductNotFoundException(id));
	}

	@Override
	public Product getProduct(ProductDto productDto) {
		return mapper.map(productDto, Product.class);
	}

}
