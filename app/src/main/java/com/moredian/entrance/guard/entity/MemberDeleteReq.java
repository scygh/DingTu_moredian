package com.moredian.entrance.guard.entity;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2021/1/25 10:50
 */
public class MemberDeleteReq {

    public MemberDeleteReq(String userId) {
        UserId = userId;
    }

    /**
     * UserId : string
     */


    private String UserId;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }
}
