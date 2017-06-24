package com.cn.bbs.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.bbs.dto.pageData;
import com.cn.bbs.model.BbsCollect;
import com.cn.bbs.model.BbsTopic;
import com.cn.bbs.model.BbsUser;
import com.cn.bbs.service.CollectService;

@Controller
@RequestMapping("/collect")
public class CollectController {

	@Autowired
	private CollectService collectService;
	
	@RequestMapping(value = "/add/{topicUuid}/{pageNum}")
	public String add(HttpServletRequest request,
							@PathVariable("topicUuid") Long topicUuid,
								@PathVariable("pageNum") Integer pageNum) {
		BbsUser user = (BbsUser) request.getSession().getAttribute("user");
		if (user==null) {
			return "redirect:/reply/"+topicUuid+"/"+pageNum;
		}
		Long userUuid = user.getUuid();
		BbsCollect Ocollect=collectService.selectByTopicUuidAndUserUuid(topicUuid,userUuid);
		if (Ocollect!=null) {
			return "redirect:/reply/"+topicUuid+"/"+pageNum;
		}
		BbsCollect collect = new BbsCollect();
		Date date = new Date();
		collect.setUserUuid(userUuid);
		collect.setTopicUuid(topicUuid);
		collect.setInTime(date);
		collectService.insert(collect);
		return "redirect:/reply/"+topicUuid+"/"+pageNum;
	}

	@RequestMapping(value = "/delete/{topicUuid}/{pageNum}")
	public String delete(HttpServletRequest request,
							@PathVariable("topicUuid") Long topicUuid,
								@PathVariable("pageNum") Integer pageNum) {
		BbsUser user = (BbsUser) request.getSession().getAttribute("user");
		if (user==null) {
			return "redirect:/reply/"+topicUuid+"/"+pageNum;
		}
		Long userUuid = user.getUuid();
		collectService.deleteByTopicUuidAndUserUuid(topicUuid,userUuid);
		return "redirect:/reply/"+topicUuid+"/"+pageNum;
	}
}
