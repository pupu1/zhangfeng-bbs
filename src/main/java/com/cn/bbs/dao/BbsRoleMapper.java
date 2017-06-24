package com.cn.bbs.dao;

import java.util.List;

import com.cn.bbs.model.BbsRole;

public interface BbsRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BbsRole record);

    int insertSelective(BbsRole record);

    BbsRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BbsRole record);

    int updateByPrimaryKey(BbsRole record);

	List<BbsRole> getAll();
}