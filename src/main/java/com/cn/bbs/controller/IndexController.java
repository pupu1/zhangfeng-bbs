package com.cn.bbs.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cn.bbs.dto.pageData;
import com.cn.bbs.model.BbsTopic;
import com.cn.bbs.service.TopicService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Controller
public class IndexController {
	@Autowired
	private TopicService topicService;
	
	private Integer pageSize=2; 

	@RequestMapping(value = "/")
	public String index(HttpServletRequest request) {
		return "redirect:/tab/all";
	}
	@RequestMapping(value = "/tab/{tab}")
	public String index(HttpServletRequest request,
			@PathVariable(value = "tab") String tab,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
		request.setAttribute("tab", tab);
		pageData<BbsTopic> page = topicService.selectByTabAndPage(tab,pageSize,pageNum);
		request.setAttribute("page", page);
		return "topic";
	}
	
	@RequestMapping(value = "/upload")
	public @ResponseBody String upload_image(HttpServletRequest request,
														@RequestParam(value = "file") MultipartFile pictureFile) throws IOException {
		String originalFilename = pictureFile.getOriginalFilename();
		String suffix= originalFilename.substring(originalFilename.indexOf("."));
		String filename=new SimpleDateFormat("YYYYMMddHHmmSSsss").format(new Date());
		String path="http://localhost/bbs-server/upload/"+filename+suffix;
		Client client = Client.create();
		WebResource resource = client.resource(path);
		byte[] bs = pictureFile.getBytes();
		resource.put(bs);
		return path;
		
		
		
	}
	

}
