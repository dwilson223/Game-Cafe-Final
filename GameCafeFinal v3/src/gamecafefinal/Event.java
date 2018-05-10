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
public class Event {
    
     private int eventid;
    private String type;
    private String description;
    private int time;
    private int avablilty;
    private String date;



   public Event(int eventid, String type, String description, int time, int avablilty, String date) {
        this.eventid = eventid;
        this.type = type;
        this.description = description;
        this.time = time;
        this.avablilty = avablilty;
        this.date = date;
        
    }

 private int geteventid() {
        return eventid;
    }

 public void seteventid(int eventid) {
        this.eventid = eventid;
    }
    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }
    
    
      public String gedescription() {
        return description;
    }

    public void settdescription(String description) {
        this.description = description;
    }
    
      public int gettime() {
        return time;
    }
    public void settime(int time) {
        this.time = time;
    }
      public int getavablilty() {
        return avablilty;
    }

    public void setavablilty(int avablilty) {
        this.avablilty = avablilty;
    }
      public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }
    
    
}