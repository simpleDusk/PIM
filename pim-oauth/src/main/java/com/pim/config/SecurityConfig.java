package com.pim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName SecurityConfig
 * @Author Lyf
 * @Version
 **/
@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 添加授权账号
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 设置用户账号信息和权限
        auth.inMemoryAuthentication().withUser("zhangsan").password("123456").authorities("save",
                "delete", "update", "list");
        auth.inMemoryAuthentication().withUser("lisi").password("141310").authorities(
                "delete");
    }

    /**
     * 配置HttpSecurity 拦截资源
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //HTTP方式
        //http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic();
        //表单方式
        //http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().formLogin();

        http.authorizeRequests()
                .antMatchers("/save").hasAnyAuthority("save")
                .antMatchers("/delete").hasAnyAuthority("delete")
                .antMatchers("/update").hasAnyAuthority("update")
                .antMatchers("/list").hasAnyAuthority("list")
                .antMatchers("/**").fullyAuthenticated().and().formLogin();
    }


    /**
     * There is no PasswordEncoder mapped for the id "null"
     * 原因:升级为Security5.0以上密码支持多中加密方式，恢复以前模式
     * @return
     */
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}