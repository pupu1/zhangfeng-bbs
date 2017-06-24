package com.cn.bbs.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.cn.bbs.util.FormatUtil;

public class BbsTopic {

	private Long uuid;
	private String tab;
	public static final List<String> tabs=new LinkedList<String>();
	private String title;
	private String tag;
	private Date inTime;
	private Date modifyTime;
	private Date lastReplyTime;
	private String llastReplyName;
	private Integer viewCount;
	private String author;
	private Boolean isTop;
	private Boolean isGood;
	private Integer replyCount;
	private Boolean isDelet;
	private String content;
	
	private String inTimeView;
	
	static{
	tabs.add("新闻");	
	tabs.add("动画");	
	tabs.add("游戏");	
	}
	public String getInTimeView() {
		return inTimeView;
	}

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
		this.inTimeView=FormatUtil.formatDateTime2(inTime);
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getLastReplyTime() {
		return lastReplyTime;
	}

	public void setLastReplyTime(Date lastReplyTime) {
		this.lastReplyTime = lastReplyTime;
	}

	public String getLlastReplyName() {
		return llastReplyName;
	}

	public void setLlastReplyName(String llastReplyName) {
		this.llastReplyName = llastReplyName;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Boolean getIsTop() {
		return isTop;
	}

	public void setIsTop(Boolean isTop) {
		this.isTop = isTop;
	}

	public Boolean getIsGood() {
		return isGood;
	}

	public void setIsGood(Boolean isGood) {
		this.isGood = isGood;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public Boolean getIsDelet() {
		return isDelet;
	}

	public void setIsDelet(Boolean isDelet) {
		this.isDelet = isDelet;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
   
}