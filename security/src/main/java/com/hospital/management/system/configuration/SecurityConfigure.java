package com.hospital.management.system.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hospital.management.system.services.JwtUserDetailsServiceImpl;
import com.hospital.management.system.services.UserAuthenticationProvider;


@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserAuthenticationProvider userAuthenticationProvider; 
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
    private JwtUserDetailsServiceImpl jwtUserDetailsService;
	
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { // TODO Auto-generated method stub
	 * auth.userDetailsService(userAuthenticationProvider); //super.configure(auth);
	 * }
	 */
	
	@Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .authenticationProvider(userAuthenticationProvider)
                .userDetailsService(this.jwtUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable()
		.authorizeRequests().antMatchers("/v2/api-docs","/swagger-resources/**",
        "/swagger-ui.html",
        "/configuration/**",
        "/webjars/**",
        "/public","/authenticate").permitAll()
		.anyRequest().authenticated()
		.and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
