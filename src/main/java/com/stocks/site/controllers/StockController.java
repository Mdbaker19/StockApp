package com.stocks.site.controllers;

import com.stocks.site.model.Stock;
import com.stocks.site.model.Values;
import com.stocks.site.repository.AccountRepo;
import com.stocks.site.repository.StockRepo;
import com.stocks.site.repository.UserRepo;
import com.stocks.site.repository.ValuesRepo;
import com.stocks.site.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Controller
public class StockController {


    private final UserRepo userDao;
    private final AccountRepo accountDao;
    private final UserService userService;
    private final StockRepo stockDao;
    private final ValuesRepo valueDao;

    public StockController(UserRepo userDao, StockRepo stockDao, AccountRepo accountDao, UserService userService, ValuesRepo valueDao){
        this.userDao = userDao;
        this.valueDao = valueDao;
        this.stockDao = stockDao;
        this.accountDao = accountDao;
        this.userService = userService;
    }

    @GetMapping("/trade")
    public String stockTrading(){
        return "stocks/trade";
    }


//    @GetMapping("/seed")
//    public String seedDB(){
//        init();
//        return "redirect:/";
//    }
//
//
//    private void init() {
//        try {
//            File myObj = new File("data.txt");
//            Scanner myReader = new Scanner(myObj);
//            parseReader(myReader, "TSLA");
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }
//    // time, open, high, low, close, vol
//    private void parseReader(Scanner reader, String ticker){
//        List<List<String>> dataList = new ArrayList<>();
//        int count = 0;
//        while(reader.hasNextLine()) {
//            count++;
//            if(count % 2 == 0) continue;
//            String data = reader.nextLine();
//            String subed = data.substring(1);
//            dataList.add(Arrays.asList(subed.split(",")));
//        }
//        List<List<String>> filtered = dataList.stream().filter(e -> e.size() > 1).collect(Collectors.toList());
//        System.out.println(filtered);
//        Stock stock = createStock(ticker);
//        // value string in stock_values is the open
//        for(int i = filtered.size() - 1; i >= 0; i--) {
//            List<String> daySlotInfo = filtered.get(i);
//            for(int j = 0; j < daySlotInfo.size(); j++) {
//                System.out.println(daySlotInfo.get(j));
//                Values value = new Values();
//                value.setValueAtTime();
//                value.setTimeId();
//                value.setStock(stock);
//                valueDao.save(value);
//            }
//        }
//        // time id is the date and time together as a num
//    }
//
//    private  Stock createStock(String ticker) {
//        Stock stock = new Stock();
//        stock.setTicker(ticker);
//        stockDao.save(stock);
//        return stock;
//    }

}
