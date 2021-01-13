package com.example.demo.configuration;

import java.io.IOException;
import java.util.Date;

import javax.naming.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtAuthentificationFilter extends UsernamePasswordAuthenticationFilter {
	 @Autowired
	    private UserRepository userRepository;

	    private AuthenticationManager authenticationManager;

	    public JwtAuthentificationFilter(AuthenticationManager authenticationManager) {
	        this.authenticationManager = authenticationManager;
	    }

	    @Override
	    public org.springframework.security.core.Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
	        User user=null;
	        try {
	            user=new ObjectMapper().readValue(request.getInputStream(),User.class);
	          
	        } catch (Exception e) {
	           throw new RuntimeException(e);
	        }
	        return authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword())
	        );
	    }


	    @Override
	    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, org.springframework.security.core.Authentication authResult) throws IOException, ServletException {
	        org.springframework.security.core.userdetails.User springUser= (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
	        String jwt= Jwts.builder()
	                .setSubject(springUser.getUsername())
	                .signWith(SignatureAlgorithm.HS512,SecurityConstants.SECRET)
	                .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
	                .claim("role",springUser.getAuthorities())
	                .compact();
	        response.addHeader(SecurityConstants.HEADER_STRING,SecurityConstants.TOKEN_PREFIX+jwt);
	    }
}
