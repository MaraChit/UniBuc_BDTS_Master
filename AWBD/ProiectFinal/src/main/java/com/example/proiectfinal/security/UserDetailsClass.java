package com.example.proiectfinal.security;

import com.example.proiectfinal.model.UserType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsClass implements UserDetails {

    private UserType userType;

    public UserDetailsClass(UserType _userType)
    {
        userType = _userType;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userType.getPassword();
    }

    @Override
    public String getUsername() {
        return userType.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName()
    {
        return userType.getName() + " " + userType.getLastName();
    }
}
