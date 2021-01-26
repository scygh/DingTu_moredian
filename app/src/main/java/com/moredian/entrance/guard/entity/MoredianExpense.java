package com.moredian.entrance.guard.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2021/1/25 10:18
 */
public class MoredianExpense {


    /**
     * Content : {"ExpenseDetail":{"Id":"string","UserId":"string","Number":0,"DeviceType":0,"DeviceId":0,"Pattern":1,"DetailType":0,"PayCount":0,"Finance":0,"OriginalAmount":0,"Amount":0,"Balance":0,"IsDiscount":true,"DiscountRate":0,"TradeDateTime":"2021-01-25T02:17:16.515Z","CreateTime":"2021-01-25T02:17:16.515Z","Description":"string","OfflinePayCount":0},"GoodsDetails":[{"Id":"string","Eid":"string","GoodsNo":0,"OrderNo":0,"GoodsName":"string","Price":0,"Amount":0,"Count":0,"CreateTime":"2021-01-25T02:17:16.515Z"}],"State":0}
     * Message : string
     * Result : true
     * StatusCode : 100
     * IsOk : true
     */

    private ContentBean Content;
    private String Message;
    private boolean Result;
    private int StatusCode;
    private boolean IsOk;

    public ContentBean getContent() {
        return Content;
    }

    public void setContent(ContentBean Content) {
        this.Content = Content;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public boolean isResult() {
        return Result;
    }

    public void setResult(boolean Result) {
        this.Result = Result;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public boolean isIsOk() {
        return IsOk;
    }

    public void setIsOk(boolean IsOk) {
        this.IsOk = IsOk;
    }

    public static class ContentBean implements Parcelable {
        /**
         * ExpenseDetail : {"Id":"string","UserId":"string","Number":0,"DeviceType":0,"DeviceId":0,"Pattern":1,"DetailType":0,"PayCount":0,"Finance":0,"OriginalAmount":0,"Amount":0,"Balance":0,"IsDiscount":true,"DiscountRate":0,"TradeDateTime":"2021-01-25T02:17:16.515Z","CreateTime":"2021-01-25T02:17:16.515Z","Description":"string","OfflinePayCount":0}
         * GoodsDetails : [{"Id":"string","Eid":"string","GoodsNo":0,"OrderNo":0,"GoodsName":"string","Price":0,"Amount":0,"Count":0,"CreateTime":"2021-01-25T02:17:16.515Z"}]
         * State : 0
         */


        private ExpenseDetailBean ExpenseDetail;
        private int State;
        private List<GoodsDetailsBean> GoodsDetails;

        public ExpenseDetailBean getExpenseDetail() {
            return ExpenseDetail;
        }

        public void setExpenseDetail(ExpenseDetailBean ExpenseDetail) {
            this.ExpenseDetail = ExpenseDetail;
        }

        public int getState() {
            return State;
        }

        public void setState(int State) {
            this.State = State;
        }

        public List<GoodsDetailsBean> getGoodsDetails() {
            return GoodsDetails;
        }

        public void setGoodsDetails(List<GoodsDetailsBean> GoodsDetails) {
            this.GoodsDetails = GoodsDetails;
        }

        public static class ExpenseDetailBean implements Parcelable {
            /**
             * Id : string
             * UserId : string
             * Number : 0
             * DeviceType : 0
             * DeviceId : 0
             * Pattern : 1
             * DetailType : 0
             * PayCount : 0
             * Finance : 0
             * OriginalAmount : 0
             * Amount : 0
             * Balance : 0
             * IsDiscount : true
             * DiscountRate : 0
             * TradeDateTime : 2021-01-25T02:17:16.515Z
             * CreateTime : 2021-01-25T02:17:16.515Z
             * Description : string
             * OfflinePayCount : 0
             */


            private String Id;
            private String UserId;
            private int Number;
            private int DeviceType;
            private int DeviceId;
            private int Pattern;
            private int DetailType;
            private int PayCount;
            private int Finance;
            private double OriginalAmount;
            private double Amount;
            private double Balance;
            private boolean IsDiscount;
            private int DiscountRate;
            private String TradeDateTime;
            private String CreateTime;
            private String Description;
            private int OfflinePayCount;

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getUserId() {
                return UserId;
            }

            public void setUserId(String UserId) {
                this.UserId = UserId;
            }

            public int getNumber() {
                return Number;
            }

            public void setNumber(int Number) {
                this.Number = Number;
            }

            public int getDeviceType() {
                return DeviceType;
            }

            public void setDeviceType(int DeviceType) {
                this.DeviceType = DeviceType;
            }

            public int getDeviceId() {
                return DeviceId;
            }

            public void setDeviceId(int DeviceId) {
                this.DeviceId = DeviceId;
            }

            public int getPattern() {
                return Pattern;
            }

            public void setPattern(int Pattern) {
                this.Pattern = Pattern;
            }

            public int getDetailType() {
                return DetailType;
            }

            public void setDetailType(int DetailType) {
                this.DetailType = DetailType;
            }

            public int getPayCount() {
                return PayCount;
            }

            public void setPayCount(int PayCount) {
                this.PayCount = PayCount;
            }

            public int getFinance() {
                return Finance;
            }

            public void setFinance(int Finance) {
                this.Finance = Finance;
            }

            public double getOriginalAmount() {
                return OriginalAmount;
            }

            public void setOriginalAmount(double OriginalAmount) {
                this.OriginalAmount = OriginalAmount;
            }

            public double getAmount() {
                return Amount;
            }

            public void setAmount(double Amount) {
                this.Amount = Amount;
            }

            public double getBalance() {
                return Balance;
            }

            public void setBalance(double Balance) {
                this.Balance = Balance;
            }

            public boolean isIsDiscount() {
                return IsDiscount;
            }

            public void setIsDiscount(boolean IsDiscount) {
                this.IsDiscount = IsDiscount;
            }

            public int getDiscountRate() {
                return DiscountRate;
            }

            public void setDiscountRate(int DiscountRate) {
                this.DiscountRate = DiscountRate;
            }

            public String getTradeDateTime() {
                return TradeDateTime;
            }

            public void setTradeDateTime(String TradeDateTime) {
                this.TradeDateTime = TradeDateTime;
            }

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getDescription() {
                return Description;
            }

            public void setDescription(String Description) {
                this.Description = Description;
            }

            public int getOfflinePayCount() {
                return OfflinePayCount;
            }

            public void setOfflinePayCount(int OfflinePayCount) {
                this.OfflinePayCount = OfflinePayCount;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.Id);
                dest.writeString(this.UserId);
                dest.writeInt(this.Number);
                dest.writeInt(this.DeviceType);
                dest.writeInt(this.DeviceId);
                dest.writeInt(this.Pattern);
                dest.writeInt(this.DetailType);
                dest.writeInt(this.PayCount);
                dest.writeInt(this.Finance);
                dest.writeDouble(this.OriginalAmount);
                dest.writeDouble(this.Amount);
                dest.writeDouble(this.Balance);
                dest.writeByte(this.IsDiscount ? (byte) 1 : (byte) 0);
                dest.writeInt(this.DiscountRate);
                dest.writeString(this.TradeDateTime);
                dest.writeString(this.CreateTime);
                dest.writeString(this.Description);
                dest.writeInt(this.OfflinePayCount);
            }

            public ExpenseDetailBean() {
            }

            protected ExpenseDetailBean(Parcel in) {
                this.Id = in.readString();
                this.UserId = in.readString();
                this.Number = in.readInt();
                this.DeviceType = in.readInt();
                this.DeviceId = in.readInt();
                this.Pattern = in.readInt();
                this.DetailType = in.readInt();
                this.PayCount = in.readInt();
                this.Finance = in.readInt();
                this.OriginalAmount = in.readDouble();
                this.Amount = in.readDouble();
                this.Balance = in.readDouble();
                this.IsDiscount = in.readByte() != 0;
                this.DiscountRate = in.readInt();
                this.TradeDateTime = in.readString();
                this.CreateTime = in.readString();
                this.Description = in.readString();
                this.OfflinePayCount = in.readInt();
            }

            public static final Creator<ExpenseDetailBean> CREATOR = new Creator<ExpenseDetailBean>() {
                @Override
                public ExpenseDetailBean createFromParcel(Parcel source) {
                    return new ExpenseDetailBean(source);
                }

                @Override
                public ExpenseDetailBean[] newArray(int size) {
                    return new ExpenseDetailBean[size];
                }
            };
        }

        public static class GoodsDetailsBean implements Parcelable {
            /**
             * Id : string
             * Eid : string
             * GoodsNo : 0
             * OrderNo : 0
             * GoodsName : string
             * Price : 0
             * Amount : 0
             * Count : 0
             * CreateTime : 2021-01-25T02:17:16.515Z
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.Id);
                dest.writeString(this.Eid);
                dest.writeInt(this.GoodsNo);
                dest.writeInt(this.OrderNo);
                dest.writeString(this.GoodsName);
                dest.writeDouble(this.Price);
                dest.writeDouble(this.Amount);
                dest.writeInt(this.Count);
                dest.writeString(this.CreateTime);
            }

            public GoodsDetailsBean() {
            }

            protected GoodsDetailsBean(Parcel in) {
                this.Id = in.readString();
                this.Eid = in.readString();
                this.GoodsNo = in.readInt();
                this.OrderNo = in.readInt();
                this.GoodsName = in.readString();
                this.Price = in.readDouble();
                this.Amount = in.readDouble();
                this.Count = in.readInt();
                this.CreateTime = in.readString();
            }

            public static final Creator<GoodsDetailsBean> CREATOR = new Creator<GoodsDetailsBean>() {
                @Override
                public GoodsDetailsBean createFromParcel(Parcel source) {
                    return new GoodsDetailsBean(source);
                }

                @Override
                public GoodsDetailsBean[] newArray(int size) {
                    return new GoodsDetailsBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.ExpenseDetail, flags);
            dest.writeInt(this.State);
            dest.writeList(this.GoodsDetails);
        }

        public ContentBean() {
        }

        protected ContentBean(Parcel in) {
            this.ExpenseDetail = in.readParcelable(ExpenseDetailBean.class.getClassLoader());
            this.State = in.readInt();
            this.GoodsDetails = new ArrayList<GoodsDetailsBean>();
            in.readList(this.GoodsDetails, GoodsDetailsBean.class.getClassLoader());
        }

        public static final Parcelable.Creator<ContentBean> CREATOR = new Parcelable.Creator<ContentBean>() {
            @Override
            public ContentBean createFromParcel(Parcel source) {
                return new ContentBean(source);
            }

            @Override
            public ContentBean[] newArray(int size) {
                return new ContentBean[size];
            }
        };
    }
}
