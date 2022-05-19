package com.ssafy.happyhouse.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.service.MemberService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.ssafy.happyhouse.controller.MemberController;

@Controller
@RequestMapping("/user")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session,
			HttpServletResponse response) throws Exception {
		User user = memberService.login(map);
		
		if(user != null) {
			session.setAttribute("user", user);
			return "redirect:/";
		} else {
			model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
			return "user/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/signup")
	public String register() {
		return "user/signup";
	}
	
	@PostMapping("/signup")
	public String register(User user, Model model) throws Exception {
		memberService.registerMember(user);
		return "redirect:/user/login";
	}
	
	@GetMapping("/userinfo/{userid}")
	public String userInfo(@PathVariable("userid") String userid, Model model, HttpSession session) throws Exception {
		User user = memberService.getMember(userid);
		
		if(user != null) {
			session.setAttribute("userinfo", user);
			return "user/userInfo";
		} else {
			model.addAttribute("msg", "회원 정보가 존재하지 않습니다!");
			return "/";
		}
		
	}
	
	@GetMapping("/modify")
	public String userModify() {
		return "user/modify";
	}
	
	@PostMapping("/mod")
	public String Modify(User user, HttpSession session) throws Exception {
		memberService.updateMember(user);
		session.removeAttribute("userinfo");
		session.setAttribute("userinfo", user);
		String id = user.getUserId();
		
		String address = "user/userinfo/" + id;
		return "redirect:/";
	}
	
	@PostMapping("/delete")
	public String userDelete(User user, HttpSession session) throws Exception {
		String userId = user.getUserId();
		System.out.println("why");
		memberService.deleteMember(userId);
		session.invalidate();
		return "redirect:/";
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
