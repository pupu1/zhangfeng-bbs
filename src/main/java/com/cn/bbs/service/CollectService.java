package com.cn.bbs.service;

import com.cn.bbs.model.BbsCollect;

public interface CollectService {

	public Integer selectByTopicUuidCount(Long topicUuid);

	public BbsCollect selectByTopicUuidAndUserUuid(Long topicUuid, Long userUuid);

	public void insert(BbsCollect collect);

	public void deleteByTopicUuidAndUserUuid(Long topicUuid, Long userUuid);

}
