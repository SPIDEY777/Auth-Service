package com.example.auth.service;

import com.example.auth.entities.UserInfo;
import com.example.auth.entities.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CustomUserDetails extends UserInfo implements UserDetails {

    private String username;

    private String password;

    Collection<GrantedAuthority> authorities;

public CustomUserDetails(UserInfo byUsername){
    this.username = byUsername.getUsername();
    this.password = byUsername.getPassword();
    List<GrantedAuthority> auths= new ArrayList<>();
    for(UserRole role : byUsername.getRoles()){
        auths.add(new SimpleGrantedAuthority(role.getRoleName().toUpperCase()));
    }
    this.authorities = auths;
}

     @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
         return authorities;
     }
    @Override
    public String getUsername() {
       return username;
    }

    @Override
    public String getPassword() {
       return password;
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }
}
