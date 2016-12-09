package com.haytap.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception 
    {
    	auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password, enabled from users where username=?")
        .authoritiesByUsernameQuery("select username, role from user_roles where username =?  ")
        .passwordEncoder(new Md5PasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception 
    { 
      http.authorizeRequests()
      .antMatchers("/adminPage/**").access("hasRole('ROLE_ADMIN')")
      .antMatchers("/guestPage/**").access("hasRole('ROLE_GUEST') or hasRole('ROLE_ADMIN')")
      .and().formLogin().loginPage("/login.xhtml").defaultSuccessUrl("/guestPage/index.xhtml")
        .usernameParameter("j_username").passwordParameter("j_password");	
      http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
}