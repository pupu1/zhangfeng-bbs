package com.cn.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bbs.dao.BbsRoleMapper;
import com.cn.bbs.dao.BbsUserMapper;
import com.cn.bbs.dto.pageData;
import com.cn.bbs.model.BbsRole;
import com.cn.bbs.model.BbsUser;
import com.cn.bbs.service.PermissionService;
@Service
public class  PermissionServiceImpl implements  PermissionService {
	@Autowired
	private BbsUserMapper bbsUserMapper;
	@Autowired
	private BbsRoleMapper bbsRoleMapper;

	public pageData<BbsUser> selectUserByPage(Integer pageSize, Integer pageNum) {
		List<BbsUser> List= bbsUserMapper.getAllByPage((pageNum-1)*pageSize,pageSize);
		Integer totalRow=bbsUserMapper.getAllCountByPage((pageNum-1)*pageSize,pageSize);
		return new pageData<BbsUser>(List, pageNum, pageSize, totalRow);
	}

	public BbsUser selectUserByUuid(Long uuid) {
		return bbsUserMapper.selectByPrimaryKey(uuid);
	}

	public List<BbsRole> getAllRole() {
		return bbsRoleMapper.getAll();
	}

	public void updateUser(BbsUser perUser) {
		bbsUserMapper.updateByPrimaryKeySelective(perUser);
	}
}
 