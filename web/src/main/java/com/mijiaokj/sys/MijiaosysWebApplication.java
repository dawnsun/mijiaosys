package com.mijiaokj.sys;

import com.mijiaokj.sys.web.security.AbstractSecurityInterceptorFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author sunchenguang
 * @mail scg16@126.com
 * 启动方法
 */
@SpringBootApplication
@EnableCaching
//@EnableAutoConfiguration(exclude = AbstractSecurityInterceptorFilter.class)
public class MijiaosysWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MijiaosysWebApplication.class, args);
	}
}
