package com.toolbox.springboot.backend.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.toolbox.springboot.backend.apirest.model.entity.UserGeneral;
import com.toolbox.springboot.backend.apirest.services.ClientProfileService;

@CrossOrigin(origins = {"http://localhost:3306"})
@RestController
@RequestMapping("/profile")
public class ClientProfileRestController {
	
	@Autowired
	private ClientProfileService profileservice;
	
	@PostMapping("/profile")
	public UserGeneral create(@RequestBody UserGeneral user) {
		return profileservice.save(user);
	}
	
	@GetMapping("/profile/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public UserGeneral show(@PathVariable Long id) {
		return profileservice.findById(id);
	}
	
	@PutMapping("/profile/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public UserGeneral update(@RequestBody UserGeneral user, @PathVariable Long id) {
		UserGeneral client = profileservice.findById(id);
		
		client.setUseraddress(client.getUseraddress());
		client.setUseremail(client.getUseremail());
		client.setUserpicture(client.getUserpicture());
		return profileservice.save(client);
	}
	
}
