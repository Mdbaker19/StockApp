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
    private double currentValue;

    @Column(nullable = false)
    private double high;

    @Column(nullable = false)
    private double low;

    @Column(nullable = false)
    private long volume;

    @ManyToMany(mappedBy = "userStocks")
    private List<User> userList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<Values> stockValues;

    public Stock() {
    }

    public Stock(long id, double currentValue, double high, double low, long volume, List<User> userList, List<Values> stockValues) {
        this.id = id;
        this.stockValues = stockValues;
        this.currentValue = currentValue;
        this.high = high;
        this.low = low;
        this.volume = volume;
        this.userList = userList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
