package com.jaon.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
        //忽略druid管理的url访问，权限释放
        //让security的csrf校验忽略druid请求。
        http.csrf().ignoringAntMatchers("/druid/*");
        //通过spring security 的表单登录
         http.authorizeRequests().anyRequest().authenticated().and().formLogin()
                 //开启自动配置的登录功能，如果没有登录或者没有权限就会来到登录页面,会访问/login
                 .usernameParameter("admin").passwordParameter("123456");
        //通过spring security 的对话框登录
        //http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
        //开启自动配置的注销功能，会访问/logout请求
        //注销成功后返回到首页/
        http.logout().logoutSuccessUrl("/");
        //开启记住我功能
        http.rememberMe();
    }

    /**
     * 登录用户使用明文密码校验，登录是否成功
     * @return
     */
    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return new String(rawPassword.toString());
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equals(encodedPassword);
            }
        };
    }*/

    /**
     * 登录用户使用加密后的密码校验，登录是否成功
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
