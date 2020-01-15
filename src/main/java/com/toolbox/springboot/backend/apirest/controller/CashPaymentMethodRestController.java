package com.toolbox.springboot.backend.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolbox.springboot.backend.apirest.model.entity.CashPaymentMethod;
import com.toolbox.springboot.backend.apirest.services.CashPaymentMethodService;

@CrossOrigin(origins = {"http://localhost:3306"})
@RestController
@RequestMapping("/profile/{id}")
public class CashPaymentMethodRestController {

	@Autowired
	private CashPaymentMethodService cashservice;
	
	@PostMapping("/profile/{id}")
	public CashPaymentMethod create(@RequestBody CashPaymentMethod method) {
		return cashservice.save(method);
	}
	
	@PostMapping("/profile/{id}")
	public void delete(@PathVariable Long id) {
		cashservice.delete(id);
	}
}
