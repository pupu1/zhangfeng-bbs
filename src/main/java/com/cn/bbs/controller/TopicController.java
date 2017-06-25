package com.cn.bbs.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.xml.resolver.apps.resolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.bbs.dto.pageData;
import com.cn.bbs.exception.BbsException;
import com.cn.bbs.model.BbsCollect;
import com.cn.bbs.model.BbsReply;
import com.cn.bbs.model.BbsTopic;
import com.cn.bbs.model.BbsUser;
import com.cn.bbs.service.CollectService;
import com.cn.bbs.service.ReplyService;
import com.cn.bbs.service.TopicService;


@Controller
@RequestMapping(value = "/topic")
public class TopicController {
	
	@Value("${pageSize}") 
	private String pageSize; 
	@Autowired
	private ReplyService replyService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private CollectService collectService;
	
	/**
	 * 创建话题页面
	 */
	@RequestMapping(value = "/edit/editPage")
	public String topicEdit(HttpServletRequest request) {
		request.setAttribute("tabs", BbsTopic.tabs);
		return "topic_edit";
	}
	
	/**
	 * 创建话题
	 */
	@RequestMapping(value = "/create")
	public String topicCreate(HttpServletRequest request,@RequestParam("title")String title,
								@RequestParam("tag")String tag,
									@RequestParam("tab")String tab,
										@RequestParam("content")String content) {
		boolean flag=true;
		for (String tabName : BbsTopic.tabs) {
			System.out.println("tabName");
			if (tabName.equals(tab)) {
				flag=false;
				break;
			}
		}
		if (flag) {
			throw new BbsException("不能在未知版块创建话题");
		}
		Date date = new Date();
		BbsUser bbsUser = (BbsUser) request.getSession().getAttribute("user");
		BbsTopic bbsTopic = new BbsTopic();
		bbsTopic.setTitle(title);
		bbsTopic.setTab(tab);
		bbsTopic.setTag(tag);
		bbsTopic.setAuthor(bbsUser.getNickName());
		bbsTopic.setInTime(date);
		bbsTopic.setContent(content);
		bbsTopic.setIsGood(false);
		bbsTopic.setIsTop(false);
		bbsTopic.setViewCount(0);
		bbsTopic.setIsDelet(false);
		bbsTopic.setReplyCount(0);
		topicService.insert(bbsTopic);
		return "redirect:/";
	}
	
	/**
	 * 删除话题
	 */
	@RequestMapping(value = "/delete/{uuid}/{pageNum}")
	public String topicDelete(HttpServletRequest request,@PathVariable("uuid")Integer uuid,@PathVariable("pageNum")String pageNum) {
		topicService.deleteById(uuid);
		return "redirect:/?pageNum="+pageNum;
	}
	
	/**
	 * 话题置顶
	 */
	@RequestMapping(value = "/istop/{istop}/{uuid}/{pageNum}")
	public String topicIsTop(HttpServletRequest request,@PathVariable("uuid")Integer uuid,
			@PathVariable("istop")Boolean istop,@PathVariable("pageNum")String pageNum) {
		topicService.updateIsTop(uuid,istop);
		return "redirect:/?pageNum="+pageNum;
	}
	
	/**
	 * 话题加精
	 */
	@RequestMapping(value = "/isgood/{isgood}/{uuid}/{pageNum}")
	public String topicIsGood(HttpServletRequest request,@PathVariable("uuid")Integer uuid,
			@PathVariable("isgood")Boolean isgood,@PathVariable("pageNum")String pageNum) {
		topicService.updateIsGood(uuid,isgood);
		return "redirect:/?pageNum="+pageNum;
	}
	
	/**
	 * 进入话题
	 */
	@RequestMapping(value = "/intoTopic/{topicUuid}")
	public String topic(HttpServletRequest request,@PathVariable("topicUuid")Long topicUuid) {
		Integer pageNum=1;
		BbsTopic topic = topicService.selectByUuid(topicUuid); 
		request.setAttribute("topic", topic);
		Integer IpageSize = Integer.valueOf(pageSize.trim());
		pageData<BbsReply> page = replyService.selectByPage(IpageSize,pageNum,topicUuid);
		request.setAttribute("page", page);
		BbsUser user = (BbsUser) request.getSession().getAttribute("user");
		if (null!=user) {
			Long userUuid = user.getUuid();
			Integer collectCount=collectService.selectByTopicUuidCount(topicUuid);
			request.setAttribute("collectCount", collectCount);
			BbsCollect collect=collectService.selectByTopicUuidAndUserUuid(topicUuid,userUuid);
			if (null!=collect) {
				request.setAttribute("collect", collect);
			}
		}
		return "topic_reply";
	}

}
