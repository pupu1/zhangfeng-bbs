package com.cn.bbs.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.bbs.dto.pageData;
import com.cn.bbs.model.BbsCollect;
import com.cn.bbs.model.BbsReply;
import com.cn.bbs.model.BbsTopic;
import com.cn.bbs.model.BbsUser;
import com.cn.bbs.service.CollectService;
import com.cn.bbs.service.ReplyService;
import com.cn.bbs.service.TopicService;

@Controller
@RequestMapping("/reply")
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private CollectService collectService;
	
	private Integer pageSize=2;
	
	@RequestMapping(value = "/create")
	public String replyCreate(HttpServletRequest request,@RequestParam("topicUuid")Long topicId,
						@RequestParam("content")String content) {
		Date date = new Date();
		BbsUser user = (BbsUser) request.getSession().getAttribute("user");
		BbsTopic topic = topicService.selectByUuid(topicId);
		topic.setReplyCount(topic.getReplyCount()+1);
		topic.setLastReplyTime(date);
		topic.setLlastReplyName(user.getNickName());
		topicService.update(topic);
		BbsReply reply = new BbsReply();
		reply.setAuthor(user.getNickName());
		reply.setContent(content);
		reply.setInTime(date);
		reply.setTopicId(topicId);
		reply.setIsDelete(false);
		replyService.insert(reply);
		return "redirect:/reply/"+topicId+"/1";
	}
	
	@RequestMapping(value = "/{topicUuid}/{pageNum}")
	public String topicReply(HttpServletRequest request,@PathVariable("topicUuid")Long topicUuid,@PathVariable("pageNum")Integer pageNum) {
		BbsTopic topic = topicService.selectByUuid(topicUuid); 
		request.setAttribute("topic", topic);
		pageData<BbsReply> page = replyService.selectByPage(pageSize,pageNum,topicUuid);
		request.setAttribute("page", page);
		BbsUser user = (BbsUser) request.getSession().getAttribute("user");
		Long userUuid = user.getUuid();
		Integer collectCount=collectService.selectByTopicUuidCount(topicUuid);
		request.setAttribute("collectCount", collectCount);
		BbsCollect collect=collectService.selectByTopicUuidAndUserUuid(topicUuid,userUuid);
		if (user!=null&&collect!=null) {
			request.setAttribute("collect", collect);
		}
		return "topic_reply";
	}
}
