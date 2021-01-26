package com.moredian.entrance.guard.entity;

import java.util.List;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2019/9/16 17:22
 */
public class GetDevicePattern {


    /**
     * Content : {"Id":1,"Name":null,"PlaceId":"af54988b-64af-4a0f-95bb-6cc17655be89","Pattern":1,"AutoAmount":0,"KeyEnabled":false,"MealEnabled":false,"DepositEnabled":true,"RefundEnabled":true,"CorrectionEnabled":true,"DiscountEnabled":true,"AllowType":[1,2,3,4],"AllowTypeAsString":"1,2,3,4","AllowMeal":null,"AllowMealAsString":null,"LinkIpAddress":"192.168.0.205","LinkPort":1400,"GoodsRange":"1,65535","FirmwareVersion":"SCM_EM_1000-191022","DeviceVersion":9,"State":1}
     * Result : true
     * Message : Success!
     * StatusCode : 200
     */

    private ContentBean Content;
    private boolean Result;
    private String Message;
    private int StatusCode;

    public ContentBean getContent() {
        return Content;
    }

    public void setContent(ContentBean Content) {
        this.Content = Content;
    }

    public boolean isResult() {
        return Result;
    }

    public void setResult(boolean Result) {
        this.Result = Result;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public static class ContentBean {
        /**
         * Id : 1
         * Name : null
         * PlaceId : af54988b-64af-4a0f-95bb-6cc17655be89
         * Pattern : 1
         * AutoAmount : 0
         * KeyEnabled : false
         * MealEnabled : false
         * DepositEnabled : true
         * RefundEnabled : true
         * CorrectionEnabled : true
         * DiscountEnabled : true
         * AllowType : [1,2,3,4]
         * AllowTypeAsString : 1,2,3,4
         * AllowMeal : null
         * AllowMealAsString : null
         * LinkIpAddress : 192.168.0.205
         * LinkPort : 1400
         * GoodsRange : 1,65535
         * FirmwareVersion : SCM_EM_1000-191022
         * DeviceVersion : 9
         * State : 1
         */

        private int Id;
        private String Name;
        private String PlaceId;
        private int Pattern;
        private float AutoAmount;
        private boolean KeyEnabled;
        private boolean MealEnabled;
        private boolean DepositEnabled;
        private boolean RefundEnabled;
        private boolean CorrectionEnabled;
        private boolean DiscountEnabled;
        private String AllowTypeAsString;
        private Object AllowMeal;
        private String AllowMealAsString;
        private String LinkIpAddress;
        private int LinkPort;
        private String GoodsRange;
        private String FirmwareVersion;
        private int DeviceVersion;
        private int State;
        private List<Integer> AllowType;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getPlaceId() {
            return PlaceId;
        }

        public void setPlaceId(String PlaceId) {
            this.PlaceId = PlaceId;
        }

        public int getPattern() {
            return Pattern;
        }

        public void setPattern(int Pattern) {
            this.Pattern = Pattern;
        }

        public float getAutoAmount() {
            return AutoAmount;
        }

        public void setAutoAmount(float AutoAmount) {
            this.AutoAmount = AutoAmount;
        }

        public boolean isKeyEnabled() {
            return KeyEnabled;
        }

        public void setKeyEnabled(boolean KeyEnabled) {
            this.KeyEnabled = KeyEnabled;
        }

        public boolean isMealEnabled() {
            return MealEnabled;
        }

        public void setMealEnabled(boolean MealEnabled) {
            this.MealEnabled = MealEnabled;
        }

        public boolean isDepositEnabled() {
            return DepositEnabled;
        }

        public void setDepositEnabled(boolean DepositEnabled) {
            this.DepositEnabled = DepositEnabled;
        }

        public boolean isRefundEnabled() {
            return RefundEnabled;
        }

        public void setRefundEnabled(boolean RefundEnabled) {
            this.RefundEnabled = RefundEnabled;
        }

        public boolean isCorrectionEnabled() {
            return CorrectionEnabled;
        }

        public void setCorrectionEnabled(boolean CorrectionEnabled) {
            this.CorrectionEnabled = CorrectionEnabled;
        }

        public boolean isDiscountEnabled() {
            return DiscountEnabled;
        }

        public void setDiscountEnabled(boolean DiscountEnabled) {
            this.DiscountEnabled = DiscountEnabled;
        }

        public String getAllowTypeAsString() {
            return AllowTypeAsString;
        }

        public void setAllowTypeAsString(String AllowTypeAsString) {
            this.AllowTypeAsString = AllowTypeAsString;
        }

        public Object getAllowMeal() {
            return AllowMeal;
        }

        public void setAllowMeal(Object AllowMeal) {
            this.AllowMeal = AllowMeal;
        }

        public String getAllowMealAsString() {
            return AllowMealAsString;
        }

        public void setAllowMealAsString(String AllowMealAsString) {
            this.AllowMealAsString = AllowMealAsString;
        }

        public String getLinkIpAddress() {
            return LinkIpAddress;
        }

        public void setLinkIpAddress(String LinkIpAddress) {
            this.LinkIpAddress = LinkIpAddress;
        }

        public int getLinkPort() {
            return LinkPort;
        }

        public void setLinkPort(int LinkPort) {
            this.LinkPort = LinkPort;
        }

        public String getGoodsRange() {
            return GoodsRange;
        }

        public void setGoodsRange(String GoodsRange) {
            this.GoodsRange = GoodsRange;
        }

        public String getFirmwareVersion() {
            return FirmwareVersion;
        }

        public void setFirmwareVersion(String FirmwareVersion) {
            this.FirmwareVersion = FirmwareVersion;
        }

        public int getDeviceVersion() {
            return DeviceVersion;
        }

        public void setDeviceVersion(int DeviceVersion) {
            this.DeviceVersion = DeviceVersion;
        }

        public int getState() {
            return State;
        }

        public void setState(int State) {
            this.State = State;
        }

        public List<Integer> getAllowType() {
            return AllowType;
        }

        public void setAllowType(List<Integer> AllowType) {
            this.AllowType = AllowType;
        }
    }
}
