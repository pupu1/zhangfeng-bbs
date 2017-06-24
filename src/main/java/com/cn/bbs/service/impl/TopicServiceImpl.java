package com.cn.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bbs.dao.BbsTopicMapper;
import com.cn.bbs.dto.pageData;
import com.cn.bbs.model.BbsTopic;
import com.cn.bbs.service.TopicService;
@Service
public class TopicServiceImpl implements TopicService {
	@Autowired
	private BbsTopicMapper bbsTopicMapper;

	public Integer insert(BbsTopic bbsTopic) {
		
		return bbsTopicMapper.insertSelective(bbsTopic);
	}

	public List<BbsTopic> selectByTab(String tab) {
		return bbsTopicMapper.selectByTab(tab);
	}

	public pageData<BbsTopic> selectByTabAndPage(String tab, Integer pageSize, Integer pageNum) {
		if (tab.equals("all")) {
			Integer totalRow=bbsTopicMapper.selectByPageCount();
			if (totalRow<=0) {
				return new pageData<BbsTopic>(null, 1, pageSize, 1);
			}
			List<BbsTopic> topicList=bbsTopicMapper.selectByPage((pageNum-1)*pageSize,pageSize);
			while (topicList.size()==0) {
				pageNum--;
				topicList=bbsTopicMapper.selectByPage((pageNum-1)*pageSize,pageSize);
			}
			return new pageData<BbsTopic>(topicList, pageNum, pageSize, totalRow);
		}
			Integer totalRow=bbsTopicMapper.selectByTabAndPageCount(tab);
			if (totalRow<=0) {
				return new pageData<BbsTopic>(null, 1, pageSize, 1);
			}
			List<BbsTopic> topicList=bbsTopicMapper.selectByTabAndPage(tab,(pageNum-1)*pageSize,pageSize);
			while (topicList.size()==0) {
				pageNum--;
				if (pageNum<=0) {
					pageNum++;
					break;
				}
				topicList=bbsTopicMapper.selectByTabAndPage(tab,(pageNum-1)*pageSize,pageSize);
			}
			return new pageData<BbsTopic>(topicList, pageNum, pageSize, totalRow);
	}

	public BbsTopic selectByUuid(Long uuid) {
		return bbsTopicMapper.selectByPrimaryKey(uuid);
	}

	public void update(BbsTopic topic) {
		bbsTopicMapper.updateByPrimaryKeySelective(topic);
	}

	public void deleteById(Integer uuid) {
		bbsTopicMapper.deleteById(uuid);
	}

	@Override
	public void updateIsTop(Integer uuid,Boolean istop) {
		bbsTopicMapper.updateIsTop(uuid,istop);
		
	}

	@Override
	public void updateIsGood(Integer uuid, Boolean isgood) {
		bbsTopicMapper.updateIsGood(uuid,isgood);
		
	}

}
