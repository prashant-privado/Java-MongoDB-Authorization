package com.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.auth.model.AuthResponse;
import com.auth.model.UserData;
import com.auth.service.CustomerDetailsServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
//@CrossOrigin(origins="http://localhost:3000")
public class AuthController {

	@Autowired
	private CustomerDetailsServiceImpl customerDetailsService;

	/**
	 * Checks login credentials by calling the login method in service class
	 * 
	 * @param userlogincredentials - User ID,Password
	 * @return token that is generated for given user ID
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserData login(@RequestBody UserData userlogincredentials) {
		return customerDetailsService.login(userlogincredentials);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public UserData add(@RequestBody UserData userdata) {
		return customerDetailsService.add(userdata);
	}

	/**
	 * Sets token validity by calling the getValidity method in service class
	 * 
	 * @param token JWT token to validate user
	 * @return User ID, Token Validity, User name for given User ID
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public AuthResponse getValidity(@RequestHeader("Authorization") final String token) {
		return customerDetailsService.getValidity(token);
	}
	
	@RequestMapping(value = "/temp", method = RequestMethod.GET)
	public UserData temp() {
		return customerDetailsService.temp();
	}

}
