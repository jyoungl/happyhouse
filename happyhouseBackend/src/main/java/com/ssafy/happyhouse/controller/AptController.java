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

import com.ssafy.happyhouse.model.dto.HouseInfo;
import com.ssafy.happyhouse.model.dto.SidoGugunCode;
import com.ssafy.happyhouse.model.service.AptService;


@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class AptController {

	private final Logger logger = LoggerFactory.getLogger(AptController.class);
	
	@Autowired
	private AptService aptService;
	
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCode>> sido() throws Exception {
		logger.debug("sido : {}", aptService.getSido());
		return new ResponseEntity<List<SidoGugunCode>>(aptService.getSido(), HttpStatus.OK);
	}
	
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCode>> gugun(@RequestParam("sido") String sido) throws Exception {
		return new ResponseEntity<List<SidoGugunCode>>(aptService.getGugunInSido(sido), HttpStatus.OK);
	}
	
	@GetMapping("/dong")
	public ResponseEntity<List<HouseInfo>> dong(@RequestParam("gugun") String gugun) throws Exception {
		return new ResponseEntity<List<HouseInfo>>(aptService.getDongInGugun(gugun), HttpStatus.OK);
	}
	
	@GetMapping("/apt")
	public ResponseEntity<List<HouseInfo>> apt(@RequestParam("dong") String dong) throws Exception {
		return new ResponseEntity<List<HouseInfo>>(aptService.getAptInDong(dong), HttpStatus.OK);
	}
	
	@GetMapping("/aptByDate")
	public ResponseEntity<List<HouseInfo>> aptByDate(@RequestParam("dong") String dong, @RequestParam("year") String year, @RequestParam("month") String month) throws Exception {
		return new ResponseEntity<List<HouseInfo>>(aptService.getAptInDate(dong, year, month), HttpStatus.OK);
	}
	
}
