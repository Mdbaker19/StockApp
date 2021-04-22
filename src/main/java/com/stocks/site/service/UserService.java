package com.stocks.site.service;

import com.stocks.site.model.User;
import com.stocks.site.repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Security;

@Service
public class UserService {
    private final UserRepo usersDao;

    public UserService(UserRepo usersDao){this.usersDao = usersDao;}

    public User getLoggedInUser(){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return usersDao.findById(loggedInUser.getId()).get();
    }
}