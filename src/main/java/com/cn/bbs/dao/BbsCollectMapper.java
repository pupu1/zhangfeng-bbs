package com.cn.bbs.dao;

import org.apache.ibatis.annotations.Param;

import com.cn.bbs.model.BbsCollect;

public interface BbsCollectMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(BbsCollect record);

    int insertSelective(BbsCollect record);

    BbsCollect selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(BbsCollect record);

    int updateByPrimaryKey(BbsCollect record);

	Integer selectByTopicUuidCount(Long topicUuid);

	BbsCollect selectByTopicUuidAndUserUuid(@Param("topicUuid")Long topicUuid,@Param("userUuid") Long userUuid);

	void deleteByTopicUuidAndUserUuid(@Param("topicUuid")Long topicUuid,@Param("userUuid") Long userUuid);
}