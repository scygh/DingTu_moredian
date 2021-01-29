package com.moredian.entrance.guard.entity;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2021/1/27 15:17
 */
public class PostRechargeReq {

    /**
     * Amount : 0
     * Donate : 0
     * Pattern : 1
     * PayCount : 0
     * PayKey : string
     * Number : 0
     */

    private double Amount;
    private double Donate;
    private int Pattern;
    private int PayCount;
    private String PayKey;
    private int Number;

    public PostRechargeReq(double amount, double donate, int pattern, int payCount, String payKey, int number) {
        Amount = amount;
        Donate = donate;
        Pattern = pattern;
        PayCount = payCount;
        PayKey = payKey;
        Number = number;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public double getDonate() {
        return Donate;
    }

    public void setDonate(double Donate) {
        this.Donate = Donate;
    }

    public int getPattern() {
        return Pattern;
    }

    public void setPattern(int Pattern) {
        this.Pattern = Pattern;
    }

    public int getPayCount() {
        return PayCount;
    }

    public void setPayCount(int PayCount) {
        this.PayCount = PayCount;
    }

    public String getPayKey() {
        return PayKey;
    }

    public void setPayKey(String PayKey) {
        this.PayKey = PayKey;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }
}
