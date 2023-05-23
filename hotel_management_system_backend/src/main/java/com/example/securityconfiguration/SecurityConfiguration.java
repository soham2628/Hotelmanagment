package com.example.securityconfiguration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration//it will behave as configuration component and it will notify to the spring container 
@EnableWebSecurity//it will notify to the spring container that there is websecurity 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Bean
	AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
		
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService);
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		System.out.println("SpringSecurity!");
		http
		.cors()
		.and()
		.csrf().disable().authorizeRequests().antMatchers("/**").permitAll()
		.antMatchers(HttpMethod.OPTIONS).permitAll()
		//.anyRequest().authenticated();
		.antMatchers("/user/**")
		.hasAuthority("USER")
		.antMatchers("/admin/**")//URL
		.hasAnyAuthority("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		//.formLogin();*/
	.httpBasic();
		//formLogin()
	}
}