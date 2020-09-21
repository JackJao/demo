package com.jaon.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Administrator
 * 1.打包成war包的时候需要：注释App@SpringBootApplication
 * 2.因为启动入口只有一个，所以启动类只能有一个被@SpringBootApplication注解
 * 3.修改pom配置：a.<packaging>war</packaging> b.方式一、方式二任选其一（区别生成包的大小差2M左右），也可不配置具体看pom注释说明
 */
@SpringBootApplication
public class AppTomcat extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}

	public static void main(String[] args) {
		SpringApplication.run(AppTomcat.class, args);
	}
}
