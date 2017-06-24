package com.cn.bbs.model;

import java.util.Date;

public class BbsCollect {
    private Long uuid;

    private Long topicUuid;

    private Long userUuid;

    private Date inTime;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Long getTopicUuid() {
        return topicUuid;
    }

    public void setTopicUuid(Long topicUuid) {
        this.topicUuid = topicUuid;
    }

    public Long getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(Long userUuid) {
        this.userUuid = userUuid;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }
}