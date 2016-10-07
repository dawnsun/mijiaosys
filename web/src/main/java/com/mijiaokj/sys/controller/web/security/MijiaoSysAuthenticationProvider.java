package com.mijiaokj.sys.controller.web.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.mijiaokj.sys.common.util.Md5Util;

/**
 * @author sunchenguang
 * @mail scg16@126.com
 * 用户登录确认
 *
 */
@Component
public class MijiaoSysAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private MijiaoSysUserDetailsService mijiaoSysUserDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = Md5Util.md5calc((String) authentication.getCredentials());
		MijiaoSysUserDetails user = (MijiaoSysUserDetails) mijiaoSysUserDetailsService.loadUserByUsername(username);
		if (user == null) {
			throw new BadCredentialsException("Username not found.");
		}
		// 加密过程在这里体现
		if (!password.equals(user.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}

		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
