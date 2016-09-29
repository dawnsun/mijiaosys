/*
 * Cainiao.com Inc.
 * Copyright (c) 2013-2016 All Rights Reserved.
 */
package com.mijiaokj.sys.dal.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mijiaokj.sys.common.util.CipherUtil;


/**
 * mybatis数据源等的相关配置
 *
 * @author moyun
 * @version $Id: MyBatisConfig.java, v 0.1 2016-09-08 下午8:17 moyun Exp $$
 */
@Configuration
public class MyBatisConfig {

	@Autowired
	private DataSourceProperties properties;

	/**
	 * 将加密的数据库地址和密码进行解密，并且构造自定义的数据源
	 *
	 * @return 数据源
	 */
	@Bean
	public DataSource dataSource() {
		String encryptedUrl = properties.getUrl();
		String encryptedPwd = properties.getPassword();
		String encryptedUserName = properties.getUsername();

		try {
			properties.setUrl(CipherUtil.decryptAes(encryptedUrl));
			properties.setPassword(CipherUtil.decryptAes(encryptedPwd));
			properties.setUsername(CipherUtil.decryptAes(encryptedUserName));
		} catch (Exception e) {
			throw new RuntimeException("对数据库连接信息进行解密时发生异常。[encryptedUrl=" + encryptedUrl + "][encryptedPwd=+" + encryptedPwd + "][encryptedUserName=" + encryptedUserName + "]", e);
		}

		DataSourceBuilder factory = DataSourceBuilder
				.create(this.properties.getClassLoader())
				.driverClassName(this.properties.getDriverClassName())
				.url(this.properties.getUrl()).username(this.properties.getUsername())
				.password(this.properties.getPassword());
		if (this.properties.getType() != null) {
			factory.type(this.properties.getType());
		}
		return factory.build();
	}

}