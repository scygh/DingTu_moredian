package com.moredian.entrance.guard.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2019/8/26 09:26
 */
public class PostRegister implements Parcelable {


    /**
     * UserID : string
     * DepartmentID : string
     * DepartmentName : string
     * Name : string
     * EmpID : string
     * IDCard : string
     * Sex : 0
     * Age : 0
     * Address : string
     * Phone : string
     * UserCreateTime : 2020-07-15T01:24:26.951Z
     * Password : string
     * Photo : string
     * PayKey : string
     * CardTypeName : string
     * UserState : 0
     * Number : 0
     * SerialNo : string
     * CardType : 0
     * IsDiscount : true
     * IsGotCard : 0
     * DiscountRate : 0
     * Foregift : 0
     * SubsidyLevel : 0
     * SubsidyLevelName : string
     * Cost : 0
     * Deadline : 2020-07-15T01:24:26.951Z
     * PayCount : 0
     * LastSubsidyDate : 2020-07-15T01:24:26.951Z
     * SubsidyDatediff : 0
     * CardCreateTime : 2020-07-15T01:24:26.951Z
     * CardState : 0
     * Cash : 0
     * Subsidy : 0
     * Times : 0
     * Donate : 0
     * Integral : 0
     * LastPayDateTime : 2020-07-15T01:24:26.951Z
     * AuthType : 0
     * AuthUrl : string
     * AuthResult : string
     */

    private String UserID;
    private String DepartmentID;
    private String DepartmentName;
    private String Name;
    private String EmpID;
    private String IDCard;
    private int Sex;
    private int Age;
    private String Address;
    private String Phone;
    private String UserCreateTime;
    private String Password;
    private String Photo;
    private String PayKey;
    private String CardTypeName;
    private int UserState;
    private int Number;
    private String SerialNo;
    private int CardType;
    private boolean IsDiscount;
    private int IsGotCard;
    private int DiscountRate;
    private int Foregift;
    private int SubsidyLevel;
    private String SubsidyLevelName;
    private double Cost;
    private String Deadline;
    private int PayCount;
    private String LastSubsidyDate;
    private int SubsidyDatediff;
    private String CardCreateTime;
    private int CardState;
    private double Cash;
    private double Subsidy;
    private int Times;
    private double Donate;
    private int Integral;
    private String LastPayDateTime;
    private int AuthType;
    private String AuthUrl;
    private String AuthResult;

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(String DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmpID() {
        return EmpID;
    }

    public void setEmpID(String EmpID) {
        this.EmpID = EmpID;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int Sex) {
        this.Sex = Sex;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getUserCreateTime() {
        return UserCreateTime;
    }

    public void setUserCreateTime(String UserCreateTime) {
        this.UserCreateTime = UserCreateTime;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    public String getPayKey() {
        return PayKey;
    }

    public void setPayKey(String PayKey) {
        this.PayKey = PayKey;
    }

    public String getCardTypeName() {
        return CardTypeName;
    }

    public void setCardTypeName(String CardTypeName) {
        this.CardTypeName = CardTypeName;
    }

    public int getUserState() {
        return UserState;
    }

    public void setUserState(int UserState) {
        this.UserState = UserState;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(String SerialNo) {
        this.SerialNo = SerialNo;
    }

    public int getCardType() {
        return CardType;
    }

    public void setCardType(int CardType) {
        this.CardType = CardType;
    }

    public boolean isIsDiscount() {
        return IsDiscount;
    }

    public void setIsDiscount(boolean IsDiscount) {
        this.IsDiscount = IsDiscount;
    }

    public int getIsGotCard() {
        return IsGotCard;
    }

    public void setIsGotCard(int IsGotCard) {
        this.IsGotCard = IsGotCard;
    }

    public int getDiscountRate() {
        return DiscountRate;
    }

    public void setDiscountRate(int DiscountRate) {
        this.DiscountRate = DiscountRate;
    }

    public int getForegift() {
        return Foregift;
    }

    public void setForegift(int Foregift) {
        this.Foregift = Foregift;
    }

    public int getSubsidyLevel() {
        return SubsidyLevel;
    }

    public void setSubsidyLevel(int SubsidyLevel) {
        this.SubsidyLevel = SubsidyLevel;
    }

    public String getSubsidyLevelName() {
        return SubsidyLevelName;
    }

    public void setSubsidyLevelName(String SubsidyLevelName) {
        this.SubsidyLevelName = SubsidyLevelName;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }

    public String getDeadline() {
        return Deadline;
    }

    public void setDeadline(String Deadline) {
        this.Deadline = Deadline;
    }

    public int getPayCount() {
        return PayCount;
    }

    public void setPayCount(int PayCount) {
        this.PayCount = PayCount;
    }

    public String getLastSubsidyDate() {
        return LastSubsidyDate;
    }

    public void setLastSubsidyDate(String LastSubsidyDate) {
        this.LastSubsidyDate = LastSubsidyDate;
    }

    public int getSubsidyDatediff() {
        return SubsidyDatediff;
    }

    public void setSubsidyDatediff(int SubsidyDatediff) {
        this.SubsidyDatediff = SubsidyDatediff;
    }

    public String getCardCreateTime() {
        return CardCreateTime;
    }

    public void setCardCreateTime(String CardCreateTime) {
        this.CardCreateTime = CardCreateTime;
    }

    public int getCardState() {
        return CardState;
    }

    public void setCardState(int CardState) {
        this.CardState = CardState;
    }

    public double getCash() {
        return Cash;
    }

    public void setCash(double Cash) {
        this.Cash = Cash;
    }

    public double getSubsidy() {
        return Subsidy;
    }

    public void setSubsidy(double Subsidy) {
        this.Subsidy = Subsidy;
    }

    public int getTimes() {
        return Times;
    }

    public void setTimes(int Times) {
        this.Times = Times;
    }

    public double getDonate() {
        return Donate;
    }

    public void setDonate(double Donate) {
        this.Donate = Donate;
    }

    public int getIntegral() {
        return Integral;
    }

    public void setIntegral(int Integral) {
        this.Integral = Integral;
    }

    public String getLastPayDateTime() {
        return LastPayDateTime;
    }

    public void setLastPayDateTime(String LastPayDateTime) {
        this.LastPayDateTime = LastPayDateTime;
    }

    public int getAuthType() {
        return AuthType;
    }

    public void setAuthType(int AuthType) {
        this.AuthType = AuthType;
    }

    public String getAuthUrl() {
        return AuthUrl;
    }

    public void setAuthUrl(String AuthUrl) {
        this.AuthUrl = AuthUrl;
    }

    public String getAuthResult() {
        return AuthResult;
    }

    public void setAuthResult(String AuthResult) {
        this.AuthResult = AuthResult;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.UserID);
        dest.writeString(this.DepartmentID);
        dest.writeString(this.DepartmentName);
        dest.writeString(this.Name);
        dest.writeString(this.EmpID);
        dest.writeString(this.IDCard);
        dest.writeInt(this.Sex);
        dest.writeInt(this.Age);
        dest.writeString(this.Address);
        dest.writeString(this.Phone);
        dest.writeString(this.UserCreateTime);
        dest.writeString(this.Password);
        dest.writeString(this.Photo);
        dest.writeString(this.PayKey);
        dest.writeString(this.CardTypeName);
        dest.writeInt(this.UserState);
        dest.writeInt(this.Number);
        dest.writeString(this.SerialNo);
        dest.writeInt(this.CardType);
        dest.writeByte(this.IsDiscount ? (byte) 1 : (byte) 0);
        dest.writeInt(this.IsGotCard);
        dest.writeInt(this.DiscountRate);
        dest.writeInt(this.Foregift);
        dest.writeInt(this.SubsidyLevel);
        dest.writeString(this.SubsidyLevelName);
        dest.writeDouble(this.Cost);
        dest.writeString(this.Deadline);
        dest.writeInt(this.PayCount);
        dest.writeString(this.LastSubsidyDate);
        dest.writeInt(this.SubsidyDatediff);
        dest.writeString(this.CardCreateTime);
        dest.writeInt(this.CardState);
        dest.writeDouble(this.Cash);
        dest.writeDouble(this.Subsidy);
        dest.writeInt(this.Times);
        dest.writeDouble(this.Donate);
        dest.writeInt(this.Integral);
        dest.writeString(this.LastPayDateTime);
        dest.writeInt(this.AuthType);
        dest.writeString(this.AuthUrl);
        dest.writeString(this.AuthResult);
    }

    public PostRegister() {
    }

    protected PostRegister(Parcel in) {
        this.UserID = in.readString();
        this.DepartmentID = in.readString();
        this.DepartmentName = in.readString();
        this.Name = in.readString();
        this.EmpID = in.readString();
        this.IDCard = in.readString();
        this.Sex = in.readInt();
        this.Age = in.readInt();
        this.Address = in.readString();
        this.Phone = in.readString();
        this.UserCreateTime = in.readString();
        this.Password = in.readString();
        this.Photo = in.readString();
        this.PayKey = in.readString();
        this.CardTypeName = in.readString();
        this.UserState = in.readInt();
        this.Number = in.readInt();
        this.SerialNo = in.readString();
        this.CardType = in.readInt();
        this.IsDiscount = in.readByte() != 0;
        this.IsGotCard = in.readInt();
        this.DiscountRate = in.readInt();
        this.Foregift = in.readInt();
        this.SubsidyLevel = in.readInt();
        this.SubsidyLevelName = in.readString();
        this.Cost = in.readDouble();
        this.Deadline = in.readString();
        this.PayCount = in.readInt();
        this.LastSubsidyDate = in.readString();
        this.SubsidyDatediff = in.readInt();
        this.CardCreateTime = in.readString();
        this.CardState = in.readInt();
        this.Cash = in.readDouble();
        this.Subsidy = in.readDouble();
        this.Times = in.readInt();
        this.Donate = in.readDouble();
        this.Integral = in.readInt();
        this.LastPayDateTime = in.readString();
        this.AuthType = in.readInt();
        this.AuthUrl = in.readString();
        this.AuthResult = in.readString();
    }

    public static final Creator<PostRegister> CREATOR = new Creator<PostRegister>() {
        @Override
        public PostRegister createFromParcel(Parcel source) {
            return new PostRegister(source);
        }

        @Override
        public PostRegister[] newArray(int size) {
            return new PostRegister[size];
        }
    };
}
