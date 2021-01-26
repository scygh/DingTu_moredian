package com.moredian.entrance.guard.entity;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2021/1/25 10:46
 */
public class MemberUpdateReq {

    /**
     * UserId : string
     * FaceBase64 : string
     * MemberName : string
     */

    private String UserId;
    private String FaceBase64;
    private String MemberName;

    public MemberUpdateReq(String userId, String faceBase64) {
        UserId = userId;
        FaceBase64 = faceBase64;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getFaceBase64() {
        return FaceBase64;
    }

    public void setFaceBase64(String FaceBase64) {
        this.FaceBase64 = FaceBase64;
    }

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String MemberName) {
        this.MemberName = MemberName;
    }
}
