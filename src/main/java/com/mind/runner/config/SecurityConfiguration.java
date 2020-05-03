package com.mind.runner.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ConfigurationProperties("app.configuration")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private String security;
    
    @Autowired
    DataSource dataSource;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        if(security != null && security.equals("true")) {
            http.authorizeRequests()
                    .antMatchers("/h2/**").permitAll()
                    .anyRequest().authenticated()//all other urls can be access by any authenticated role
                    .and().formLogin()//enable form login instead of basic login
                    .and().csrf().ignoringAntMatchers("/h2/**")//don't apply CSRF protection to /h2-console
                    .and().headers().frameOptions().sameOrigin();//allow use of frame to same origin urls
        }
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder());
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }
}
