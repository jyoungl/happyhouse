package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping({"/","/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/shop")
	public String shop() {
		return "shop";
	}
}
