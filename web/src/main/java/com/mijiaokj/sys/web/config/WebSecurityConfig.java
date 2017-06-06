package com.mijiaokj.sys.web.config;

import com.mijiaokj.sys.web.LoginSuccessHandler;
import com.mijiaokj.sys.web.security.AbstractSecurityInterceptorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.mijiaokj.sys.web.security.MijiaoSysAuthenticationProvider;
import com.mijiaokj.sys.web.security.MijiaoSysUserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @author sunchenguang
 * @mail scg16@126.com
 * security 整合 用户登录和角色权限的验证
 *  注：资源操作路径暂时写死，后期更改
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MijiaoSysAuthenticationProvider mijiaoSysAuthenticationProvider;

    @Autowired
    private AbstractSecurityInterceptorFilter abstractSecurityInterceptorFilter;

    @Bean
	UserDetailsService customUserService() {
		return new MijiaoSysUserDetailsService();
	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(mijiaoSysAuthenticationProvider);
	}
	@Bean
	public LoginSuccessHandler loginSuccessHandler(){
		return new LoginSuccessHandler();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
                .addFilterBefore(abstractSecurityInterceptorFilter, FilterSecurityInterceptor.class)//添加我们自定义的过滤器
                .authorizeRequests()
                .antMatchers("/js/**", "/font-awesome/**", "/fonts/**", "/img/**", "/css/**","/webjars/**","/images/**").permitAll()//访问："/js/**", "/font-awesome/**", "/fonts/**", "/img/**", "/css/**","/webjars/**","/images/**" 无需登录认证权限
                .anyRequest().authenticated() //其他所有资源都需要认证，登陆后访问
//                .antMatchers("/sys","/swagger-ui.html").hasAuthority("ADMIN") //登陆后之后拥有“ADMIN”权限才可以访问/hello方法，否则系统会出现“403”权限不足的提示
                .and()
                .formLogin()
                .loginPage("/login")//指定登录页是”/login”
                .permitAll()
//                .successHandler(loginSuccessHandler()) //登录成功后可使用loginSuccessHandler()存储用户信息，可选。
                .and()
                .logout()
                .logoutSuccessUrl("/login") //退出登录后的默认网址是”/home”
                .permitAll();

//		http.authorizeRequests().antMatchers("/sys/add", "/sys/edit", "/sys/view").hasAuthority("ADMIN");
//		http.authorizeRequests().antMatchers("/sys/view", "/sys/list","/swagger-ui.html").hasAuthority("USER");
//		http.authorizeRequests().antMatchers("/js/**", "/font-awesome/**", "/fonts/**", "/img/**", "/css/**","/webjars/**","/images/**")
//				.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login")
//				.defaultSuccessUrl("/index").permitAll().and().logout().permitAll();
	}

}
