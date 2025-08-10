/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import roles.CampManager;

/**
 *
 * @author DELL
 */
public class Camp {
     private String name;
    private String status;
    private int capacity;
    private int occupied;
    
    private CampManager manager;
    
    public CampManager getManager() {
        return manager;
    }

    public void setManager(CampManager manager) {
        this.manager = manager;
    }
    

    public Camp(String name, String status, int capacity, int occupied) {
        this.name = name;
        this.status = status;
        this.capacity = capacity;
        this.occupied = occupied;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        if (occupied <= capacity) {
            this.occupied = occupied;
        } else {
            throw new IllegalArgumentException("Occupied capacity cannot exceed total capacity.");
        }
    }
    
    public int getAvailableCapacity() {
        return (capacity+occupied) - occupied;
    }

//    // Override toString for easier display
//    @Override
//    public String toString() {
//        return "Camp{" +
//                "name='" + name + '\'' +
//                ", status='" + status + '\'' +
//                ", capacity=" + capacity +
//                ", occupied=" + occupied +
//                '}';
//    }
}
