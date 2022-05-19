package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.User;

@Mapper
public interface MemberMapper {
	User login(Map<String, String> map) throws Exception;
	
	int idCheck(String checkId) throws Exception;
	void registerMember(User user) throws Exception;
	
	List<User> listMember() throws Exception;
	User getMember(String userId) throws Exception;
	void updateMember(User user) throws Exception;
	void deleteMember(String userId) throws Exception;
}
