package com.toolbox.springboot.backend.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.toolbox.springboot.backend.apirest.dao.DAOClientProfile;
import com.toolbox.springboot.backend.apirest.model.entity.UserGeneral;


public class ClientProfileServiceImpl implements ClientProfileService {

	@Autowired
	private DAOClientProfile daoclientprofile;
	
	@Override
	@Transactional(readOnly = true)
	public UserGeneral findById(Long id) {
		
		return daoclientprofile.findById(id).orElseGet(null);
	}

	@Override
	@Transactional
	public UserGeneral save(UserGeneral user) {
		return daoclientprofile.save(user);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		daoclientprofile.deleteById(id);
		
	}

}
