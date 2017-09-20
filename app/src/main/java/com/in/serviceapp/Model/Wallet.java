package com.in.serviceapp.Model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by root on 18/9/17.
 */
@IgnoreExtraProperties
public class Wallet {
        public long amount;
        public String userid;

    public Wallet() {
        //Default Constructor

    }
    public Wallet(String userid,long wallet){
    this.amount = wallet;
    this.userid = userid;

    }
}
