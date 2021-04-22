package com.stocks.site.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) unsigned")
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "text")
    private String profileImage;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private int isAdmin;

    @Column(columnDefinition = "TINYINT")
    private int isAuthenticated;

    @Column
    private String authCode;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_stocks",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "stock_id")})
    private List<Stock> userStocks = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_ledger",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "ledger_id")})
    private List<Ledger> userLedger = new ArrayList<>();

    @OneToOne
    private Account userAccount;


    public User(){}

    public User(User copy){
        this.id = copy.id;
        this.username = copy.username;
        this.email = copy.email;
        this.password = copy.password;
        this.profileImage = copy.profileImage;
        this.isAdmin = copy.isAdmin;
        this.isAuthenticated = copy.isAuthenticated;
        this.authCode = copy.authCode;
        this.userStocks = copy.userStocks;
        this.userAccount = copy.userAccount;
        this.userLedger = copy.userLedger;
    }


    public User(long id, String username, String email, String password, String profileImage, int isAdmin, int isAuthenticated, String authCode, List<Stock> userStocks, List<Ledger> userLedger, Account userAccount) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profileImage = profileImage;
        this.isAdmin = isAdmin;
        this.isAuthenticated = isAuthenticated;
        this.authCode = authCode;
        this.userStocks = userStocks;
        this.userLedger = userLedger;
        this.userAccount = userAccount;
    }

    public List<Ledger> getUserLedger() {
        return userLedger;
    }

    public void setUserLedger(List<Ledger> userLedger) {
        this.userLedger = userLedger;
    }

    public List<Stock> getUserStocks() {
        return userStocks;
    }

    public void setUserStocks(List<Stock> userStocks) {
        this.userStocks = userStocks;
    }

    public Account getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Account userAccount) {
        this.userAccount = userAccount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getIsAuthenticated() {
        return isAuthenticated;
    }

    public void setIsAuthenticated(int isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }


}