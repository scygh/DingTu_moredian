package com.moredian.entrance.guard.entity;

import java.util.List;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2019/8/26 14:10
 */
public class GetSubsidyLevel {


    /**
     * Result : true
     * Message : string
     * StatusCode : 200
     * Content : [{"ID":"string","Leve":0,"Name":"string","Amount":0,"IsReset":true,"State":0,"Description":"string"}]
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
         * ID : string
         * Leve : 0
         * Name : string
         * Amount : 0
         * IsReset : true
         * State : 0
         * Description : string
         */

        private String Id;
        private int Leve;
        private String Name;
        private double Amount;
        private boolean IsReset;
        private int State;
        private String Description;

        public String getId() {
            return Id;
        }

        public void setId(String id) {
            Id = id;
        }

        public int getLeve() {
            return Leve;
        }

        public void setLeve(int leve) {
            Leve = leve;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public double getAmount() {
            return Amount;
        }

        public void setAmount(double amount) {
            Amount = amount;
        }

        public boolean isReset() {
            return IsReset;
        }

        public void setReset(boolean reset) {
            IsReset = reset;
        }

        public int getState() {
            return State;
        }

        public void setState(int state) {
            State = state;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }
    }
}
