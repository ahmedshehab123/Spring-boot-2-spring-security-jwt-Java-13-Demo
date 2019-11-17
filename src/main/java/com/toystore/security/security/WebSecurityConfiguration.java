package com.toystore.security.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


/**
 * Created by ahmed on 20.5.18.
 */
@Configuration

@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true)
@Order(6)
public class WebSecurityConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers( "/uaa/currentUser/**","/uaa/signup/**", "/oauth**","/api/search/**","/api/prices**").permitAll()
                .antMatchers("/swagger**").permitAll()
                .anyRequest().authenticated();
    }


    //
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers( "/uaa/currentUser/**", "/oauth**").permitAll()
//                .antMatchers("/api/**").authenticated()
//                .and().userDetailsService(userDetailsServiceBean());
//        http.authorizeRequests().antMatchers("/api/**").authenticated().and().userDetailsService(userDetailsServiceBean());
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsServiceBean())
//                .passwordEncoder(passwordEncoder());
//    }

//    public static void main (String[] args){
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("user"));
//    }
}
