package com.mijiaokj.sys.controller.web.config;

import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author sunchenguang
 * security初始化spring session
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

	public SecurityInitializer() {
		super(SecurityConfig.class, HttpSessionConfig.class);
	}
}
