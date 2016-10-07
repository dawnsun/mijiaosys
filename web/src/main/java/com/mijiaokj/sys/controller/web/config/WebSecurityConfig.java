package com.mijiaokj.sys.controller.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.mijiaokj.sys.controller.web.security.MijiaoSysAuthenticationProvider;
import com.mijiaokj.sys.controller.web.security.MijiaoSysUserDetailsService;

/**
 * @author sunchenguang
 * @mail scg16@126.com
 * security 整合 用户登录和角色权限的验证
 *  注：资源操作路径暂时写死，后期更改
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MijiaoSysAuthenticationProvider provider;

	@Bean
	UserDetailsService customUserService() {
		return new MijiaoSysUserDetailsService();
	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/sys/add", "/sys/edit", "/sys/view").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers("/sys/view", "/sys/list").hasAuthority("USER");
		http.authorizeRequests().antMatchers("/js/**", "/font-awesome/**", "/fonts/**", "/img/**", "/css/**")
				.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/index").permitAll().and().logout().permitAll();
	}

}
