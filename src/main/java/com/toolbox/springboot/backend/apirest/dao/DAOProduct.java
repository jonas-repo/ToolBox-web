package com.toolbox.springboot.backend.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolbox.springboot.backend.apirest.model.entity.Product;

public interface DAOProduct extends JpaRepository<Product, Long>{

}
