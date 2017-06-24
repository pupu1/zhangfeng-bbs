package com.cn.bbs.dao;

import com.cn.bbs.model.BbsPermission;

public interface BbsPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BbsPermission record);

    int insertSelective(BbsPermission record);

    BbsPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BbsPermission record);

    int updateByPrimaryKey(BbsPermission record);
}