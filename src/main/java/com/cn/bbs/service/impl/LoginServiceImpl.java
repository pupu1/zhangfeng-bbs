package com.cn.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bbs.dao.BbsUserMapper;
import com.cn.bbs.model.BbsUser;
import com.cn.bbs.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private BbsUserMapper bbsUserMapper;
	public BbsUser selectByUserName(String username) {
		return bbsUserMapper.selectByUserName(username);
	}
	@Override
	public void insert(BbsUser user) {
		bbsUserMapper.insertSelective(user);
		
	}
	
}
