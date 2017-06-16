package com.dlizarra.starter.product;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dlizarra.starter.support.jpa.CustomJpaRepository;

@Repository
public interface ProductRepository extends CustomJpaRepository<Product, Integer> {
	Optional<Product> findByName(String name);
}
