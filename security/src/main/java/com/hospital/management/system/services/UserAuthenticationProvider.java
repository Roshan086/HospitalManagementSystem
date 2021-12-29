package com.hospital.management.system.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hospital.management.system.model.EmployeeModel;
import com.hospital.management.system.model.JwtUser;
import com.hospital.management.system.repository.EmployeeRepository;
import com.hospital.management.system.utill.EncoderDecoder;

@Service
public class UserAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String loginId = authentication.getName().trim();
        String password = EncoderDecoder.getEncryptedSHA1Password(authentication.getCredentials().toString().trim());

        Authentication auth = null;
        EmployeeModel umUsers = employeeRepository.findByUserNameAndPassword(loginId, password);

        if (umUsers != null) {
            Collection<GrantedAuthority> grantedAuths = null;
            JwtUser appUser = new JwtUser(Long.parseLong(umUsers.getId() + ""), null, null, null, umUsers.getUserName(), umUsers.getPassword(), null, true, null);
            auth = new UsernamePasswordAuthenticationToken(appUser, password, grantedAuths);
            return auth;
        } else {
            return null;
        }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException { // TODO Auto-generated method stub return new
	 * User("roshan", "roshan", new ArrayList<>()); }
	 */
	
}
