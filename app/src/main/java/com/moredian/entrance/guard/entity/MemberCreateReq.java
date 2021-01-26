package com.moredian.entrance.guard.entity;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2021/1/25 10:41
 */
public class MemberCreateReq {


    /**
     * UserId : string
     * MemberName : string
     * Mobile : string
     */

    private String UserId;
    private String MemberName;
    private String Mobile;

    public MemberCreateReq(String userId, String memberName, String mobile) {
        UserId = userId;
        MemberName = memberName;
        Mobile = mobile;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String MemberName) {
        this.MemberName = MemberName;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }
}
