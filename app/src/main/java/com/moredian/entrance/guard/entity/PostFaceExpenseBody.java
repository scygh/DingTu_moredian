package com.moredian.entrance.guard.entity;

import java.util.List;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2019/8/13 15:29
 */
public class PostFaceExpenseBody {


    /**
     * Number : 0
     * Amount : 0
     * PayCount : 0
     * PayKey : string
     * DeviceID : 0
     * ExpenseWay : 0
     * ListGoods : [{"GoodsNo":0,"Count":0}]
     * MemberId : string
     */

    private int Number;
    private int Pattern;
    private double Amount;
    private int PayCount;
    private String PayKey;
    private int DeviceID;
    private int ExpenseWay;
    private String MemberId;
    private List<ListGoodsBean> ListGoods;

    public PostFaceExpenseBody(int pattern, double amount, String payKey, int deviceID, int expenseWay, String memberId) {
        Pattern = pattern;
        Amount = amount;
        PayKey = payKey;
        DeviceID = deviceID;
        ExpenseWay = expenseWay;
        MemberId = memberId;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
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

    public int getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(int DeviceID) {
        this.DeviceID = DeviceID;
    }

    public int getExpenseWay() {
        return ExpenseWay;
    }

    public void setExpenseWay(int ExpenseWay) {
        this.ExpenseWay = ExpenseWay;
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String MemberId) {
        this.MemberId = MemberId;
    }

    public List<ListGoodsBean> getListGoods() {
        return ListGoods;
    }

    public void setListGoods(List<ListGoodsBean> ListGoods) {
        this.ListGoods = ListGoods;
    }

    public static class ListGoodsBean {
        /**
         * GoodsNo : 0
         * Count : 0
         */

        private int GoodsNo;
        private int Count;

        public int getGoodsNo() {
            return GoodsNo;
        }

        public void setGoodsNo(int GoodsNo) {
            this.GoodsNo = GoodsNo;
        }

        public int getCount() {
            return Count;
        }

        public void setCount(int Count) {
            this.Count = Count;
        }
    }
}
