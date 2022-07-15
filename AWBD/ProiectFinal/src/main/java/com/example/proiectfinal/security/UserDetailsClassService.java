package com.example.proiectfinal.security;

import com.example.proiectfinal.model.UserType;
import com.example.proiectfinal.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsClassService implements UserDetailsService {

    @Autowired
    private UserTypeRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserType userType = repo.findByEmail(username);
        if (userType == null) {
            throw new UsernameNotFoundException("Sorry! This user could not be found");
        }
        return new UserDetailsClass(userType);
    }
}
