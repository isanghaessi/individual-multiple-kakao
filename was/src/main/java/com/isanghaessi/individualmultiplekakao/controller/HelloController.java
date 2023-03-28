package com.isanghaessi.individualmultiplekakao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isanghaessi.individualmultiplekakao.service.HelloService;

@RestController
@RequestMapping("/api")
public class HelloController {
  private final HelloService helloService;

  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

	@GetMapping("hello")
	public String hello() {
		return helloService.hello();
	}
}
