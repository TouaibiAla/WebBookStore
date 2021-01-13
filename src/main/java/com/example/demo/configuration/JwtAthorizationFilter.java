package com.example.demo.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtAthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-RequestHeaders,authorization");
        response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else {
            try {
            String jwt=request.getHeader(SecurityConstants.HEADER_STRING);
            if(jwt==null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)){
                filterChain.doFilter(request,response);return ;
            }
            Claims claims= Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET)
                    .parseClaimsJws(jwt.replace(SecurityConstants.TOKEN_PREFIX,""))
                    .getBody();
            String username=claims.getSubject();
            ArrayList<Map<String, String>> role=(ArrayList<Map<String, String>>) claims.get("role");
            Collection<GrantedAuthority> authoritie=new ArrayList<>();
            role.forEach(r->{
                authoritie.add(new SimpleGrantedAuthority(r.get("authority")));
            });
            UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,null,authoritie);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                filterChain.doFilter(request,response);
            }
            catch(Exception e ){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            	
            }
        }
		
	}

}
