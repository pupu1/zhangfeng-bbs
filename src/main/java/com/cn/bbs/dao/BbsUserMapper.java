package com.cn.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.bbs.model.BbsPermission;
import com.cn.bbs.model.BbsUser;

public interface BbsUserMapper {
    int deleteByPrimaryKey(Long uuid);

	int insert(BbsUser record);

	int insertSelective(BbsUser record);

	BbsUser selectByPrimaryKey(Long uuid);

	int updateByPrimaryKeySelective(BbsUser record);

	int updateByPrimaryKey(BbsUser record);
    
    BbsUser selectByUserName(String userName);

	java.util.List<BbsUser> getAllByPage(@Param("start")Integer start, @Param("limit")Integer pageSize);

	Integer getAllCountByPage(int i, Integer pageSize);
}