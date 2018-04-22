package com.ning.itning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/admin/**", "/adminApi/**").authenticated().
                antMatchers("/").permitAll().
                and().formLogin().permitAll().
                and().logout().logoutSuccessUrl("/").permitAll();
    }
}
