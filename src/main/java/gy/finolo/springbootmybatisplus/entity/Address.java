package gy.finolo.springbootmybatisplus.entity;

import java.io.Serializable;

public class Address implements Serializable {
    private String id;

    private String identityNumber;

    private String location;

    private String receiver;

    private String mobile;

    private Integer provinceId;

    private Boolean giveup;

    private static final long serialVersionUID = 1L;

    public Address(String id, String identityNumber, String location, String receiver, String mobile, Integer provinceId, Boolean giveup) {
        this.id = id;
        this.identityNumber = identityNumber;
        this.location = location;
        this.receiver = receiver;
        this.mobile = mobile;
        this.provinceId = provinceId;
        this.giveup = giveup;
    }

    public Address() {
        super();
    }

    public String getId() {
        return id;
    }

    public Address withId(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public Address withIdentityNumber(String identityNumber) {
        this.setIdentityNumber(identityNumber);
        return this;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber == null ? null : identityNumber.trim();
    }

    public String getLocation() {
        return location;
    }

    public Address withLocation(String location) {
        this.setLocation(location);
        return this;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public Address withReceiver(String receiver) {
        this.setReceiver(receiver);
        return this;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public Address withMobile(String mobile) {
        this.setMobile(mobile);
        return this;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public Address withProvinceId(Integer provinceId) {
        this.setProvinceId(provinceId);
        return this;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Boolean getGiveup() {
        return giveup;
    }

    public Address withGiveup(Boolean giveup) {
        this.setGiveup(giveup);
        return this;
    }

    public void setGiveup(Boolean giveup) {
        this.giveup = giveup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", identityNumber=").append(identityNumber);
        sb.append(", location=").append(location);
        sb.append(", receiver=").append(receiver);
        sb.append(", mobile=").append(mobile);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", giveup=").append(giveup);
        sb.append("]");
        return sb.toString();
    }
}