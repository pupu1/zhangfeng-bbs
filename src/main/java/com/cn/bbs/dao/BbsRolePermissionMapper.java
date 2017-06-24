package com.cn.bbs.dao;

import com.cn.bbs.model.BbsRolePermission;

public interface BbsRolePermissionMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(BbsRolePermission record);

    int insertSelective(BbsRolePermission record);

    BbsRolePermission selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(BbsRolePermission record);

    int updateByPrimaryKey(BbsRolePermission record);
}