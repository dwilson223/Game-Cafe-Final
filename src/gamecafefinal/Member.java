/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecafefinal;

/**
 *
 * @author Dave
 */
public class Member {
    
    private int memberId;
    private String firstName;
    private String lastName;
    private String nickname;
    private int age;
    private String dob;
    private String type;
    private String address1;
    private String address2;
    private String city;
    private String country;
    private String postcode;

    public Member(int memberId, String firstName, String lastName, String nickname, int age, String dob, String type, String address1, String address2, String city, String country, String postcode) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.age = age;
        this.dob = dob;
        this.type = type;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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
    
    public boolean checkmemberId(int number){
        if(number > 0){
            return true;
        }
        return false;
    }
    public boolean checkmemberid(int number){
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
