package com.stocks.site.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    public static String randomGen(){
        StringBuilder out = new StringBuilder();
        List<String> specials = new ArrayList<>(Arrays.asList("!", "#", "$", "%", "*"));
        while(out.length() < 16){
            int ran = (int) Math.floor(Math.random() * 10);
            if(ran < 5){
                out.append(specials.get(ran));
            }
            out.append(RandomStringUtils.randomAlphabetic(1));
            out.append(RandomStringUtils.randomAlphanumeric(1));
        }
        return out.toString();
    }

    public static String randomRegisterCode(){
        StringBuilder out = new StringBuilder();
        while(out.length() < 8){
            out.append(RandomStringUtils.randomAlphabetic(1));
            out.append(RandomStringUtils.randomAlphanumeric(1));
        }
        return out.toString();
    }

    public static boolean goodQualityPassword(String passwordAttempt){
        int len = passwordAttempt.length();

        if(len < 8) return false;

        Pattern upper = Pattern.compile("\\p{Upper}");
        Pattern lower = Pattern.compile("\\p{Lower}");
        Pattern digit = Pattern.compile("\\d");

        Matcher matcherUp = upper.matcher(passwordAttempt);
        Matcher matcherLow = lower.matcher(passwordAttempt);
        Matcher matcherNum = digit.matcher(passwordAttempt);

        return matcherUp.find()
                && matcherLow.find()
                && matcherNum.find();
    }

}