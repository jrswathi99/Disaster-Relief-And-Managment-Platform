/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import roles.ZoneManager;

/**
 *
 * @author DELL
 */
public class Zone {
     private String name;
    private String priority;
    private ZoneManager manager;
    private List<Camp> camps;

    public Zone(String name, String priority) {
        this.name = name;
        this.priority = priority;
        camps = new ArrayList<>();
        initializeCamps();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setManager(ZoneManager manager) {
        this.manager = manager;
    }

    public void setCamps(List<Camp> camps) {
        this.camps = camps;
    }

    public String getName() {
        return name;
    }

    public String getPriority() {
        return priority;
    }

    public ZoneManager getManager() {
        return manager;
    }

    public List<Camp> getCamps() {
        return camps;
    }
    public void addCamp(Camp camp) {
        camps.add(camp);
    }
    
    private void initializeCamps() {
        // Fixed camps for every zone
        camps.add(new Camp("Camp " + name + "A", "Open", 100, 100));
        camps.add(new Camp("Camp " + name + "B", "Open", 100, 100));
        camps.add(new Camp("Camp " + name + "C", "Open", 100, 100));
        camps.add(new Camp("Camp " + name + "D", "Open", 100, 100));
    }
    

    
}
