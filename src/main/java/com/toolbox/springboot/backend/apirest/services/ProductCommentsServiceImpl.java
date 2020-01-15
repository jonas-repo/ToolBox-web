package com.toolbox.springboot.backend.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolbox.springboot.backend.apirest.dao.DAOProductComments;
import com.toolbox.springboot.backend.apirest.model.entity.ProductComments;

@Service
public class ProductCommentsServiceImpl implements ProductCommentsService {

	@Autowired
	private DAOProductComments daoProductComments;
	
	@Override
	public ProductComments save(ProductComments productComments) {
		return daoProductComments.save(productComments);
	}
	
}
