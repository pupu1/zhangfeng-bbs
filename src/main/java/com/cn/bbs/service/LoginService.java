package com.cn.bbs.service;

import com.cn.bbs.model.BbsUser;

public interface LoginService {
	public BbsUser selectByUserName(String username);

	public void insert(BbsUser user);
}
