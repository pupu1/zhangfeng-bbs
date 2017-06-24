package com.cn.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.bbs.model.BbsTopic;

public interface BbsTopicMapper {
    
    int deleteByPrimaryKey(Long uuid);

	int insert(BbsTopic record);

	int insertSelective(BbsTopic record);

	BbsTopic selectByPrimaryKey(Long uuid);

	int updateByPrimaryKeySelective(BbsTopic record);

	int updateByPrimaryKeyWithBLOBs(BbsTopic record);

	int updateByPrimaryKey(BbsTopic record);

	List<BbsTopic> selectByTab(String tab);

	List<BbsTopic> selectByPage(@Param(value="start")Integer start, @Param(value="limit")Integer limit);

	Integer selectByPageCount();

	void deleteById(@Param("uuid")Integer uuid);

	void updateIsTop(@Param("uuid")Integer uuid,@Param("isTop")Boolean istop);

	void updateIsGood(@Param("uuid")Integer uuid,@Param("isGood")Boolean isgood);

	Integer selectByTabAndPageCount(@Param(value="tab")String tab);

	List<BbsTopic> selectByTabAndPage(@Param(value="tab")String tab, @Param(value="start")Integer start, @Param(value="limit")Integer limit);
}