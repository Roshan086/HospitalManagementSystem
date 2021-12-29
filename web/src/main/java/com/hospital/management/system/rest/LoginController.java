package com.hospital.management.system.rest;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.system.dto.AuthenticatedUser;
import com.hospital.management.system.dto.StatusDTO;
import com.hospital.management.system.model.AuthenticationRequest;
import com.hospital.management.system.model.EmployeeModel;
import com.hospital.management.system.services.EmployeeServices;
import com.hospital.management.system.services.Jwtutil;
import com.hospital.management.system.services.UserAuthenticationProvider;




@RestController
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserAuthenticationProvider userAuthenticationProvider;
	@Autowired
	private Jwtutil jwtTokenUtil;
	@Autowired
	private EmployeeServices employeeServices;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST )
	public ResponseEntity<?> createAuthenticationToken(@ModelAttribute AuthenticationRequest jwtAuthenticationRequest)throws Exception {
		AuthenticatedUser authenticatedUser;
        if(jwtAuthenticationRequest.getUserName()!=null && !jwtAuthenticationRequest.getUserName().isEmpty() && jwtAuthenticationRequest.getPassword()!=null && !jwtAuthenticationRequest.getPassword().isEmpty()){
            EmployeeModel user = employeeServices.findByUserName(jwtAuthenticationRequest.getUserName());
            if(user == null){
                return new ResponseEntity<>(new StatusDTO(0, "Incorrect User Name or Password" ), HttpStatus.NOT_FOUND);
            }else{
                final Authentication authentication = userAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(
                        jwtAuthenticationRequest.getUserName(),
                        jwtAuthenticationRequest.getPassword()
                ));
                if (authentication != null) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    authenticatedUser = getAuthenticatedUser(user, jwtTokenUtil);
                    return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
                }else{
                    return new ResponseEntity<>(new StatusDTO(0, "Incorrect User Name or Password" ), HttpStatus.NOT_FOUND);
                }
            }
        }

        return new ResponseEntity<>("Incorrect", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	private AuthenticatedUser getAuthenticatedUser(EmployeeModel user, Jwtutil jwtTokenUtil) {
        AuthenticatedUser authenticatedUser = new AuthenticatedUser();
        Set<String> permissionList = new HashSet<>();

        authenticatedUser.setCode(1);
        authenticatedUser.setStatus(1);

        if (user.getUserName() != null) {
            authenticatedUser.setUserName(user.getUserName());
        }
        final String token = jwtTokenUtil.generateToken(user);
        authenticatedUser.setMessage("Success");
        authenticatedUser.setToken(token);
        authenticatedUser.setUserId(user.getId());
        return authenticatedUser;
    }
}
