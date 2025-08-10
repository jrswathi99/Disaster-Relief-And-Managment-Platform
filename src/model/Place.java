/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Place {
     private String name;
    private List<Zone> zones;

    public Place(String name) {
        this.name = name;
        zones = new ArrayList<>();
        initializeZones();
    }
    
    public void initializeZones() {
        // Fixed zones for every place
        zones.add(new Zone("Zone A", "Medium"));
        zones.add(new Zone("Zone B", "Medium"));
        zones.add(new Zone("Zone C", "Medium"));
        zones.add(new Zone("Zone D", "Medium"));
    }
    
    public String getName() {
        return name;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void addZone(Zone zone) {
        zones.add(zone);
    }
}
