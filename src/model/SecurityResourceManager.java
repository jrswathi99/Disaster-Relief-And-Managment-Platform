/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SecurityResourceManager {
     private Map<String, Integer> resourceInventory; // Stores available resources and their quantities
    private List<ResourceRequest> resourceRequests;
     private Map<String, Integer> assignedInventory;

 

    public SecurityResourceManager() {
        this.resourceInventory = new HashMap<>();
        this.assignedInventory = new HashMap<>();
        this.resourceRequests = new ArrayList<>();
    }

    // Add resources to inventory
    public void addResource(String resourceType, int quantity) {
        resourceInventory.put(resourceType, resourceInventory.getOrDefault(resourceType, 0) + quantity);
        System.out.println("Resource added: " + resourceType + " (Quantity: " + quantity + ")");
    }
    
    public List<ResourceRequest> getRequestsByRole(String roleName) {
    List<ResourceRequest> filteredRequests = new ArrayList<>();
    for (ResourceRequest request : resourceRequests) {
        if (request.getRequestedBy().equals(roleName)) {
            filteredRequests.add(request);
        }
    }
    return filteredRequests;
}
    public ResourceRequest createRequest(String requestedBy, String resourceType, int quantity) {
    if (resourceType == null || resourceType.trim().isEmpty() || quantity <= 0) {
        throw new IllegalArgumentException("Invalid resource type or quantity.");
    }
    
    

    String requestId = UUID.randomUUID().toString(); // Generate a unique ID
    ResourceRequest newRequest = new ResourceRequest(requestId, resourceType, quantity, requestedBy);
    resourceRequests.add(newRequest); // Add to the list of requests
    System.out.println("Request created: " + newRequest);
    return newRequest;
}
    // Allocate resources to a request
    public boolean allocateResource(String resourceType, int quantityToAllocate) {
        if (!resourceInventory.containsKey(resourceType)) {
            System.out.println("Error: Resource type " + resourceType + " not found in inventory.");
            return false;
        }

        int availableQuantity = resourceInventory.get(resourceType);
        if (availableQuantity >= quantityToAllocate) {
            resourceInventory.put(resourceType, availableQuantity - quantityToAllocate);
            assignedInventory.put(resourceType, quantityToAllocate);
            return true;
        } else {
            System.out.println("Error: Insufficient quantity of " + resourceType);
            return false;
        }
    }

    // Get available quantity of a specific resource
    public int getAvailableQuantity(String resourceType) {
        return resourceInventory.getOrDefault(resourceType, 0);
    }
     public int getAssignedQuantity(String resourceType) {
        return assignedInventory.getOrDefault(resourceType, 0);
    }

    // Add a new resource request
    public void addRequest(ResourceRequest request) {
        resourceRequests.add(request);
        System.out.println("Resource request added: " + request);
    }

    // Get a resource request by ID
    public ResourceRequest getRequestById(String requestId) {
        for (ResourceRequest request : resourceRequests) {
            if (request.getId().equals(requestId)) {
                return request;
            }
        }
        return null;
    }

    // List all available resources
    public void listResources() {
        System.out.println("Available Resources:");
        for (Map.Entry<String, Integer> entry : resourceInventory.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }
     public boolean consumeResource(String resourceType, int quantityUsed) {
        if (!resourceInventory.containsKey(resourceType)) {
            System.out.println("Error: Resource type " + resourceType + " not found.");
            return false;
        }

       int availableQuantity = assignedInventory.get(resourceType);
        if (availableQuantity >= quantityUsed) {
            assignedInventory.put(resourceType, availableQuantity - quantityUsed);
            System.out.println("Consumed " + quantityUsed + " units of " + resourceType);
            return true;
        } else {
            System.out.println("Error: Insufficient quantity of " + resourceType);
            return false;
        }
    }
     public void listRequestsForRole(String roleName) {
    System.out.println("Listing resource requests for role: " + roleName);
    for (ResourceRequest request : resourceRequests) {
        if (request.getRequestedBy().equals(roleName)) {
            System.out.println("- " + request);
        }
    }
}
   public ResourceRequest createRequest(String resourceType, int quantityRequested, String requestedBy) {
        String requestId = UUID.randomUUID().toString(); // Generate unique ID for the request
        ResourceRequest request = new ResourceRequest(requestId, resourceType, quantityRequested, requestedBy);
        resourceRequests.add(request);
        return request;
    }
   
    // List all resource requests
    public void listRequests() {
        System.out.println("All Resource Requests:");
        for (ResourceRequest request : resourceRequests) {
            System.out.println(request);
        }
    }
    
    
    public Map<String, Integer> listAvailableResources() {
    return new HashMap<>(resourceInventory);
}
    public List<ResourceRequest> getAllRequests() {
    return new ArrayList<>(resourceRequests);
}

}

