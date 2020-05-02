package com.mind.runner.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2/**").permitAll()
                .anyRequest().authenticated()//all other urls can be access by any authenticated role
                .and().formLogin()//enable form login instead of basic login
                .and().csrf().ignoringAntMatchers("/h2/**")//don't apply CSRF protection to /h2-console
                .and().headers().frameOptions().sameOrigin();//allow use of frame to same origin urls
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder());
    }

}
