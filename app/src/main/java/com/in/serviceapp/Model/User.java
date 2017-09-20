package com.in.serviceapp.Model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sahil on 18/9/17.
 */

@IgnoreExtraProperties
public class User {

    public String username;
    public String userid;
    public String address;
    public String mobile;
    public String email;
    public long wallet;

    public User users;
    public int break_days=0,lunch_days=0,dinner_days=0;

    public User(){}
    public User(String username, String userid, String useremail,String address, String mobile,long wallet) {
        this.userid = userid;
        this.username = username;
        this.address = address;
        this.mobile = mobile;
        this.wallet = wallet;
        this.email =useremail;
        this.break_days = 0;
        this.lunch_days = 0;
        this.dinner_days = 0;
    }



    public User(User user)
    {
        this.users =user;


    }


    public User(String username, String userid, String address, String mobile) {
        this.userid = userid;
        this.username = username;
        this.address = address;
        this.mobile = mobile;
    }

    public User(String userid,long wallet){
        this.userid = userid;
        this.wallet = wallet;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", userid);
        result.put("username", username);
        result.put("useremail",email);
        result.put("address", address);
        result.put("mobile", String.valueOf(mobile));
        result.put("wallet", String.valueOf(wallet));
        return result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getWallet() {
        return wallet;
    }

    public void setWallet(long wallet) {
        this.wallet = wallet;
    }



}