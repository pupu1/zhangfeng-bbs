package com.cn.bbs.service;

import java.util.List;

import com.cn.bbs.dto.pageData;
import com.cn.bbs.model.BbsRole;
import com.cn.bbs.model.BbsUser;

public interface  PermissionService {

	public pageData<BbsUser> selectUserByPage(Integer pageSize, Integer pageNum);

	public BbsUser selectUserByUuid(Long uuid);

	public List<BbsRole> getAllRole();

	public void updateUser(BbsUser perUser);

}
