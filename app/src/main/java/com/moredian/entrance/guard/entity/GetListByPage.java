package com.moredian.entrance.guard.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2019/7/31 13:35
 */
public class GetListByPage {


    /**
     * Content : {"Count":29,"Rows":[{"UserFace":null,"User":{"Id":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","DepartmentId":"19d84708-b0f1-482a-8b85-e1f71d63c1fa","Name":"张无忌","EmpId":null,"IdCard":null,"Sex":0,"Age":0,"Address":null,"Phone":null,"CreateTime":"2020-07-09 10:31:31","State":1,"Password":"AiGGfjnuRaE=","Photo":null,"PayKey":null,"AuthType":null,"AuthUrl":null,"AuthResult":null},"Finances":[{"UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Kind":0,"Balance":10000},{"UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Kind":1,"Balance":0},{"UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Kind":2,"Balance":0},{"UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Kind":3,"Balance":1000},{"UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Kind":4,"Balance":0}],"Card":{"Id":"e8fb492d-0ff4-4669-85f3-71b48cf8ce37","UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Number":31,"SerialNo":"test01","Type":1,"Level":0,"Cost":0,"Deadline":"2119-01-01 00:00:00","PayCount":0,"LastSubsidyDate":"2020-06-09 10:31:31","CreateTime":"2020-07-09 10:31:31","IsGot":true,"State":1,"LastPayDateTime":null}},{"UserFace":null,"User":{"Id":"2ce96120-1b2b-4624-af95-4a0f3fd2f7a0","DepartmentId":"00000000-0000-0000-0000-000000000001","Name":"刘翔","EmpId":"","IdCard":"","Sex":0,"Age":0,"Address":"","Phone":"","CreateTime":"2020-07-03 15:16:21","State":1,"Password":"Wabg2EsJTng=","Photo":null,"PayKey":"","AuthType":null,"AuthUrl":null,"AuthResult":null},"Finances":[{"UserId":"2ce96120-1b2b-4624-af95-4a0f3fd2f7a0","Kind":0,"Balance":100000},{"UserId":"2ce96120-1b2b-4624-af95-4a0f3fd2f7a0","Kind":1,"Balance":0},{"UserId":"2ce96120-1b2b-4624-af95-4a0f3fd2f7a0","Kind":2,"Balance":0},{"UserId":"2ce96120-1b2b-4624-af95-4a0f3fd2f7a0","Kind":3,"Balance":10000},{"UserId":"2ce96120-1b2b-4624-af95-4a0f3fd2f7a0","Kind":4,"Balance":0}],"Card":{"Id":"8acd1a4d-a7e1-4c41-9479-b0e07dd93d7f","UserId":"2ce96120-1b2b-4624-af95-4a0f3fd2f7a0","Number":30,"SerialNo":"147","Type":1,"Level":0,"Cost":0,"Deadline":"2119-01-26 00:00:00","PayCount":0,"LastSubsidyDate":"2020-06-03 15:16:21","CreateTime":"2020-07-03 15:16:21","IsGot":true,"State":1,"LastPayDateTime":null}},{"UserFace":null,"User":{"Id":"092e93ec-c6fc-4082-9a89-c2e72a8ff3fe","DepartmentId":"00000000-0000-0000-0000-000000000001","Name":"洪","EmpId":null,"IdCard":null,"Sex":0,"Age":0,"Address":null,"Phone":null,"CreateTime":"2020-07-03 13:21:20","State":1,"Password":"0FSsUH6c2T4=","Photo":null,"PayKey":null,"AuthType":null,"AuthUrl":null,"AuthResult":null},"Finances":[{"UserId":"092e93ec-c6fc-4082-9a89-c2e72a8ff3fe","Kind":0,"Balance":0},{"UserId":"092e93ec-c6fc-4082-9a89-c2e72a8ff3fe","Kind":1,"Balance":0},{"UserId":"092e93ec-c6fc-4082-9a89-c2e72a8ff3fe","Kind":2,"Balance":0},{"UserId":"092e93ec-c6fc-4082-9a89-c2e72a8ff3fe","Kind":3,"Balance":0},{"UserId":"092e93ec-c6fc-4082-9a89-c2e72a8ff3fe","Kind":4,"Balance":0}],"Card":{"Id":"c891bbef-0e5f-47d1-8100-ae9a32ce019d","UserId":"092e93ec-c6fc-4082-9a89-c2e72a8ff3fe","Number":29,"SerialNo":"2","Type":3,"Level":0,"Cost":0,"Deadline":"2030-05-12 00:00:00","PayCount":0,"LastSubsidyDate":"2020-06-03 13:21:20","CreateTime":"2020-07-03 13:21:20","IsGot":true,"State":1,"LastPayDateTime":null}},{"UserFace":null,"User":{"Id":"3d3a19d3-120a-4d4a-b3ac-0240a88a646d","DepartmentId":"00000000-0000-0000-0000-000000000001","Name":"鲁炳","EmpId":null,"IdCard":null,"Sex":0,"Age":0,"Address":"hangzhou","Phone":"17557289603","CreateTime":"2020-07-02 15:11:31","State":1,"Password":"WLn1kJuIVBQ=","Photo":null,"PayKey":null,"AuthType":null,"AuthUrl":null,"AuthResult":null},"Finances":[{"UserId":"3d3a19d3-120a-4d4a-b3ac-0240a88a646d","Kind":0,"Balance":10000},{"UserId":"3d3a19d3-120a-4d4a-b3ac-0240a88a646d","Kind":1,"Balance":0},{"UserId":"3d3a19d3-120a-4d4a-b3ac-0240a88a646d","Kind":2,"Balance":0},{"UserId":"3d3a19d3-120a-4d4a-b3ac-0240a88a646d","Kind":3,"Balance":1000},{"UserId":"3d3a19d3-120a-4d4a-b3ac-0240a88a646d","Kind":4,"Balance":0}],"Card":{"Id":"26cc1c0c-d23d-4514-a7a7-17c0676aec77","UserId":"3d3a19d3-120a-4d4a-b3ac-0240a88a646d","Number":27,"SerialNo":"lub123","Type":1,"Level":0,"Cost":0,"Deadline":"2119-01-25 00:00:00","PayCount":1,"LastSubsidyDate":"2020-06-02 15:11:31","CreateTime":"2020-07-02 15:11:31","IsGot":false,"State":1,"LastPayDateTime":"2020-07-02 15:31:56"}},{"UserFace":null,"User":{"Id":"2d0f31db-830f-4aaf-84e0-20e7d8fd2c08","DepartmentId":"00000000-0000-0000-0000-000000000001","Name":"姜伟民","EmpId":null,"IdCard":null,"Sex":0,"Age":0,"Address":null,"Phone":"15168205495","CreateTime":"2020-06-28 15:06:00","State":1,"Password":"WLn1kJuIVBQ=","Photo":null,"PayKey":null,"AuthType":null,"AuthUrl":null,"AuthResult":null},"Finances":[{"UserId":"2d0f31db-830f-4aaf-84e0-20e7d8fd2c08","Kind":0,"Balance":50000},{"UserId":"2d0f31db-830f-4aaf-84e0-20e7d8fd2c08","Kind":1,"Balance":0},{"UserId":"2d0f31db-830f-4aaf-84e0-20e7d8fd2c08","Kind":2,"Balance":0},{"UserId":"2d0f31db-830f-4aaf-84e0-20e7d8fd2c08","Kind":3,"Balance":4985},{"UserId":"2d0f31db-830f-4aaf-84e0-20e7d8fd2c08","Kind":4,"Balance":0}],"Card":{"Id":"937f11bb-dcec-4ae7-b974-353c2d0b7b4d","UserId":"2d0f31db-830f-4aaf-84e0-20e7d8fd2c08","Number":26,"SerialNo":"10001","Type":1,"Level":0,"Cost":0,"Deadline":"2119-01-21 00:00:00","PayCount":3,"LastSubsidyDate":"2020-05-28 15:06:00","CreateTime":"2020-06-28 15:06:00","IsGot":false,"State":1,"LastPayDateTime":"2020-06-28 15:07:27"}}]}
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
         * Count : 29
         * Rows : [{"UserFace":null,"User":{"Id":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","DepartmentId":"19d84708-b0f1-482a-8b85-e1f71d63c1fa","Name":"张无忌","EmpId":null,"IdCard":null,"Sex":0,"Age":0,"Address":null,"Phone":null,"CreateTime":"2020-07-09 10:31:31","State":1,"Password":"AiGGfjnuRaE=","Photo":null,"PayKey":null,"AuthType":null,"AuthUrl":null,"AuthResult":null},"Finances":[{"UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Kind":0,"Balance":10000},{"UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Kind":1,"Balance":0},{"UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Kind":2,"Balance":0},{"UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Kind":3,"Balance":1000},{"UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Kind":4,"Balance":0}],"Card":{"Id":"e8fb492d-0ff4-4669-85f3-71b48cf8ce37","UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Number":31,"SerialNo":"test01","Type":1,"Level":0,"Cost":0,"Deadline":"2119-01-01 00:00:00","PayCount":0,"LastSubsidyDate":"2020-06-09 10:31:31","CreateTime":"2020-07-09 10:31:31","IsGot":true,"State":1,"LastPayDateTime":null}},{"UserFace":null,"User":{"Id":"2ce96120-1b2b-4624-af95-4a0f3fd2f7a0","DepartmentId":"00000000-0000-0000-0000-000000000001","Name":"刘翔","EmpId":"","IdCard":"","Sex":0,"Age":0,"Address":"","Phone":"","CreateTime":"2020-07-03 15:16:21","State":1,"Password":"Wabg2EsJTng=","Photo":null,"PayKey":"","AuthType":null,"AuthUrl":null,"AuthResult":null},"Finances":[{"UserId":"2ce96120-1b2b-4624-af95-4a0f3fd2f7a0","Kind":0,"Balance":100000},{"UserId":"2ce96120-1b2b-4624-af95-4a0f3fd2f7a0","Kind":1,"Balance":0},{"UserId":"2ce96120-1b2b-4624-af95-4a0f3fd2f7a0","Kind":2,"Balance":0},{"UserId":"2ce96120-1b2b-4624-af95-4a0f3fd2f7a0","Kind":3,"Balance":10000},{"UserId":"2ce96120-1b2b-4624-af95-4a0f3fd2f7a0","Kind":4,"Balance":0}],"Card":{"Id":"8acd1a4d-a7e1-4c41-9479-b0e07dd93d7f","UserId":"2ce96120-1b2b-4624-af95-4a0f3fd2f7a0","Number":30,"SerialNo":"147","Type":1,"Level":0,"Cost":0,"Deadline":"2119-01-26 00:00:00","PayCount":0,"LastSubsidyDate":"2020-06-03 15:16:21","CreateTime":"2020-07-03 15:16:21","IsGot":true,"State":1,"LastPayDateTime":null}},{"UserFace":null,"User":{"Id":"092e93ec-c6fc-4082-9a89-c2e72a8ff3fe","DepartmentId":"00000000-0000-0000-0000-000000000001","Name":"洪","EmpId":null,"IdCard":null,"Sex":0,"Age":0,"Address":null,"Phone":null,"CreateTime":"2020-07-03 13:21:20","State":1,"Password":"0FSsUH6c2T4=","Photo":null,"PayKey":null,"AuthType":null,"AuthUrl":null,"AuthResult":null},"Finances":[{"UserId":"092e93ec-c6fc-4082-9a89-c2e72a8ff3fe","Kind":0,"Balance":0},{"UserId":"092e93ec-c6fc-4082-9a89-c2e72a8ff3fe","Kind":1,"Balance":0},{"UserId":"092e93ec-c6fc-4082-9a89-c2e72a8ff3fe","Kind":2,"Balance":0},{"UserId":"092e93ec-c6fc-4082-9a89-c2e72a8ff3fe","Kind":3,"Balance":0},{"UserId":"092e93ec-c6fc-4082-9a89-c2e72a8ff3fe","Kind":4,"Balance":0}],"Card":{"Id":"c891bbef-0e5f-47d1-8100-ae9a32ce019d","UserId":"092e93ec-c6fc-4082-9a89-c2e72a8ff3fe","Number":29,"SerialNo":"2","Type":3,"Level":0,"Cost":0,"Deadline":"2030-05-12 00:00:00","PayCount":0,"LastSubsidyDate":"2020-06-03 13:21:20","CreateTime":"2020-07-03 13:21:20","IsGot":true,"State":1,"LastPayDateTime":null}},{"UserFace":null,"User":{"Id":"3d3a19d3-120a-4d4a-b3ac-0240a88a646d","DepartmentId":"00000000-0000-0000-0000-000000000001","Name":"鲁炳","EmpId":null,"IdCard":null,"Sex":0,"Age":0,"Address":"hangzhou","Phone":"17557289603","CreateTime":"2020-07-02 15:11:31","State":1,"Password":"WLn1kJuIVBQ=","Photo":null,"PayKey":null,"AuthType":null,"AuthUrl":null,"AuthResult":null},"Finances":[{"UserId":"3d3a19d3-120a-4d4a-b3ac-0240a88a646d","Kind":0,"Balance":10000},{"UserId":"3d3a19d3-120a-4d4a-b3ac-0240a88a646d","Kind":1,"Balance":0},{"UserId":"3d3a19d3-120a-4d4a-b3ac-0240a88a646d","Kind":2,"Balance":0},{"UserId":"3d3a19d3-120a-4d4a-b3ac-0240a88a646d","Kind":3,"Balance":1000},{"UserId":"3d3a19d3-120a-4d4a-b3ac-0240a88a646d","Kind":4,"Balance":0}],"Card":{"Id":"26cc1c0c-d23d-4514-a7a7-17c0676aec77","UserId":"3d3a19d3-120a-4d4a-b3ac-0240a88a646d","Number":27,"SerialNo":"lub123","Type":1,"Level":0,"Cost":0,"Deadline":"2119-01-25 00:00:00","PayCount":1,"LastSubsidyDate":"2020-06-02 15:11:31","CreateTime":"2020-07-02 15:11:31","IsGot":false,"State":1,"LastPayDateTime":"2020-07-02 15:31:56"}},{"UserFace":null,"User":{"Id":"2d0f31db-830f-4aaf-84e0-20e7d8fd2c08","DepartmentId":"00000000-0000-0000-0000-000000000001","Name":"姜伟民","EmpId":null,"IdCard":null,"Sex":0,"Age":0,"Address":null,"Phone":"15168205495","CreateTime":"2020-06-28 15:06:00","State":1,"Password":"WLn1kJuIVBQ=","Photo":null,"PayKey":null,"AuthType":null,"AuthUrl":null,"AuthResult":null},"Finances":[{"UserId":"2d0f31db-830f-4aaf-84e0-20e7d8fd2c08","Kind":0,"Balance":50000},{"UserId":"2d0f31db-830f-4aaf-84e0-20e7d8fd2c08","Kind":1,"Balance":0},{"UserId":"2d0f31db-830f-4aaf-84e0-20e7d8fd2c08","Kind":2,"Balance":0},{"UserId":"2d0f31db-830f-4aaf-84e0-20e7d8fd2c08","Kind":3,"Balance":4985},{"UserId":"2d0f31db-830f-4aaf-84e0-20e7d8fd2c08","Kind":4,"Balance":0}],"Card":{"Id":"937f11bb-dcec-4ae7-b974-353c2d0b7b4d","UserId":"2d0f31db-830f-4aaf-84e0-20e7d8fd2c08","Number":26,"SerialNo":"10001","Type":1,"Level":0,"Cost":0,"Deadline":"2119-01-21 00:00:00","PayCount":3,"LastSubsidyDate":"2020-05-28 15:06:00","CreateTime":"2020-06-28 15:06:00","IsGot":false,"State":1,"LastPayDateTime":"2020-06-28 15:07:27"}}]
         */

        private int Count;
        private List<RowsBean> Rows;

        public int getCount() {
            return Count;
        }

        public void setCount(int Count) {
            this.Count = Count;
        }

        public List<RowsBean> getRows() {
            return Rows;
        }

        public void setRows(List<RowsBean> Rows) {
            this.Rows = Rows;
        }

        public static class RowsBean implements Parcelable {
            /**
             * UserFace : null
             * User : {"Id":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","DepartmentId":"19d84708-b0f1-482a-8b85-e1f71d63c1fa","Name":"张无忌","EmpId":null,"IdCard":null,"Sex":0,"Age":0,"Address":null,"Phone":null,"CreateTime":"2020-07-09 10:31:31","State":1,"Password":"AiGGfjnuRaE=","Photo":null,"PayKey":null,"AuthType":null,"AuthUrl":null,"AuthResult":null}
             * Finances : [{"UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Kind":0,"Balance":10000},{"UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Kind":1,"Balance":0},{"UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Kind":2,"Balance":0},{"UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Kind":3,"Balance":1000},{"UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Kind":4,"Balance":0}]
             * Card : {"Id":"e8fb492d-0ff4-4669-85f3-71b48cf8ce37","UserId":"89ed63e2-783d-461e-b2ff-17871cb3bcdd","Number":31,"SerialNo":"test01","Type":1,"Level":0,"Cost":0,"Deadline":"2119-01-01 00:00:00","PayCount":0,"LastSubsidyDate":"2020-06-09 10:31:31","CreateTime":"2020-07-09 10:31:31","IsGot":true,"State":1,"LastPayDateTime":null}
             */

            private UserFaceBean UserFace;
            private UserBean User;
            private CardBean Card;
            private List<FinancesBean> Finances;

            public UserFaceBean getUserFace() {
                return UserFace;
            }

            public void setUserFace(UserFaceBean UserFace) {
                this.UserFace = UserFace;
            }

            public UserBean getUser() {
                return User;
            }

            public void setUser(UserBean User) {
                this.User = User;
            }

            public CardBean getCard() {
                return Card;
            }

            public void setCard(CardBean Card) {
                this.Card = Card;
            }

            public List<FinancesBean> getFinances() {
                return Finances;
            }

            public void setFinances(List<FinancesBean> Finances) {
                this.Finances = Finances;
            }

            public static class UserFaceBean implements Parcelable {
                /**
                 * MemberId : 1660377671688781824
                 * MemberFace : MD_1001_c3b7351e-d20a-4fd4-8f6f-3dc88a7579a4
                 * MemberType : 2
                 * MemberBase64 : /9j/4AAQSkZJRgABAQAAAQABAAD/2
                 */

                private String MemberId;
                private String MemberFace;
                private int MemberType;
                private String MemberBase64;

                public String getMemberId() {
                    return MemberId;
                }

                public void setMemberId(String MemberId) {
                    this.MemberId = MemberId;
                }

                public String getMemberFace() {
                    return MemberFace;
                }

                public void setMemberFace(String MemberFace) {
                    this.MemberFace = MemberFace;
                }

                public int getMemberType() {
                    return MemberType;
                }

                public void setMemberType(int MemberType) {
                    this.MemberType = MemberType;
                }

                public String getMemberBase64() {
                    return MemberBase64;
                }

                public void setMemberBase64(String MemberBase64) {
                    this.MemberBase64 = MemberBase64;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.MemberId);
                    dest.writeString(this.MemberFace);
                    dest.writeInt(this.MemberType);
                    dest.writeString(this.MemberBase64);
                }

                public UserFaceBean() {
                }

                protected UserFaceBean(Parcel in) {
                    this.MemberId = in.readString();
                    this.MemberFace = in.readString();
                    this.MemberType = in.readInt();
                    this.MemberBase64 = in.readString();
                }

                public static final Creator<UserFaceBean> CREATOR = new Creator<UserFaceBean>() {
                    @Override
                    public UserFaceBean createFromParcel(Parcel source) {
                        return new UserFaceBean(source);
                    }

                    @Override
                    public UserFaceBean[] newArray(int size) {
                        return new UserFaceBean[size];
                    }
                };
            }

            public static class UserBean implements Parcelable {
                /**
                 * Id : 89ed63e2-783d-461e-b2ff-17871cb3bcdd
                 * DepartmentId : 19d84708-b0f1-482a-8b85-e1f71d63c1fa
                 * Name : 张无忌
                 * EmpId : null
                 * IdCard : null
                 * Sex : 0
                 * Age : 0
                 * Address : null
                 * Phone : null
                 * CreateTime : 2020-07-09 10:31:31
                 * State : 1
                 * Password : AiGGfjnuRaE=
                 * Photo : null
                 * PayKey : null
                 * AuthType : null
                 * AuthUrl : null
                 * AuthResult : null
                 */

                private String Id;
                private String DepartmentId;
                private String Name;
                private String EmpId;
                private String IdCard;
                private int Sex;
                private int Age;
                private String Address;
                private String Phone;
                private String CreateTime;
                private int State;
                private String Password;
                private String Photo;
                private String PayKey;
                private String AuthType;
                private String AuthUrl;
                private String AuthResult;

                public String getId() {
                    return Id;
                }

                public void setId(String id) {
                    Id = id;
                }

                public String getDepartmentId() {
                    return DepartmentId;
                }

                public void setDepartmentId(String departmentId) {
                    DepartmentId = departmentId;
                }

                public String getName() {
                    return Name;
                }

                public void setName(String name) {
                    Name = name;
                }

                public String getEmpId() {
                    return EmpId;
                }

                public void setEmpId(String empId) {
                    EmpId = empId;
                }

                public String getIdCard() {
                    return IdCard;
                }

                public void setIdCard(String idCard) {
                    IdCard = idCard;
                }

                public int getSex() {
                    return Sex;
                }

                public void setSex(int sex) {
                    Sex = sex;
                }

                public int getAge() {
                    return Age;
                }

                public void setAge(int age) {
                    Age = age;
                }

                public String getAddress() {
                    return Address;
                }

                public void setAddress(String address) {
                    Address = address;
                }

                public String getPhone() {
                    return Phone;
                }

                public void setPhone(String phone) {
                    Phone = phone;
                }

                public String getCreateTime() {
                    return CreateTime;
                }

                public void setCreateTime(String createTime) {
                    CreateTime = createTime;
                }

                public int getState() {
                    return State;
                }

                public void setState(int state) {
                    State = state;
                }

                public String getPassword() {
                    return Password;
                }

                public void setPassword(String password) {
                    Password = password;
                }

                public String getPhoto() {
                    return Photo;
                }

                public void setPhoto(String photo) {
                    Photo = photo;
                }

                public String getPayKey() {
                    return PayKey;
                }

                public void setPayKey(String payKey) {
                    PayKey = payKey;
                }

                public String getAuthType() {
                    return AuthType;
                }

                public void setAuthType(String authType) {
                    AuthType = authType;
                }

                public String getAuthUrl() {
                    return AuthUrl;
                }

                public void setAuthUrl(String authUrl) {
                    AuthUrl = authUrl;
                }

                public String getAuthResult() {
                    return AuthResult;
                }

                public void setAuthResult(String authResult) {
                    AuthResult = authResult;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.Id);
                    dest.writeString(this.DepartmentId);
                    dest.writeString(this.Name);
                    dest.writeString(this.EmpId);
                    dest.writeString(this.IdCard);
                    dest.writeInt(this.Sex);
                    dest.writeInt(this.Age);
                    dest.writeString(this.Address);
                    dest.writeString(this.Phone);
                    dest.writeString(this.CreateTime);
                    dest.writeInt(this.State);
                    dest.writeString(this.Password);
                }

                public UserBean() {
                }

                protected UserBean(Parcel in) {
                    this.Id = in.readString();
                    this.DepartmentId = in.readString();
                    this.Name = in.readString();
                    this.EmpId = in.readString();
                    this.IdCard = in.readString();
                    this.Sex = in.readInt();
                    this.Age = in.readInt();
                    this.Address = in.readString();
                    this.Phone = in.readString();
                    this.CreateTime = in.readString();
                    this.State = in.readInt();
                    this.Password = in.readString();
                }

                public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
                    @Override
                    public UserBean createFromParcel(Parcel source) {
                        return new UserBean(source);
                    }

                    @Override
                    public UserBean[] newArray(int size) {
                        return new UserBean[size];
                    }
                };
            }

            public static class CardBean implements Parcelable {
                /**
                 * Id : e8fb492d-0ff4-4669-85f3-71b48cf8ce37
                 * UserId : 89ed63e2-783d-461e-b2ff-17871cb3bcdd
                 * Number : 31
                 * SerialNo : test01
                 * Type : 1
                 * Level : 0
                 * Cost : 0
                 * Deadline : 2119-01-01 00:00:00
                 * PayCount : 0
                 * LastSubsidyDate : 2020-06-09 10:31:31
                 * CreateTime : 2020-07-09 10:31:31
                 * IsGot : true
                 * State : 1
                 * LastPayDateTime : null
                 */

                private String Id;
                private String UserId;
                private int Number;
                private String SerialNo;
                private int Type;
                private int Level;
                private int Cost;
                private String Deadline;
                private int PayCount;
                private String LastSubsidyDate;
                private String CreateTime;
                private boolean IsGot;
                private int State;
                private String LastPayDateTime;

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

                public String getSerialNo() {
                    return SerialNo;
                }

                public void setSerialNo(String SerialNo) {
                    this.SerialNo = SerialNo;
                }

                public int getType() {
                    return Type;
                }

                public void setType(int Type) {
                    this.Type = Type;
                }

                public int getLevel() {
                    return Level;
                }

                public void setLevel(int Level) {
                    this.Level = Level;
                }

                public int getCost() {
                    return Cost;
                }

                public void setCost(int Cost) {
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

                public String getCreateTime() {
                    return CreateTime;
                }

                public void setCreateTime(String CreateTime) {
                    this.CreateTime = CreateTime;
                }

                public boolean isIsGot() {
                    return IsGot;
                }

                public void setIsGot(boolean IsGot) {
                    this.IsGot = IsGot;
                }

                public int getState() {
                    return State;
                }

                public void setState(int State) {
                    this.State = State;
                }

                public String getLastPayDateTime() {
                    return LastPayDateTime;
                }

                public void setLastPayDateTime(String LastPayDateTime) {
                    this.LastPayDateTime = LastPayDateTime;
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
                    dest.writeString(this.SerialNo);
                    dest.writeInt(this.Type);
                    dest.writeInt(this.Level);
                    dest.writeInt(this.Cost);
                    dest.writeString(this.Deadline);
                    dest.writeInt(this.PayCount);
                    dest.writeString(this.LastSubsidyDate);
                    dest.writeString(this.CreateTime);
                    dest.writeByte(this.IsGot ? (byte) 1 : (byte) 0);
                    dest.writeInt(this.State);
                    dest.writeString(this.LastPayDateTime);
                }

                public CardBean() {
                }

                protected CardBean(Parcel in) {
                    this.Id = in.readString();
                    this.UserId = in.readString();
                    this.Number = in.readInt();
                    this.SerialNo = in.readString();
                    this.Type = in.readInt();
                    this.Level = in.readInt();
                    this.Cost = in.readInt();
                    this.Deadline = in.readString();
                    this.PayCount = in.readInt();
                    this.LastSubsidyDate = in.readString();
                    this.CreateTime = in.readString();
                    this.IsGot = in.readByte() != 0;
                    this.State = in.readInt();
                    this.LastPayDateTime = in.readString();
                }

                public static final Creator<CardBean> CREATOR = new Creator<CardBean>() {
                    @Override
                    public CardBean createFromParcel(Parcel source) {
                        return new CardBean(source);
                    }

                    @Override
                    public CardBean[] newArray(int size) {
                        return new CardBean[size];
                    }
                };
            }

            public static class FinancesBean {
                /**
                 * UserId : 89ed63e2-783d-461e-b2ff-17871cb3bcdd
                 * Kind : 0
                 * Balance : 10000
                 */

                private String UserId;
                private int Kind;
                private double Balance;

                public String getUserId() {
                    return UserId;
                }

                public void setUserId(String UserId) {
                    this.UserId = UserId;
                }

                public int getKind() {
                    return Kind;
                }

                public void setKind(int Kind) {
                    this.Kind = Kind;
                }

                public double getBalance() {
                    return Balance;
                }

                public void setBalance(double Balance) {
                    this.Balance = Balance;
                }
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeParcelable(this.UserFace, flags);
                dest.writeParcelable(this.User, flags);
                dest.writeParcelable(this.Card, flags);
                dest.writeList(this.Finances);
            }

            public RowsBean() {
            }

            protected RowsBean(Parcel in) {
                this.UserFace = in.readParcelable(UserFaceBean.class.getClassLoader());
                this.User = in.readParcelable(UserBean.class.getClassLoader());
                this.Card = in.readParcelable(CardBean.class.getClassLoader());
                this.Finances = new ArrayList<FinancesBean>();
                in.readList(this.Finances, FinancesBean.class.getClassLoader());
            }

            public static final Creator<RowsBean> CREATOR = new Creator<RowsBean>() {
                @Override
                public RowsBean createFromParcel(Parcel source) {
                    return new RowsBean(source);
                }

                @Override
                public RowsBean[] newArray(int size) {
                    return new RowsBean[size];
                }
            };
        }
    }
}
