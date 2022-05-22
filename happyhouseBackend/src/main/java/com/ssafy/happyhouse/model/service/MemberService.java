package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.User;

public interface MemberService {
	User login(User user) throws Exception;
	User userInfo(String userid) throws Exception;
	int idCheck(String checkId) throws Exception;
	boolean registerMember(User user) throws Exception;
	
	List<User> listMember() throws Exception;
	User getMember(String userId) throws Exception;
	void updateMember(User user) throws Exception;
	void deleteMember(String userId) throws Exception;
}
