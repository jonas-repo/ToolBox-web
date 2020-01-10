package com.toolbox.springboot.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.toolbox.springboot.backend.apirest.dao.DAOProductImage;
import com.toolbox.springboot.backend.apirest.model.entity.Product;
import com.toolbox.springboot.backend.apirest.model.entity.ProductImage;

@Service
public class ProductImageServiceImpl implements ProductImageService {
	@Autowired
	private DAOProductImage daoProductImage;

	@Override
	@Transactional
	public ProductImage save(ProductImage productImage) {
		return daoProductImage.save(productImage);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductImage> findAllProductImages(Long id) {
		return daoProductImage.findAllProductImages(id);
	}

	@Override
	public void delete(Long id) {
		daoProductImage.deleteById(id);
	}

	@Override
	public void deleteAllById(Product product) {
		daoProductImage.deleteAllById(product);
	}

	@Override
	public List<ProductImage> saveAll(List<ProductImage> productImages) {
		return daoProductImage.saveAll(productImages);
	}

	@Override
	@Transactional(readOnly = true)
	public ProductImage findById(Long id) {
		return daoProductImage.findById(id).orElse(null);
	}

	@Override
	public ProductImage findByProductImageName(String imageRoute) {
		return daoProductImage.findByProductImageName(imageRoute);
	}
}
