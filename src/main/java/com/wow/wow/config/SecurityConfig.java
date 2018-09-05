package com.wow.wow.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(delegatingPasswordEncoder())
		.withUser("user")
		.password(delegatingPasswordEncoder()
		.encode("password")).roles("USER");
	}*/
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		System.out.println("alskdfnko");
		http.csrf().disable();
        http
            .httpBasic().and()
            .authorizeRequests().anyRequest().permitAll().and().httpBasic();
    }
	/*@Bean
	public PasswordEncoder delegatingPasswordEncoder() {
	    PasswordEncoder defaultEncoder = new BCryptPasswordEncoder();
	    return defaultEncoder;
	}*/

}
