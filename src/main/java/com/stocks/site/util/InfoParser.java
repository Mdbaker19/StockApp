package com.stocks.site.util;

import com.stocks.site.model.Stock;
import com.stocks.site.model.Values;
import com.stocks.site.repository.StockRepo;
import com.stocks.site.repository.ValuesRepo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InfoParser {

    private final StockRepo stockDao;
    private final ValuesRepo valueDao;

    public InfoParser(StockRepo stockDao, ValuesRepo valueDao){
        this.valueDao = valueDao;
        this.stockDao = stockDao;
    }

    public void main(String[] args) {
        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            parseReader(myReader, "TSLA");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
// time, open, high, low, close, vol
    private void parseReader(Scanner reader, String ticker){
        List<List<String>> dataList = new ArrayList<>();
        int count = 0;
        while(reader.hasNextLine()) {
            count++;
            if(count % 2 == 0) continue;
            String data = reader.nextLine();
            String subed = data.substring(1);
            dataList.add(Arrays.asList(subed.split(",")));
        }
        List<List<String>> filtered = dataList.stream().filter(e -> e.size() > 1).collect(Collectors.toList());
        System.out.println(filtered);
        Stock stock = createStock(filtered, ticker);
        // value string in stock_values is the open
        for(int i = filtered.size() - 1; i >= 0; i--) {
            List<String> daySlotInfo = filtered.get(i);
            for(int j = 0; j < daySlotInfo.size(); j++) {
                Values value = new Values();
                value.setValueAtTime();
                value.setTimeId();
                value.setStock(stock);
                valueDao.save(value);
            }
        }
        // time id is the date and time together as a num
    }

    private Stock createStock(List<List<String>> dataList, String ticker) {

    }

}
