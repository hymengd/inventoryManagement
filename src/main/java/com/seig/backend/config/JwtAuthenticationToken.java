package com.seig.backend.config;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class JwtAuthenticationToken implements Authentication {
    
    private final String username;
    private final Claims claims;
    private boolean authenticated;
    
    public JwtAuthenticationToken(String username, Claims claims) {
        this.username = username;
        this.claims = claims;
        this.authenticated = true;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }
    
    @Override
    public Object getCredentials() {
        return null;
    }
    
    @Override
    public Object getDetails() {
        return claims;
    }
    
    @Override
    public Object getPrincipal() {
        return username;
    }
    
    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }
    
    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }
    
    @Override
    public String getName() {
        return username;
    }
}
