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
public class Hardware {
    
    private int hardwareid;
    private String console;
    private String monitor;
 
    
    
      public Hardware(int hardwareid, String console, String monitor) {
        this.hardwareid = hardwareid;
        this.console = console;
        this.monitor = monitor;    
    }
    
   private int gethardwareid() {
        return hardwareid;
    }

 public void sethardwareid(int hardwareid) {
        this.hardwareid = hardwareid;
    }
 
  public String getconsole() {
        return console;
    }

 public void setconsole(String console) {
        this.console = console;
    }
 
  public String getmonitor() {
        return monitor;
    }

 public void setmonitor(String monitor) {
        this.monitor = monitor;
    }
   
    
}
