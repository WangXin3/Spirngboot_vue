package com.wxx.springbootvue.mapper;

import com.wxx.springbootvue.dao.Role;

import java.util.List;

/**
 * @author 她爱微笑
 * @date 2020/3/14
 */
public interface RoleMapper {

	/**
	 * 获取角色列表
	 * @return
	 */
	List<Role> getRoleList();

}
