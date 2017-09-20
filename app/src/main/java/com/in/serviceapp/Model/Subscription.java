package com.in.serviceapp.Model;

/**
 * Created by root on 20/9/17.
 */

public class Subscription {


    public int getBdays() {
        return bdays;
    }

    public void setBdays(int bdays) {
        this.bdays = bdays;
    }

    public int getLdays() {
        return ldays;
    }

    public void setLdays(int ldays) {
        this.ldays = ldays;
    }

    public int getDdays() {
        return ddays;
    }

    public void setDdays(int ddays) {
        this.ddays = ddays;
    }

    public int bdays,ldays,ddays;


    public Subscription(int bdays, int ldays, int ddays){
            this.bdays = bdays;
            this.ddays = ddays;
            this.ldays = ldays;

    }
    public Subscription(){}












}
