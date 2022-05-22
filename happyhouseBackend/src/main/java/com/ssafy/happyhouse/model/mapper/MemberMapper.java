package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.User;

@Mapper
public interface MemberMapper {
	User login(User user) throws Exception;
	User userInfo(String userid) throws SQLException;
	int idCheck(String checkId) throws Exception;
	boolean registerMember(User user) throws Exception;
	
	List<User> listMember() throws Exception;
	User getMember(String userId) throws Exception;
	int updateMember(User user) throws SQLException;
	boolean deleteMember(String userId) throws Exception;
}
