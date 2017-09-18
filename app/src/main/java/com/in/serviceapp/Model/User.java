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
    private String username;
    private String userid;
    private String address;
    private long mobile;
    private long wallet;

    public User(){}
    public User(String username, String userid, String address, long mobile,long wallet) {
        this.userid = userid;
        this.username = username;
        this.address = address;
        this.mobile = mobile;
        this.wallet = wallet;
    }

    public User(String username, String userid, String address, long mobile) {
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
        result.put("address", address);
        result.put("mobile", String.valueOf(mobile));
        result.put("wallet", String.valueOf(wallet));
        return result;
    }


}