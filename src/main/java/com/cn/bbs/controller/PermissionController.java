package com.cn.bbs.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.bbs.dto.pageData;
import com.cn.bbs.model.BbsPermission;
import com.cn.bbs.model.BbsRole;
import com.cn.bbs.model.BbsTopic;
import com.cn.bbs.model.BbsUser;
import com.cn.bbs.service.LoginService;
import com.cn.bbs.service.PermissionService;

@Controller
@RequestMapping(value = "/permission")
public class PermissionController {
	@Value("${pageSize}") 
	private String pageSize; 
	@Autowired
	private  PermissionService  permissionService;
	
	/**
	 * 用户管理页面
	 */
	@RequestMapping(value = "/")
	public String index(HttpServletRequest request) {
			return "redirect:/permission/user/1";
	}
	/**
	 * 用户管理页面（翻页）
	 */
	@RequestMapping(value = "/user/{pageNum}")
	public String user(HttpServletRequest request,
			@RequestParam(value = "per_tab", defaultValue = "user") String per_tab,
			@PathVariable(value = "pageNum") Integer pageNum) {
		request.setAttribute("per_tab", per_tab);
		Integer IpageSize = Integer.valueOf(pageSize.trim());
		pageData<BbsUser> page = permissionService.selectUserByPage(IpageSize,pageNum);
		request.setAttribute("page", page);
		return "permission_user";
	}
	
	/**
	 * 用户编辑页面
	 */
	@RequestMapping(value = "/user/edit/{uuid}")
	public String index(HttpServletRequest request,@PathVariable(value = "uuid") Long uuid) {
			request.setAttribute("per_tab", "userEdit");
			BbsUser perUser = permissionService.selectUserByUuid(uuid);
			List<BbsRole> roles=permissionService.getAllRole();
			request.setAttribute("perUser", perUser);
			request.setAttribute("roles", roles);
		return "user_edit";
	}
	
	/**
	 * 用户编辑确认
	 */
	@RequestMapping(value = "/user/userEdited")
	public String userEdited(HttpServletRequest request,@RequestParam(value = "uuid") Long uuid,@RequestParam(value = "role") Integer role) {
		BbsUser perUser = permissionService.selectUserByUuid(uuid);
		perUser.setType(role);
		permissionService.updateUser(perUser);
		return "redirect:/permission/user/1";
	}
	/**
	 * 权限管理
	 */
	@RequestMapping(value = "/permissionPage")
	public String permissionPage(HttpServletRequest request) {
		List<BbsRole> roles=permissionService.getAllRole();
		request.setAttribute("roles", roles);
		List<BbsPermission> permissions=permissionService.getSecondPermissions();
		request.setAttribute("permissions", permissions);
		request.setAttribute("per_tab", "permission");
		return "permission_permission";
	}
}
