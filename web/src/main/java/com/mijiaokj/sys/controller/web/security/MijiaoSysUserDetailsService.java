package com.mijiaokj.sys.controller.web.security;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.domain.SysRole;
import com.mijiaokj.sys.domain.SysUser;
import com.mijiaokj.sys.service.SysRoleService;
import com.mijiaokj.sys.service.SysUserService;

/**
 * @author sunchenguang
 * @mail scg16@126.com 
 * security用户服务
 */

@Service("mijiaoSysUserDetailsService")
public class MijiaoSysUserDetailsService implements UserDetailsService {

	@Resource(name = "sysUserService")
	private SysUserService sysUserService;

	@Resource(name = "sysRoleService")
	private SysRoleService sysRoleService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		SysUser user;
		try {
			Result<SysUser> restUser = sysUserService.findByUsername(userName);
			user = restUser.getData();
		} catch (Exception e) {
			throw new UsernameNotFoundException("user select fail");
		}
		if (user == null) {
			throw new UsernameNotFoundException("no user found");
		} else {
			try {
				Result<List<SysRole>> resRoles = sysRoleService.getRoleByUserId(user.getId());
				List<SysRole> roles = resRoles.getData();
				return new MijiaoSysUserDetails(user, roles);
			} catch (Exception e) {
				throw new UsernameNotFoundException("user role select fail");
			}
		}
	}

}
