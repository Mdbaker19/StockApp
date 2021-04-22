package com.stocks.site.controllers;

import com.stocks.site.model.User;
import com.stocks.site.repository.AccountRepo;
import com.stocks.site.repository.StockRepo;
import com.stocks.site.repository.UserRepo;
import com.stocks.site.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private final UserRepo userDao;
    private final AccountRepo accountDao;
    private final UserService userService;
    private final StockRepo stockDao;

    public UserController(UserRepo userDao, StockRepo stockDao, AccountRepo accountDao, UserService userService){
        this.userDao = userDao;
        this.stockDao = stockDao;
        this.accountDao = accountDao;
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String profilePage(HttpSession session){
        User user = userService.getLoggedInUser();
        session.setAttribute("user", user);
        return "users/profile";
    }

}
