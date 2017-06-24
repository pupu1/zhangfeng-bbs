package com.cn.bbs.service;

import java.util.List;

import com.cn.bbs.dto.pageData;
import com.cn.bbs.model.BbsTopic;
import com.cn.bbs.model.BbsUser;

public interface TopicService {
	public Integer insert(BbsTopic bbsTopic);
	
	public List<BbsTopic> selectByTab(String tab);

	public pageData<BbsTopic> selectByTabAndPage(String tab, Integer pageSize, Integer pageNum);

	public BbsTopic selectByUuid(Long uuid);

	public void update(BbsTopic topic);

	public void deleteById(Integer uuid);

	public void updateIsTop(Integer uuid,Boolean istop);

	public void updateIsGood(Integer uuid, Boolean isgood);
}
