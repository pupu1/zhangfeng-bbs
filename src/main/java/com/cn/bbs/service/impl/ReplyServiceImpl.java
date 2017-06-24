package com.cn.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bbs.dao.BbsReplyMapper;
import com.cn.bbs.dto.pageData;
import com.cn.bbs.model.BbsReply;
import com.cn.bbs.model.BbsTopic;
import com.cn.bbs.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private BbsReplyMapper bbsReplyMapper;
	
	public Integer insert(BbsReply reply) {
		return bbsReplyMapper.insertSelective(reply);
	}
	public pageData<BbsReply> selectByPage(Integer pageSize, Integer pageNum,Long topicUuid) {
		Integer totalRow=bbsReplyMapper.selectByPageCount(topicUuid);
		List<BbsReply> topicList=bbsReplyMapper.selectByPage((pageNum-1)*pageSize,pageSize,topicUuid);
		return new pageData<BbsReply>(topicList, pageNum, pageSize, totalRow);
	}
	
}
