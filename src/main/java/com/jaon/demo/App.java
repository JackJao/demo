package com.jaon.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Administrator
 * 1.打包成jar包时候需要：注释AppTomcat中@SpringBootApplication
 * 2.因为启动入口只有一个，所以启动类只能有一个被@SpringBootApplication注解
 * 3.修改pom配置：<packaging>jar</packaging>
 */
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
