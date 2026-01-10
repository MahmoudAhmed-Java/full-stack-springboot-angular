package com.luv2code.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
