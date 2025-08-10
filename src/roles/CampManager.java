/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roles;

import java.util.ArrayList;
import java.util.List;
import model.Role;
import model.Camp;
import model.Zone;

/**
 *
 * @author DELL
 */
public class CampManager extends Role {
    private List<Camp> camps;
     private ZoneManager zoneManager;
    
    public CampManager(ZoneManager zoneManager) {
        super("CampManager"); // Set the role name
        this.camps = new ArrayList<>();
        this.zoneManager = zoneManager;
    }

    public ZoneManager getZoneManager() {
        return zoneManager;
    }

    public void setZoneManager(ZoneManager zoneManager) {
        this.zoneManager = zoneManager;
    }
    public List<Camp> getCamps() {
        return camps;
    }

    public void addCamp(Camp camp) {
        camps.add(camp);
    }

    public void setCampStatus(String campName, String status) {
        for (Camp camp : camps) {
            if (camp.getName().equals(campName)) {
                camp.setStatus(status);
                break;
            }
        }
    }
    public void manageCapacity(int currentCapacity, int maxCapacity) {
        if (currentCapacity >= maxCapacity) {
            System.out.println("Camp is at full capacity. No new entries allowed.");
        } else {
            System.out.println("Current camp capacity: " + currentCapacity + "/" + maxCapacity);
        }
    }

    public void requestAdditionalResources(String resourceName, int quantity) {
        System.out.println("Requesting additional resources: " + resourceName + " (Quantity: " + quantity + ")");
    }

    @Override
    public void performRoleSpecificWork() {
        System.out.println("Camp Manager overseeing camp operations...");
    }
    

}
