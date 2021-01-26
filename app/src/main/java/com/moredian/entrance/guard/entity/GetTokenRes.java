package com.moredian.entrance.guard.entity;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2021/1/25 10:32
 */
public class GetTokenRes {

    /**
     * Content : {"AccessToken":"61fecedb-4535-48d4-8518-99daa9cc095d","CompanyCode":1001,"UserId":"2d6b2da7-88e1-406a-88d4-e47695429a3c","Account":"1001","ExpirationTime":"2021-01-26 10:16:45"}
     * Message : Success!
     * Result : true
     * StatusCode : 200
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

    public static class ContentBean {
        /**
         * AccessToken : 61fecedb-4535-48d4-8518-99daa9cc095d
         * CompanyCode : 1001
         * UserId : 2d6b2da7-88e1-406a-88d4-e47695429a3c
         * Account : 1001
         * ExpirationTime : 2021-01-26 10:16:45
         */

        private String AccessToken;
        private int CompanyCode;
        private String UserId;
        private String Account;
        private String ExpirationTime;

        public String getAccessToken() {
            return AccessToken;
        }

        public void setAccessToken(String AccessToken) {
            this.AccessToken = AccessToken;
        }

        public int getCompanyCode() {
            return CompanyCode;
        }

        public void setCompanyCode(int CompanyCode) {
            this.CompanyCode = CompanyCode;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String UserId) {
            this.UserId = UserId;
        }

        public String getAccount() {
            return Account;
        }

        public void setAccount(String Account) {
            this.Account = Account;
        }

        public String getExpirationTime() {
            return ExpirationTime;
        }

        public void setExpirationTime(String ExpirationTime) {
            this.ExpirationTime = ExpirationTime;
        }
    }
}
