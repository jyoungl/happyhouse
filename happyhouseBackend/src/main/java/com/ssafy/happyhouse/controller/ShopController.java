package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.Commercial;
import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.happyhouse.model.dto.SidoGugunCode;
import com.ssafy.happyhouse.model.service.AptService;


@Controller
@RequestMapping("/shop")
@CrossOrigin("*")
public class ShopController {

	private final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Autowired
	private AptService aptService;
	
//	@GetMapping(value = "/search")
//	public 
	
	@GetMapping(value="/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/sido")
	@ResponseBody
	public ResponseEntity<List<SidoGugunCode>> sido() throws Exception {
		logger.debug("sido : {}", aptService.getSido());
		return new ResponseEntity<List<SidoGugunCode>>(aptService.getSido(), HttpStatus.OK);
	}
	
	@GetMapping("/gugun")
	@ResponseBody
	public ResponseEntity<List<SidoGugunCode>> gugun(@RequestParam("sido") String sido) throws Exception {
		return new ResponseEntity<List<SidoGugunCode>>(aptService.getGugunInSido(sido), HttpStatus.OK);
	}
	
	@GetMapping("/dong")
	@ResponseBody
	public ResponseEntity<List<Commercial>> dong(@RequestParam("gugun") String gugun) throws Exception {
		return new ResponseEntity<List<Commercial>>(aptService.getDongInGugunByShop(gugun), HttpStatus.OK);
	}
	
	@GetMapping("/comm")
	@ResponseBody
	public ResponseEntity<List<Commercial>> comm(@RequestParam("dong") String dong) throws Exception {
		return new ResponseEntity<List<Commercial>>(aptService.getShopInDong(dong), HttpStatus.OK);
	}
	
	@GetMapping("/comapt")
	@ResponseBody
	public ResponseEntity<List<HouseInfo>> compat(@RequestParam("dong") String dong) throws Exception {
		return new ResponseEntity<List<HouseInfo>>(aptService.getAptInDong(dong), HttpStatus.OK);
	}
	
	@GetMapping(value="/shop")
	public String shop() {
		return "shop";
	}
}
