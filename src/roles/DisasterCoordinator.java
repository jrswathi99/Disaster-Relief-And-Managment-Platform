/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roles;

/**
 *
 * @author DELL
 */
import model.WorkRequest;
import utils.IDGenerator;

import java.util.ArrayList;
import java.util.List;
import model.Role;
import model.Camp;
import model.Place;
import model.ResourceManager;
import model.SecurityResourceManager;
import model.RescueResourceManager;
import model.Zone;

public class DisasterCoordinator extends Role {

    private static DisasterCoordinator instance;
    private ArrayList<WorkRequest> workRequests;
    private List<Place> places;
    String name;

    public DisasterCoordinator() {
        super("DisasterCoordinator");
        workRequests = new ArrayList<>();
        places = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void initiateWorkRequest(String id, String description, String name, String priority) {
        WorkRequest request = new WorkRequest(IDGenerator.generateID(), description, name, priority);

        // Adding default zones
        request.setZones(List.of(
                new Zone("Zone A", "Medium"),
                new Zone("Zone B", "Medium"),
                new Zone("Zone C", "Medium"),
                new Zone("Zone D", "Medium")
        ));

        workRequests.add(request);

        System.out.println("Work request created: " + request.getDescription() + " with Priority: " + request.getPriority());
    }

    public boolean placeExists(String placeName) {
        if (places == null) {
            return false; // No places exist
        }
        for (Place place : places) { // Assuming `places` is the list of Place objects
            if (place.getName().equalsIgnoreCase(placeName)) {
                return true;
            }
        }
        return false;
    }

    public boolean disasterExists(String disasterName) {
        for (WorkRequest disaster : this.workRequests) { // Assuming `workRequests` holds disasters
            if (disaster.getName().equalsIgnoreCase(disasterName)) {
                return true;
            }
        }
        return false;
    }

    public static DisasterCoordinator getInstance() {
        if (instance == null) {
            instance = new DisasterCoordinator();
        }
        return instance;
    }

    // Retrieve all work requests
    public ArrayList<WorkRequest> getWorkRequests() {
        return workRequests;
    }

    // Retrieve disasters (work requests) by name
    public ArrayList<WorkRequest> getDisasters() {
        return workRequests;
    }

    // Get zones for a specific disaster
    public List<Zone> getZonesByDisaster(String disasterName) {
        for (WorkRequest workRequest : workRequests) {
            if (workRequest.getName().equals(disasterName)) {
                return workRequest.getZones();
            }
        }
        return new ArrayList<>();
    }

    public boolean setDisasterPriority(String disasterName, String newPriority) {
        for (WorkRequest disaster : workRequests) {
            if (disaster.getName().equals(disasterName)) {
                disaster.setPriority(newPriority);
                return true;
            }
        }
        return false;
    }

    public String getDisasterPriority(String disasterName) {
        for (WorkRequest disaster : workRequests) {
            if (disaster.getName().equals(disasterName)) {
                return disaster.getPriority(); // Assuming WorkRequest has a getPriority() method
            }
        }
        return null; // Return null if the disaster is not found
    }

    public String getZonePriorityForDisaster(String zoneName, String disasterName) {
        for (WorkRequest disaster : workRequests) {
            if (disaster.getName().equalsIgnoreCase(disasterName)) {
                for (Zone zone : disaster.getZones()) {
                    if (zone.getName().equalsIgnoreCase(zoneName)) {
                        return zone.getPriority();
                    }
                }
            }
        }
        return null; // No priority found
    }

    public void assignZoneManager(String placeName, String zoneName, ZoneManager manager) {
        for (Place place : getPlaces()) { // Assuming getPlaces() returns the list of places
            if (place.getName().equalsIgnoreCase(placeName)) {
                for (Zone zone : place.getZones()) {
                    if (zone.getName().equalsIgnoreCase(zoneName)) {
                        zone.setManager(manager);
                        System.out.println("ZoneManager assigned to zone: " + zoneName);
                        return;
                    }
                }
            }
        }
        System.out.println("Zone or Place not found.");
    }

    public String getZonePriority(String placeName, String zoneName) {
        for (Place place : places) { // Ensure `places` is the list of all places managed by the DisasterCoordinator
            if (place.getName().equalsIgnoreCase(placeName)) {
                for (Zone zone : place.getZones()) {
                    if (zone.getName().equalsIgnoreCase(zoneName)) {
                        return zone.getPriority();
                    }
                }
            }
        }
        return "Not Found"; // Return a default message or priority if the zone is not found
    }

    // Add zones to a specific disaster
    public void addZonesToDisaster(String disasterName, List<Zone> zones) {
        for (WorkRequest workRequest : workRequests) {
            if (workRequest.getName().equals(disasterName)) {
                workRequest.getZones().addAll(zones);
                System.out.println("Zones added to disaster: " + disasterName);
                return;
            }
        }
        System.out.println("Disaster not found: " + disasterName);
    }

    // Add a camp to a specific zone
    public void addCampToZone(String zoneName, Camp camp) {
        for (WorkRequest workRequest : workRequests) {
            for (Zone z : workRequest.getZones()) {
                if (z.getName().equals(zoneName)) {
                    z.getCamps().add(camp);
                    System.out.println("Camp added to zone: " + zoneName);
                    return;
                }
            }
        }
        System.out.println("Zone not found: " + zoneName);
    }

    public void addPlace(Place place) {
        places.add(place);
    }

    public List<Zone> getZonesForPlace(String placeName) {
        for (Place place : places) {
            if (place.getName().equals(placeName)) {
                return place.getZones();
            }
        }
        return new ArrayList<>(); // Return empty list if place not found
    }

    // Method to get camps for a specific zone
    public List<Camp> getCampsForZone(String zoneName) {
        for (Place place : places) {
            for (Zone zone : place.getZones()) {
                if (zone.getName().equals(zoneName)) {
                    return zone.getCamps();
                }
            }
        }
        return new ArrayList<>(); // Return empty list if zone not found
    }

    // Get camps for a specific zone
    public List<Camp> getCampsByZone(String zoneName) {
        for (WorkRequest workRequest : workRequests) {
            for (Zone z : workRequest.getZones()) {
                if (z.getName().equals(zoneName)) {
                    return z.getCamps();
                }
            }
        }
        return new ArrayList<>();
    }

    public Zone getZoneByName(String zoneName) {
        for (Place place : places) {
            for (Zone zone : place.getZones()) {
                if (zone.getName().equals(zoneName)) {
                    return zone;
                }
            }
        }
        return null; // Return null if no matching zone is found
    }

    public void requestResource(SecurityResourceManager resourceManager, String resourceType, int quantity) {
        try {
            resourceManager.createRequest(this.getRoleName(), resourceType, quantity);
            System.out.println("Resource request submitted: " + resourceType + " (Quantity: " + quantity + ")");
        } catch (IllegalArgumentException e) {
            System.out.println("Error submitting resource request: " + e.getMessage());
        }
    }
    
     public void requestRescueResource(RescueResourceManager resourceManager, String resourceType, int quantity) {
        try {
            resourceManager.createRequest(this.getRoleName(), resourceType, quantity);
            System.out.println("Resource request submitted: " + resourceType + " (Quantity: " + quantity + ")");
        } catch (IllegalArgumentException e) {
            System.out.println("Error submitting resource request: " + e.getMessage());
        }
    }

    public boolean useResource(SecurityResourceManager resourceManager, String resourceType, int quantity) {
        // Check if the resource is available in sufficient quantity
        int availableQuantity = resourceManager.getAvailableQuantity(resourceType);
        if (availableQuantity >= quantity) {
            // Consume the resource
            resourceManager.consumeResource(resourceType, quantity);
            return true; // Indicate success
        } else {
            return false; // Indicate failure
        }
    }
    
     public boolean useRescueResource(RescueResourceManager resourceManager, String resourceType, int quantity) {
        // Check if the resource is available in sufficient quantity
        int availableQuantity = resourceManager.getAvailableQuantity(resourceType);
        if (availableQuantity >= quantity) {
            // Consume the resource
            resourceManager.consumeResource(resourceType, quantity);
            return true; // Indicate success
        } else {
            return false; // Indicate failure
        }
    }

    // Set priority for a specific zone
    public boolean setZonePriority(String zoneName, String newPriority) {
        for (WorkRequest workRequest : workRequests) {
            for (Zone z : workRequest.getZones()) {
                if (z.getName().equals(zoneName)) {
                    z.setPriority(newPriority);
                    System.out.println("Priority updated for zone: " + zoneName);
                    return true;
                }
            }
        }
        return false;
    }

    public List<Place> getPlaces() {
        return places;
    }

    // Set status for a specific camp
    public void setCampStatus(String campName, String status) {
        for (WorkRequest workRequest : workRequests) {
            for (Zone z : workRequest.getZones()) {
                for (Camp c : z.getCamps()) {
                    if (c.getName().equals(campName)) {
                        c.setStatus(status);
                        System.out.println("Camp status updated: " + campName + " -> " + status);
                        return;
                    }
                }
            }
        }
        System.out.println("Camp not found: " + campName);
    }

    @Override
    public void performRoleSpecificWork() {
        System.out.println("Disaster Coordinator managing disasters and resources...");
    }
}
