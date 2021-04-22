package com.stocks.site.service;

import com.stocks.site.model.User;
import com.stocks.site.model.UserWithRoles;
import com.stocks.site.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {

    private final UserRepo userDao;

    public UserDetailsLoader(UserRepo userDao){
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("find a user with UN : " + username);
        User user = userDao.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("No user found with username " + username);
        }
        // would like to do this in the post mapping for login but not sure about that with spring security
        if( user.getIsAuthenticated() == 0 ) {
            System.out.println( user.getUsername() + " user is not authenticated yet");
            throw new UsernameNotFoundException("User " + username + " is not authenticated yet");
        }
        return new UserWithRoles(user); // the enhanced UserDetails copy user
    }
}