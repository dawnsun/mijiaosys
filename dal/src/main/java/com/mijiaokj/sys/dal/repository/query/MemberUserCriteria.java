package com.mijiaokj.sys.dal.repository.query;

/**
 * Created by Administrator on 2017/7/2.
 */
public class MemberUserCriteria extends BaseQueryCriteria {
    private String memberName;

    private String phoneNumber;

    private String memberCardNumber;

    private Long memberTypeId;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberCardNumber() {
        return memberCardNumber;
    }

    public void setMemberCardNumber(String memberCardNumber) {
        this.memberCardNumber = memberCardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getMemberTypeId() {
        return memberTypeId;
    }

    public void setMemberTypeId(Long memberTypeId) {
        this.memberTypeId = memberTypeId;
    }
}
