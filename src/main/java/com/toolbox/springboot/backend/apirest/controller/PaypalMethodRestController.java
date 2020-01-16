package com.toolbox.springboot.backend.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.toolbox.springboot.backend.apirest.model.entity.PaypalMethod;
import com.toolbox.springboot.backend.apirest.services.PaypalMethodService;

@CrossOrigin(origins = {"http://localhost:3306"})
@RestController
@RequestMapping("/profile")
public class PaypalMethodRestController {
	
	@Autowired
	private PaypalMethodService paypalservice;
	
	@PostMapping("/profile/paypal/create")
	@ResponseStatus(HttpStatus.CREATED)
	public PaypalMethod crate(@RequestBody PaypalMethod paypal) {
		return paypalservice.save(paypal);
	}
	
	@PostMapping("/profile/paypal/delete/{id}")
	public void delete(@RequestBody PaypalMethod paypal, @PathVariable Long id) {
		paypalservice.delete(id);
	}
}
