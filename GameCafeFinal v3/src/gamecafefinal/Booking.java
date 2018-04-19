package gamecafefinal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kayaya
 */
public class Booking {
    /*Hello My name is Fufito*/

    private int gamebookid;
    private int price;
    private String duration;
    private String memberid;

 public Booking(int gamebookid, int price, String duration, String memberid) {
        this.gamebookid = gamebookid;
        this.price = price;
        this.duration = duration;  
        this.memberid = memberid;
        

    }
 private int getgamebookid() {
        return gamebookid;
    }

 public void setgamebookid(int gamebookid) {
        this.gamebookid = gamebookid;
    }
 
 
  public int getprice() {
        return price;
    }

 public void setprice(int price) {
        this.price = price;
    }
 
 
  public String getduration() {
        return duration;
    }

 public void setduration(String duration) {
        this.duration = duration;
    }
 
  
  public String getmemberid() {
        return memberid;
    }

 public void setmemberid(String memberid) {
        this.memberid = memberid;
    }
 


}

