package com.dlizarra.starter.product;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.CustomMapper;

@Component
public class ProductDtoMapper extends CustomMapper<Product, ProductDto> {

}
