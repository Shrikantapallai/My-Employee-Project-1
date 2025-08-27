package com.shri.demo.pojo;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeeAdress {
    private String houseNo;
    private String streetname;
    private String postoffice;
    private String pincode;
    public EmployeeAdress(){

    }
    public EmployeeAdress(String houseNo,String streetname,String postoffice,String pincode){
        this.houseNo=houseNo;
        this.streetname=streetname;
        this.postoffice=postoffice;
        this.pincode=pincode;
    }

    public String getHouseNo() {
        return houseNo;
    }
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
    public String getStreetname() {
        return streetname;
    }
    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getPostoffice() {
        return postoffice;
    }

    public void setPostoffice(String postoffice) {
        this.postoffice = postoffice;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "EmployeeAdress{" +
                "houseNo='" + houseNo + '\'' +
                ", streetname='" + streetname + '\'' +
                ", postoffice='" + postoffice + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}
