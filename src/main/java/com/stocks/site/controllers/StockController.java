package com.stocks.site.controllers;

import com.stocks.site.repository.AccountRepo;
import com.stocks.site.repository.StockRepo;
import com.stocks.site.repository.UserRepo;
import com.stocks.site.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {


    private final UserRepo userDao;
    private final AccountRepo accountDao;
    private final UserService userService;
    private final StockRepo stockDao;

    public StockController(UserRepo userDao, StockRepo stockDao, AccountRepo accountDao, UserService userService){
        this.userDao = userDao;
        this.stockDao = stockDao;
        this.accountDao = accountDao;
        this.userService = userService;
    }

    @GetMapping("/trade")
    public String stockTrading(){
        return "stocks/trade";
    }

}
