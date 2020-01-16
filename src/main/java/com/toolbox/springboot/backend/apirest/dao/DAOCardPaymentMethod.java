package com.toolbox.springboot.backend.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import com.toolbox.springboot.backend.apirest.model.entity.CardMethod;

public interface DAOCardPaymentMethod extends JpaRepository<CardMethod, Long>{
	//
	/*@Query("SELECT * FROM CardMethod WHERE ")
	public List<CardMethod> findByUserId(Long id);
	*/
	
		
	
}
