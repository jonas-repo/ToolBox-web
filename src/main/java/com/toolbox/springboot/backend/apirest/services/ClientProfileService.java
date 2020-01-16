package com.toolbox.springboot.backend.apirest.services;

import com.toolbox.springboot.backend.apirest.model.entity.UserGeneral;

public interface ClientProfileService {

	public UserGeneral findById(Long id);
	
	public UserGeneral save(UserGeneral user);
	
	public void delete(Long id);
}
