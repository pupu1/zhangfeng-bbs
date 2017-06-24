package com.cn.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.bbs.model.BbsReply;
import com.cn.bbs.model.BbsTopic;

public interface BbsReplyMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(BbsReply record);

    int insertSelective(BbsReply record);

    BbsReply selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(BbsReply record);

    int updateByPrimaryKeyWithBLOBs(BbsReply record);

    int updateByPrimaryKey(BbsReply record);
    
    List<BbsReply> selectByPage(@Param(value="start")Integer start, @Param(value="limit")Integer limit, @Param(value="topicId")Long topicId);

	Integer selectByPageCount(@Param(value="topicId")Long topicId);
}