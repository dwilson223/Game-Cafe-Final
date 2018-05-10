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
    private String date;
    private String time;
    private String avablilty;



   public Event(int eventid, String type, String description, String date, String time, String avablilty) {
        this.eventid = eventid;
        this.type = type;
        this.description = description;
        this.date = date;
        this.time = time;
        this.avablilty = avablilty;
        
    }

    public int geteventid() {
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
    
      public String gettime() {
        return time;
    }
    public void settime(String time) {
        this.time = time;
    }
      public String getavablilty() {
        return avablilty;
    }

    public void setavablilty(String avablilty) {
        this.avablilty = avablilty;
    }
      public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }
    
    
}