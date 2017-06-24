package com.cn.bbs.service;

import com.cn.bbs.dto.pageData;
import com.cn.bbs.model.BbsReply;

public interface ReplyService {

	Integer insert(BbsReply reply);

	pageData<BbsReply> selectByPage(Integer pageSize, Integer pageNum,Long topicUuid);
	
}
