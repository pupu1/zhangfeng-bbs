package com.cn.bbs.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.bbs.dao.BbsCollectMapper;
import com.cn.bbs.model.BbsCollect;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class CollectServiceImplTest {
	@Autowired
	private BbsCollectMapper bbsCollectMapper;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelectByTopicUuidAndUserUuid() {
		BbsCollect collect = bbsCollectMapper.selectByTopicUuidAndUserUuid(4L,1L);
	}

}
