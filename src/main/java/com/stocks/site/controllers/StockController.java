package com.stocks.site.controllers;

import com.stocks.site.model.Stock;
import com.stocks.site.model.User;
import com.stocks.site.repository.AccountRepo;
import com.stocks.site.repository.StockRepo;
import com.stocks.site.repository.UserRepo;
import com.stocks.site.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public String viewAllStocksPage(Model model) {
        List<Stock> stockList = stockDao.findAll();
        model.addAttribute("stockList", stockList);
        return "stocks/trade";
    }

    @GetMapping("/trade/{id}")
    public String viewAllStocksPage(Model model, @PathVariable(name = "id") long id) {
        Stock stock = stockDao.getOne(id);
        model.addAttribute("stock", stock);
        return "stocks/view";
    }

    @PostMapping("/trade-stock/{id}")
    public String tradeStock(@PathVariable(name = "id") long id, @RequestParam(name = "group1", required = false) String checkbox, @RequestParam(name = "amount") int amount) {
        System.out.println("Stock trade happened");
        System.out.println(amount);
        if(checkbox != null) {
            // selling stock, check if you have that many
        }
        return "redirect:/trade/" + id;
    }
}
