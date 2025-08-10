/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roles;

/**
 *
 * @author DELL
 */
import java.util.ArrayList;
import java.util.List;
import model.Camp;
import model.Place;
import model.Role;
import model.WorkRequest;
import model.Zone;

public class ZoneManager extends Role {
    private List<Zone> zones;
    private DisasterCoordinator disasterCoordinator;
    private String managerName;
    private String assignedPlace;
    private String assignedZone;

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getAssignedPlace() {
        return assignedPlace;
    }
    
    
    public void setAssignedPlace(String assignedPlace) {
        this.assignedPlace = assignedPlace;
    }
    public Zone getZoneForCamp(String campName) {
    for (Zone zone : this.getZones()) {
        for (Camp camp : zone.getCamps()) {
            if (camp.getName().equals(campName)) {
                return zone;
            }
        }
    }
    return null; // Return null if no matching zone is found
}

    public String getAssignedZone() {
        return assignedZone;
    }

    public void setAssignedZone(String assignedZone) {
        this.assignedZone = assignedZone;
    }
    
    public ZoneManager(DisasterCoordinator disasterCoordinator) {
        super("ZoneManager"); // Set the role name
        zones = new ArrayList<>();
        this.disasterCoordinator=disasterCoordinator;
    }
    public ZoneManager(String managerName) {
        super("ZoneManager");
        this.managerName = managerName;
    }
   
     public List<Camp> getCampsByZone(String zoneName) {
        Zone zone = disasterCoordinator.getZoneByName(zoneName);
        if (zone != null) {
            return zone.getCamps();
        }
        return new ArrayList<>(); // Return an empty list if no zone is found
    }

    public void addCampToZone(String zoneName, Camp camp) {
        Zone zone = disasterCoordinator.getZoneByName(zoneName);
        if (zone != null) {
            zone.addCamp(camp);
        }
    }
    public String getName() {
        return managerName;
    }
    
    public List<Zone> getZones() {
        return zones;
    }

    public void addZone(Zone zone) {
        zones.add(zone);
    }

    public void setZonePriority(String zoneName, String newPriority) {
        for (Zone zone : zones) {
            if (zone.getName().equals(zoneName)) {
                zone.setPriority(newPriority);
                break;
            }
        }
    }
    
     public DisasterCoordinator getDisasterCoordinator() {
        return disasterCoordinator;
    }
    
    public void coordinateWithCamp(String campId) {
        System.out.println("Coordinating with camp: " + campId);
    }

    public void createSubRequest(WorkRequest parentRequest, String subRequestDescription) {
        System.out.println("Creating sub-request under Request ID: " + parentRequest.getId());
    }

    @Override
    public void performRoleSpecificWork() {
        System.out.println("Zone Manager coordinating disaster zone activities...");
    }
    
    public void setCampStatus(String campName, String newStatus) {
    // Iterate through all the places and their zones
    for (Place place : disasterCoordinator.getPlaces()) {
        for (Zone zone : place.getZones()) {
            for (Camp camp : zone.getCamps()) {
                if (camp.getName().equalsIgnoreCase(campName)) {
                    // Update the status of the camp
                    camp.setStatus(newStatus);
                    return; // Exit after updating
                }
            }
        }
    }
    throw new IllegalArgumentException("Camp with name " + campName + " not found.");
}
    public List<WorkRequest> getDisasters() {
    if (disasterCoordinator == null) {
        throw new IllegalStateException("DisasterCoordinator is not initialized for this ZoneManager.");
    }
    return disasterCoordinator.getDisasters();
}
}
