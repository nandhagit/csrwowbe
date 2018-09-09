package com.wow.wow.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService).passwordEncoder(delegatingPasswordEncoder());
	}
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		System.out.println("alskdfnko");
		http.csrf().disable();
        http
            .httpBasic().and()
            .authorizeRequests().anyRequest().permitAll().and().httpBasic();
    }
	
	@Bean
	public PasswordEncoder delegatingPasswordEncoder() {
	    PasswordEncoder defaultEncoder = new BCryptPasswordEncoder();
	    return defaultEncoder;
	}
	

}
