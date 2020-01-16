package com.toolbox.springboot.backend.apirest.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.toolbox.springboot.backend.apirest.model.entity.UserGeneral;

public interface IUserGeneralServiceJonas {
	
public List<UserGeneral> showAll();
	
	public Page<UserGeneral> showAll(Pageable pageable);
	
	public UserGeneral Save(UserGeneral user);
	
	public void delete(Long id);
	
	public UserGeneral findById(Long id);
	
	public UserGeneral findByEmail(String email);

}
