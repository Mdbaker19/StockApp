package com.stocks.site.util;

import com.stocks.site.model.Account;
import com.stocks.site.model.User;
import com.stocks.site.repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.util.Date;

public class Maker {

    public static void makeUser(UserRepo userDao, PasswordEncoder encoder, Account account, User user){
        String accountAuthCode = Password.randomRegisterCode();
        user.setIsAuthenticated(0);
        user.setUserAccount(account);
        user.setIsAdmin(0);
        user.setAuthCode(accountAuthCode);

        user.setJoinedAt(new Timestamp(new Date().getTime()));
        user.setPassword(encoder.encode(user.getPassword()));
        user.setProfileImage("https://g.foolcdn.com/editorial/images/618711/arrow-angles-up-on-a-green-stock-chart.jpg");

        userDao.save(user);
    }

}
