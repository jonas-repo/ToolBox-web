package com.toolbox.springboot.backend.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.toolbox.springboot.backend.apirest.model.entity.UserGeneral;
import com.toolbox.springboot.backend.apirest.model.entity.UserPaymentMethods;
import com.toolbox.springboot.backend.apirest.services.UserPaymentMethodsService;

@CrossOrigin(origins="http//localhost:3306")
@RestController
@RequestMapping()
public class UserPaymentMethodRestController {

	@Autowired
	private UserPaymentMethodsService paymentmethodservice;
	
	@PostMapping("/profile/payment/create")
	@ResponseStatus(HttpStatus.CREATED)
	public UserPaymentMethods create(@RequestBody UserPaymentMethods method) {
		return paymentmethodservice.save(method);
	}
	
	@GetMapping("/profile/payment/delete/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public UserPaymentMethods show(@PathVariable Long id) {
		return paymentmethodservice.findById(id);
	}
	
	@PostMapping("/profile/{id}")
	public void delete(@RequestBody UserPaymentMethods method, @PathVariable Long id) {
		paymentmethodservice.delete(id);
	}
	
}
