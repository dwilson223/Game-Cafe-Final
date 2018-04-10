/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecafefinal;

/**
 *
 * @author kayaya
 */
public class Member {
    private int memberid;
    private String firstname;
    private String lastname;
    private String nickname;
    private int age;
    private String dob;
    private String type;
    private String addressline1;
    private String addressline2;
    private String city;
    private String country;
    private String postcode;

    public Member(int memberid, String firstname, String lastname, String nickname, int age, String dob, String type, String addressline1, String addressline2, String city, String country, String postcode) {
        this.memberid = memberid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.age = age;
        this.dob = dob;
        this.type = type;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    
    public boolean checkID(int number){
        if(number > 0){
            return true;
        }
        return false;
    }
    
    public boolean checkAge(int number){
        if(number > 0 && number < 100){
            return true;
        }
        return false;
    }
      
    
}
