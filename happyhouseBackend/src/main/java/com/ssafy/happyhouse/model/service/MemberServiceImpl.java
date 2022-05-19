package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public User login(Map<String, String> map) throws Exception {
		return memberMapper.login(map);
	}

	@Override
	public int idCheck(String checkId) throws Exception {
		return memberMapper.idCheck(checkId);
	}

	@Override
	public void registerMember(User user) throws Exception {
		memberMapper.registerMember(user);
	}

	@Override
	public List<User> listMember() throws Exception {
		return memberMapper.listMember();
	}

	@Override
	public User getMember(String userId) throws Exception {
		return memberMapper.getMember(userId);
	}

	@Override
	public void updateMember(User user) throws Exception {
		memberMapper.updateMember(user);
	}

	@Override
	public void deleteMember(String userId) throws Exception {
		memberMapper.deleteMember(userId);
	}
	
}
