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

    @ManyToMany(mappedBy = "userStocks")
    private List<User> userList;

    @Column(nullable = false)
    private double price;

    public Stock() {
    }

    public Stock(long id, String ticker, double price, List<User> userList) {
        this.id = id;
        this.price = price;
        this.ticker = ticker;
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
