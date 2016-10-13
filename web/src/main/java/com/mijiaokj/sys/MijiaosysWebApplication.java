package com.mijiaokj.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author sunchenguang
 * @mail scg16@126.com
 * 启动方法
 */
@SpringBootApplication
@EnableCaching
public class MijiaosysWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MijiaosysWebApplication.class, args);
	}
}
