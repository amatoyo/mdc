package com.boorge.mdc.welcome;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WelcomeController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}

	@GetMapping("/welcome-bean")
	public Welcome welcomeBean() {
		return new Welcome("Welcome Bean message");
	}

	@GetMapping("/welcome-bean/{username}")
	public Welcome welcomeWithPathVariable(@PathVariable String username) {
		//throw new RuntimeException("Some error has occured! Please contact administrator"); 
		return new Welcome(String.format("Welcome Bean message updated !!!, %s", username));
	}
}
