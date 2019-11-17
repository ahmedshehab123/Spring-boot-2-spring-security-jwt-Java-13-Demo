package com.toystore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@SpringBootApplication
@EnableResourceServer
@Order(-1)
public class ToystoreApplication /*extends ResourceServerConfigurerAdapter */{


	public static void main(String[] args){

		SpringApplication.run(ToystoreApplication.class, args);
	}

	/*@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers( "/uaa/currentUser/**","/favicon.ico","/uaa/signup/**", "/oauth**","/api/search/**").permitAll()
				.anyRequest().authenticated();

	}
*/


}
