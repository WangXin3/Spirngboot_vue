package com.wxx.springbootvue.system.controller;

import com.wxx.springbootvue.system.service.UserService;
import com.wxx.springbootvue.system.util.JwtUser;
import com.wxx.springbootvue.utils.RespBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 她爱微笑
 * @date 2020/3/8
 */
@RestController
@RequestMapping("/system/user")
public class UserController {

	/**
	 * UserController日志对象
	 */
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping
	@PreAuthorize("@wx.check('user:list')")
	public RespBean getUserList() {
		logger.info("获取用户信息");
		return RespBean.successData(userService.getUserList());
	}

	@GetMapping("/{uid}")
	@PreAuthorize("@wx.check('user:list')")
	public RespBean getUserById(@PathVariable Long uid) {
		return RespBean.successData(userService.getUserById(uid));
	}

	@GetMapping("/info")
	public RespBean getCurrentUser() {
		JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return RespBean.successData(user);
	}
}
