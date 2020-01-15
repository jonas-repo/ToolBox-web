package com.toolbox.springboot.backend.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolbox.springboot.backend.apirest.model.entity.UserGeneral;
import com.toolbox.springboot.backend.apirest.services.IUserGeneralServiceJonas;

@RestController
@RequestMapping("/users-login")
public class UserGeneralJonasController {
	
	@Autowired
	private IUserGeneralServiceJonas iUserService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@GetMapping("/allusers")
	public List<UserGeneral> getAllUsers()
	{
		return iUserService.showAll();
	}
	
	@PostMapping("/userregister")
	public ResponseEntity<?> create(@Valid @RequestBody UserGeneral user, BindingResult result) // json body request
	{
		// Objects Creation
		UserGeneral userNew = null;
		Map<String, Object> response = new HashMap<>(); // we use map to send the error messages instead of the object

		// Process validation if the object has the correct values, binding result is
		// from the @valid that validate the entity model
		if (result.hasErrors()) {
			/*
			 * List<String> errors = new ArrayList<String>(); for(FieldError err :
			 * result.getFieldErrors()) { errors.add("El campo '"+err.getField() +"' "+
			 * err.getDefaultMessage()); }
			 */
			// new JDK 8 way to get the error messages
			List<String> errors = result.getFieldErrors().stream()
					.map(err ->  err.getDefaultMessage()) // for each error put
																								// that message
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		// Process validation connection
		try {
			user.setUserpassword(passwordEncoder.encode(user.getUserpassword()));
			userNew = iUserService.Save(user);

		} catch (DataAccessException e) {
			response.put("Mensaje", "Error please verify your data");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// response to the front end
		response.put("Mensaje", "Usuario creado con exito");
		response.put("User", userNew); // with the map of hash map we send a response with more specifications to
												// the front end
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	

}
