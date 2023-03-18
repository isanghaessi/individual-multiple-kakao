package com.isanghaessi.individualmultiplekakao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
	@Value("${spring.config.activate.on-profile}")
	String activeProfile;

	@GetMapping("hello")
	public String hello() {
		return String.format("hello-spring [%s]", activeProfile);
	}
}
