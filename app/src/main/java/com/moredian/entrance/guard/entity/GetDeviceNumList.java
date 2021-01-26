package com.moredian.entrance.guard.entity;

import java.util.List;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2019/9/11 16:12
 */
public class GetDeviceNumList {


    /**
     * Content : [{"Id":0,"Name":null,"PlaceId":null,"Pattern":0,"AutoAmount":null,"KeyEnabled":null,"MealEnabled":null,"DepositEnabled":null,"RefundEnabled":null,"CorrectionEnabled":null,"DiscountEnabled":true,"AllowType":null,"AllowTypeAsString":null,"AllowMeal":null,"AllowMealAsString":null,"LinkIpAddress":null,"LinkPort":null,"GoodsRange":null,"FirmwareVersion":null,"DeviceVersion":null,"State":0},{"Id":1,"Name":null,"PlaceId":"af54988b-64af-4a0f-95bb-6cc17655be89","Pattern":1,"AutoAmount":0,"KeyEnabled":false,"MealEnabled":false,"DepositEnabled":true,"RefundEnabled":true,"CorrectionEnabled":true,"DiscountEnabled":true,"AllowType":[1,2,3,4],"AllowTypeAsString":"1,2,3,4","AllowMeal":null,"AllowMealAsString":null,"LinkIpAddress":"192.168.0.205","LinkPort":1400,"GoodsRange":"1,65535","FirmwareVersion":"SCM_EM_1000-191022","DeviceVersion":9,"State":1},{"Id":2,"Name":null,"PlaceId":"00000000-0000-0000-0000-000000000001","Pattern":2,"AutoAmount":0,"KeyEnabled":false,"MealEnabled":true,"DepositEnabled":true,"RefundEnabled":true,"CorrectionEnabled":true,"DiscountEnabled":true,"AllowType":[1,2,3,4],"AllowTypeAsString":"1,2,3,4","AllowMeal":null,"AllowMealAsString":null,"LinkIpAddress":"192.168.0.205","LinkPort":1500,"GoodsRange":"1,65535","FirmwareVersion":"SCM_EM_1100-190912","DeviceVersion":9,"State":1},{"Id":3,"Name":null,"PlaceId":"00000000-0000-0000-0000-000000000001","Pattern":1,"AutoAmount":0,"KeyEnabled":false,"MealEnabled":true,"DepositEnabled":true,"RefundEnabled":true,"CorrectionEnabled":true,"DiscountEnabled":true,"AllowType":[1,2,3,4],"AllowTypeAsString":"1,2,3,4","AllowMeal":null,"AllowMealAsString":null,"LinkIpAddress":"192.168.0.205","LinkPort":1400,"GoodsRange":"1,65535","FirmwareVersion":"SCM_EM_1100-190912","DeviceVersion":9,"State":1},{"Id":4,"Name":null,"PlaceId":"af54988b-64af-4a0f-95bb-6cc17655be89","Pattern":1,"AutoAmount":20,"KeyEnabled":null,"MealEnabled":true,"DepositEnabled":null,"RefundEnabled":null,"CorrectionEnabled":null,"DiscountEnabled":true,"AllowType":[2,3],"AllowTypeAsString":"2,3","AllowMeal":null,"AllowMealAsString":null,"LinkIpAddress":null,"LinkPort":null,"GoodsRange":null,"FirmwareVersion":null,"DeviceVersion":1,"State":1},{"Id":5,"Name":null,"PlaceId":"00000000-0000-0000-0000-000000000001","Pattern":1,"AutoAmount":10,"KeyEnabled":null,"MealEnabled":true,"DepositEnabled":null,"RefundEnabled":null,"CorrectionEnabled":null,"DiscountEnabled":true,"AllowType":[1,2],"AllowTypeAsString":"1,2","AllowMeal":null,"AllowMealAsString":null,"LinkIpAddress":null,"LinkPort":null,"GoodsRange":null,"FirmwareVersion":null,"DeviceVersion":1,"State":1},{"Id":6,"Name":null,"PlaceId":"d1ce9629-57ac-4fb4-aa92-78e75abc6ca9","Pattern":1,"AutoAmount":500,"KeyEnabled":null,"MealEnabled":true,"DepositEnabled":null,"RefundEnabled":null,"CorrectionEnabled":null,"DiscountEnabled":true,"AllowType":[1],"AllowTypeAsString":"1","AllowMeal":null,"AllowMealAsString":null,"LinkIpAddress":null,"LinkPort":null,"GoodsRange":null,"FirmwareVersion":null,"DeviceVersion":1,"State":1},{"Id":7,"Name":null,"PlaceId":"00000000-0000-0000-0000-000000000001","Pattern":1,"AutoAmount":10,"KeyEnabled":null,"MealEnabled":true,"DepositEnabled":null,"RefundEnabled":null,"CorrectionEnabled":null,"DiscountEnabled":true,"AllowType":[1,2],"AllowTypeAsString":"1,2","AllowMeal":null,"AllowMealAsString":null,"LinkIpAddress":null,"LinkPort":null,"GoodsRange":null,"FirmwareVersion":null,"DeviceVersion":1,"State":1},{"Id":8,"Name":null,"PlaceId":"00000000-0000-0000-0000-000000000001","Pattern":1,"AutoAmount":20,"KeyEnabled":null,"MealEnabled":true,"DepositEnabled":null,"RefundEnabled":null,"CorrectionEnabled":null,"DiscountEnabled":true,"AllowType":[3],"AllowTypeAsString":"3","AllowMeal":null,"AllowMealAsString":null,"LinkIpAddress":null,"LinkPort":null,"GoodsRange":null,"FirmwareVersion":null,"DeviceVersion":1,"State":1},{"Id":9,"Name":null,"PlaceId":"00000000-0000-0000-0000-000000000001","Pattern":2,"AutoAmount":1,"KeyEnabled":null,"MealEnabled":false,"DepositEnabled":null,"RefundEnabled":null,"CorrectionEnabled":null,"DiscountEnabled":true,"AllowType":[1,2,3,4,5,6,7,8,9,10,11],"AllowTypeAsString":"1,2,3,4,5,6,7,8,9,10,11","AllowMeal":null,"AllowMealAsString":null,"LinkIpAddress":null,"LinkPort":null,"GoodsRange":null,"FirmwareVersion":null,"DeviceVersion":1,"State":0},{"Id":10,"Name":null,"PlaceId":"af54988b-64af-4a0f-95bb-6cc17655be89","Pattern":1,"AutoAmount":0,"KeyEnabled":false,"MealEnabled":false,"DepositEnabled":true,"RefundEnabled":true,"CorrectionEnabled":true,"DiscountEnabled":true,"AllowType":[1,2,3,4],"AllowTypeAsString":"1,2,3,4","AllowMeal":null,"AllowMealAsString":null,"LinkIpAddress":"218.2.80.158","LinkPort":9991,"GoodsRange":"1,65535","FirmwareVersion":"SCM_EM_11FA-191022","DeviceVersion":9,"State":1},{"Id":10000,"Name":null,"PlaceId":"00000000-0000-0000-0000-000000000001","Pattern":2,"AutoAmount":0.01,"KeyEnabled":true,"MealEnabled":true,"DepositEnabled":true,"RefundEnabled":true,"CorrectionEnabled":true,"DiscountEnabled":true,"AllowType":[1,2,3,4],"AllowTypeAsString":"1,2,3,4","AllowMeal":null,"AllowMealAsString":null,"LinkIpAddress":"218.2.80.158","LinkPort":9991,"GoodsRange":"1,65535","FirmwareVersion":"SCM_EM_1000-191022","DeviceVersion":9,"State":1}]
     * Result : true
     * Message : Success!
     * StatusCode : 200
     */

    private boolean Result;
    private String Message;
    private int StatusCode;
    private List<ContentBean> Content;

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

    public List<ContentBean> getContent() {
        return Content;
    }

    public void setContent(List<ContentBean> Content) {
        this.Content = Content;
    }

    public static class ContentBean {
        /**
         * Id : 0
         * Name : null
         * PlaceId : null
         * Pattern : 0
         * AutoAmount : null
         * KeyEnabled : null
         * MealEnabled : null
         * DepositEnabled : null
         * RefundEnabled : null
         * CorrectionEnabled : null
         * DiscountEnabled : true
         * AllowType : null
         * AllowTypeAsString : null
         * AllowMeal : null
         * AllowMealAsString : null
         * LinkIpAddress : null
         * LinkPort : null
         * GoodsRange : null
         * FirmwareVersion : null
         * DeviceVersion : null
         * State : 0
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
        private int[] AllowType;
        private String AllowTypeAsString;
        //private Object AllowMeal;
        private String AllowMealAsString;
        private String LinkIpAddress;
        private int LinkPort;
        private String GoodsRange;
        private String FirmwareVersion;
        private int DeviceVersion;
        private int State;

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getPlaceId() {
            return PlaceId;
        }

        public void setPlaceId(String placeId) {
            PlaceId = placeId;
        }

        public int getPattern() {
            return Pattern;
        }

        public void setPattern(int pattern) {
            Pattern = pattern;
        }

        public float getAutoAmount() {
            return AutoAmount;
        }

        public void setAutoAmount(float autoAmount) {
            AutoAmount = autoAmount;
        }

        public boolean isKeyEnabled() {
            return KeyEnabled;
        }

        public void setKeyEnabled(boolean keyEnabled) {
            KeyEnabled = keyEnabled;
        }

        public boolean isMealEnabled() {
            return MealEnabled;
        }

        public void setMealEnabled(boolean mealEnabled) {
            MealEnabled = mealEnabled;
        }

        public boolean isDepositEnabled() {
            return DepositEnabled;
        }

        public void setDepositEnabled(boolean depositEnabled) {
            DepositEnabled = depositEnabled;
        }

        public boolean isRefundEnabled() {
            return RefundEnabled;
        }

        public void setRefundEnabled(boolean refundEnabled) {
            RefundEnabled = refundEnabled;
        }

        public boolean isCorrectionEnabled() {
            return CorrectionEnabled;
        }

        public void setCorrectionEnabled(boolean correctionEnabled) {
            CorrectionEnabled = correctionEnabled;
        }

        public boolean isDiscountEnabled() {
            return DiscountEnabled;
        }

        public void setDiscountEnabled(boolean discountEnabled) {
            DiscountEnabled = discountEnabled;
        }

        public int[] getAllowType() {
            return AllowType;
        }

        public void setAllowType(int[] allowType) {
            AllowType = allowType;
        }

        public String getAllowTypeAsString() {
            return AllowTypeAsString;
        }

        public void setAllowTypeAsString(String allowTypeAsString) {
            AllowTypeAsString = allowTypeAsString;
        }

        public String getAllowMealAsString() {
            return AllowMealAsString;
        }

        public void setAllowMealAsString(String allowMealAsString) {
            AllowMealAsString = allowMealAsString;
        }

        public String getLinkIpAddress() {
            return LinkIpAddress;
        }

        public void setLinkIpAddress(String linkIpAddress) {
            LinkIpAddress = linkIpAddress;
        }

        public int getLinkPort() {
            return LinkPort;
        }

        public void setLinkPort(int linkPort) {
            LinkPort = linkPort;
        }

        public String getGoodsRange() {
            return GoodsRange;
        }

        public void setGoodsRange(String goodsRange) {
            GoodsRange = goodsRange;
        }

        public String getFirmwareVersion() {
            return FirmwareVersion;
        }

        public void setFirmwareVersion(String firmwareVersion) {
            FirmwareVersion = firmwareVersion;
        }

        public int getDeviceVersion() {
            return DeviceVersion;
        }

        public void setDeviceVersion(int deviceVersion) {
            DeviceVersion = deviceVersion;
        }

        public int getState() {
            return State;
        }

        public void setState(int state) {
            State = state;
        }
    }
}
