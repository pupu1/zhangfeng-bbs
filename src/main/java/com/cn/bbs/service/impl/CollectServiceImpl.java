package com.cn.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bbs.dao.BbsCollectMapper;
import com.cn.bbs.model.BbsCollect;
import com.cn.bbs.service.CollectService;
@Service
public class CollectServiceImpl implements CollectService {

	@Autowired
	private BbsCollectMapper bbsCollectMapper;

	public Integer selectByTopicUuidCount(Long topicUuid) {
		return bbsCollectMapper.selectByTopicUuidCount(topicUuid);
	}

	public BbsCollect selectByTopicUuidAndUserUuid(Long topicUuid, Long userUuid) {
		return bbsCollectMapper.selectByTopicUuidAndUserUuid(topicUuid,userUuid);
	}

	public void insert(BbsCollect collect) {
		 bbsCollectMapper.insertSelective(collect);
		
	}

	public void deleteByTopicUuidAndUserUuid(Long topicUuid, Long userUuid) {
		bbsCollectMapper.deleteByTopicUuidAndUserUuid(topicUuid,userUuid);
		
	}
}
