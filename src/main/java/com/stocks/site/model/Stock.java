package com.stocks.site.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) unsigned")
    private long id;

    @Column(nullable = false)
    private String ticker;

    @Column(nullable = false)
    private double currentValue;

    @Column(nullable = false)
    private double dayHigh;

    @Column(nullable = false)
    private double dayLow;

    @Column(nullable = false)
    private long dayVolume;

    @ManyToMany(mappedBy = "userStocks")
    private List<User> userList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<Values> stockValues;

    public Stock() {
    }

    public Stock(long id, String ticker, double currentValue, double dayHigh, double dayLow, long dayVolume, List<User> userList, List<Values> stockValues) {
        this.id = id;
        this.ticker = ticker;
        this.stockValues = stockValues;
        this.currentValue = currentValue;
        this.dayHigh = dayHigh;
        this.dayLow = dayLow;
        this.dayVolume = dayVolume;
        this.userList = userList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public List<Values> getStockValues() {
        return stockValues;
    }

    public void setStockValues(List<Values> stockValues) {
        this.stockValues = stockValues;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public double getHigh() {
        return dayHigh;
    }

    public void setHigh(double dayHigh) {
        this.dayHigh = dayHigh;
    }

    public double getLow() {
        return dayLow;
    }

    public void setLow(double dayLow) {
        this.dayLow = dayLow;
    }

    public long getVolume() {
        return dayVolume;
    }

    public void setVolume(long dayVolume) {
        this.dayVolume = dayVolume;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
