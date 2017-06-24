package com.cn.bbs.model;

import java.util.Date;

import com.cn.bbs.util.FormatUtil;

public class BbsReply {
    private Long uuid;

    private Long topicId;

    private Long referUuid;

    private Date inTime;

    private String author;

    private Boolean isDelete;

    private String content;
    
    private String inTimeView;

    public String getInTimeView() {
		return inTimeView;
	}

	public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getReferUuid() {
        return referUuid;
    }

    public void setReferUuid(Long referUuid) {
        this.referUuid = referUuid;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
        this.inTimeView=FormatUtil.formatDateTime2(inTime);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}