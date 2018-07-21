package com.tt.recyclenow.bean;

/**
 * @author tutu
 * @time 2018/7/21
 */

public class SFZMBean {
    private String address;//地址
    private String id_card_number;//身份照吗
    private String race;//名族
    private String gender;//性别


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId_card_number() {
        return id_card_number;
    }

    public void setId_card_number(String id_card_number) {
        this.id_card_number = id_card_number;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "SFZMBean{" +
                "address='" + address + '\'' +
                ", id_card_number='" + id_card_number + '\'' +
                ", race='" + race + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
