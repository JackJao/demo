package com.jaon.demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Gao
 * @date 2018/8/14 10:17
 * 自定义认证配置方式：表单方式和对话框方式，spring security 5.0.4默认是表单方式
 * 这里是security入门demo配置示例
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //通过spring security 的表单登录
        http.authorizeRequests().anyRequest().authenticated().and().formLogin();
        //通过spring security 的对话框登录
        //http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
