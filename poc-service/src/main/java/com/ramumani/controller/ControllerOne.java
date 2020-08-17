package com.ramumani.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerOne {

	@GetMapping(path = "/greeting")
	public String greeting() {
		return "From POC service - ControllerOne";
	}
}
