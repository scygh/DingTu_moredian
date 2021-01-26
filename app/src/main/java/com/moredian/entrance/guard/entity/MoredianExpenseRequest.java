package com.moredian.entrance.guard.entity;

import java.util.List;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2021/1/25 10:20
 */
public class MoredianExpenseRequest {

    /**
     * Amount : 0
     * Pattern : 1
     * PayCount : 0
     * PayKey : string
     * GoodsDetails : [{"Id":"string","Eid":"string","GoodsNo":0,"OrderNo":0,"GoodsName":"string","Price":0,"Amount":0,"Count":0,"CreateTime":"2021-01-25T02:17:08.111Z"}]
     * MemberId : string
     */

    private double Amount;
    private int Pattern;
    private int PayCount;
    private String PayKey;
    private String MemberId;
    private List<GoodsDetailsBean> GoodsDetails;

    public MoredianExpenseRequest(double amount, int pattern, int payCount, String payKey, String memberId) {
        Amount = amount;
        Pattern = pattern;
        PayCount = payCount;
        PayKey = payKey;
        MemberId = memberId;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
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

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String MemberId) {
        this.MemberId = MemberId;
    }

    public List<GoodsDetailsBean> getGoodsDetails() {
        return GoodsDetails;
    }

    public void setGoodsDetails(List<GoodsDetailsBean> GoodsDetails) {
        this.GoodsDetails = GoodsDetails;
    }

    public static class GoodsDetailsBean {
        /**
         * Id : string
         * Eid : string
         * GoodsNo : 0
         * OrderNo : 0
         * GoodsName : string
         * Price : 0
         * Amount : 0
         * Count : 0
         * CreateTime : 2021-01-25T02:17:08.111Z
         */

        private String Id;
        private String Eid;
        private int GoodsNo;
        private int OrderNo;
        private String GoodsName;
        private double Price;
        private double Amount;
        private int Count;
        private String CreateTime;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getEid() {
            return Eid;
        }

        public void setEid(String Eid) {
            this.Eid = Eid;
        }

        public int getGoodsNo() {
            return GoodsNo;
        }

        public void setGoodsNo(int GoodsNo) {
            this.GoodsNo = GoodsNo;
        }

        public int getOrderNo() {
            return OrderNo;
        }

        public void setOrderNo(int OrderNo) {
            this.OrderNo = OrderNo;
        }

        public String getGoodsName() {
            return GoodsName;
        }

        public void setGoodsName(String GoodsName) {
            this.GoodsName = GoodsName;
        }

        public double getPrice() {
            return Price;
        }

        public void setPrice(double Price) {
            this.Price = Price;
        }

        public double getAmount() {
            return Amount;
        }

        public void setAmount(double Amount) {
            this.Amount = Amount;
        }

        public int getCount() {
            return Count;
        }

        public void setCount(int Count) {
            this.Count = Count;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }
    }
}
