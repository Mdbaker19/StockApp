package com.stocks.site.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ledger")
public class Ledger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) unsigned")
    private long id;

    @Column(nullable = false)
    private String record; // parse this later to get price points and use this to create value totals
    // ticker, quantity, price, by who

    @ManyToMany(mappedBy = "userLedger")
    private List<User> userList;


    public Ledger() {
    }

    public Ledger(long id, String record, List<User> userList) {
        this.id = id;
        this.record = record;
        this.userList = userList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}

