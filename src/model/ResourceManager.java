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

public class ResourceManager {
     private Map<String, Integer> resourceInventory; // Stores available resources and their quantities
    private List<ResourceRequest> resourceRequests;
    private Map<String, Integer> availableResources;
    private List<ResourceRequest> fulfilledRequests= new ArrayList<>();
    private Map<String, List<ResourceRequest>> fulfilledRequestsByRole = new HashMap<>();
    
    public ResourceManager() {
        this.resourceInventory = new HashMap<>();
        this.resourceRequests = new ArrayList<>();
        this.availableResources = new HashMap<>();
    }
    
    public void addResource(String resourceType, int quantity) {
        int currentQuantity = availableResources.getOrDefault(resourceType, 0);
    
        // Prevent negative initial state
        if (currentQuantity < 0) {
            currentQuantity = 0;
        }
    
        System.out.println("Adding resource: Type = " + resourceType + ", Current Quantity = " + currentQuantity + ", Adding Quantity = " + quantity);
    
        availableResources.put(resourceType, quantity-currentQuantity);
    
        System.out.println("After addition: Resource Type = " + resourceType + ", New Quantity = " + (quantity-currentQuantity));
    }
     
     public List<ResourceRequest> getFulfilledRequestsByRole(String roleName) {
    return fulfilledRequestsByRole.getOrDefault(roleName, new ArrayList<>());
}
public void markRequestAsFulfilled(ResourceRequest request) {
    fulfilledRequests.add(request); // Track globally

    // Track by role
    String roleName = request.getRequestedBy();
    fulfilledRequestsByRole.putIfAbsent(roleName, new ArrayList<>());
    fulfilledRequestsByRole.get(roleName).add(request);

    System.out.println("Marked request as fulfilled: " + request);
}
    
   public boolean approveRequest(String requestId, double totalCost, Budget budget) {
    for (ResourceRequest request : resourceRequests) {
        if (request.getId() != null && request.getId().equals(requestId) && request.getStatus().equals("Pending")) {
            double remainingBudget = budget.getRemainingBudget();
            if (remainingBudget >= totalCost) {
                budget.allocateFunds(totalCost); // Deduct funds from the budget
                request.setStatus("Approved"); // Mark the request as approved
                return true;
            } else {
                return false; // Insufficient budget
            }
        }
    }
    return false; // Request not found or invalid
}

     public void updateRequestStatus(String requestId, String status) {
    for (ResourceRequest request : resourceRequests) {
        if (request.getId().equals(requestId)) {
            request.setStatus(status);
            return;
        }
    }
    System.out.println("Request not found for ID: " + requestId);
}
public boolean allocateResource(String resourceType, int quantity) {
    int currentQuantity = availableResources.getOrDefault(resourceType, 0);

    System.out.println("Before allocation: Resource Type = " + resourceType + ", Current Quantity = " + currentQuantity + ", Requested Quantity = " + quantity);

    if (currentQuantity >= quantity) {
        availableResources.put(resourceType, currentQuantity );

        System.out.println("After allocation: Resource Type = " + resourceType + ", Remaining Quantity = " + (currentQuantity ));

        return true;
    } else {
        System.out.println("Allocation failed: Insufficient quantity for " + resourceType);
    }

    return false;
}

    // Get available resources
    public Map<String, Integer> getAvailableResources() {
        return availableResources;
    }

    // Example: Check available quantity for a specific resource type
    public int getAvailableQuantity(String resourceType) {
        return availableResources.getOrDefault(resourceType, 0);
    }
    
   public List<ResourceRequest> getRequestsByRole(String roleName) {
    List<ResourceRequest> filteredRequests = new ArrayList<>();
    for (ResourceRequest request : resourceRequests) {
        if (roleName.equals(request.getRequestedBy())) { // Avoid NullPointerException
            filteredRequests.add(request);
        }
    }
    return filteredRequests;
}
 
public void moveApprovedRequestToResources(String requestId) {
    for (ResourceRequest request : resourceRequests) {
        if (request.getId().equals(requestId) && "Approved".equals(request.getStatus())) {
            String resourceType = request.getResourceType();
            int quantity = request.getQuantityRequested();

            System.out.println("Processing approved request: ID = " + requestId + ", Resource Type = " + resourceType + ", Quantity = " + quantity);

            // Check the current quantity before adding
            System.out.println("Current Quantity Before Adding: " + availableResources.getOrDefault(resourceType, 0));

            addResource(resourceType, quantity); // Add to available resources
            request.setStatus("Fulfilled"); // Mark request as fulfilled

            // Log after adding the resource
            System.out.println("Resource added: Type = " + resourceType + ", New Quantity = " + availableResources.get(resourceType));

            // Mark the request as fulfilled and associate it with the role
            markRequestAsFulfilled(request);

            return;
        }
    }
}

    public void addRequest(ResourceRequest request) {
    resourceRequests.add(request);
}

public void approveRequest(String requestId, int quantity) {
    for (ResourceRequest request : resourceRequests) {
        if (request.getId().equals(requestId) && request.getStatus().equals("Pending")) {
            System.out.println("Approved  ID fromapproveRequest: " + requestId);
            request.setStatus("Approved");
            addResource(requestId, quantity);
            return;
        }
    }
}


 public ResourceRequest createRequest1(String rolename, String resourceType, int quantity) {
    if (resourceType == null || resourceType.trim().isEmpty() || quantity <= 0) {
        throw new IllegalArgumentException("Invalid resource type or quantity.");
    }

    String requestId = UUID.randomUUID().toString(); // Generate unique ID
    ResourceRequest newRequest = new ResourceRequest(requestId, rolename, resourceType, quantity);
    resourceRequests.add(newRequest); // Add to the list of requests
    System.out.println("Request created: " + newRequest);
    return newRequest;
}
//public void addResource(String resourceType, int quantity) {
//    availableResources.put(resourceType, availableResources.getOrDefault(resourceType, 0) + quantity);
//}
    public ResourceRequest createRequest(String id, String resourceType, int quantity, String requestedBy, String from, double price) {
    if (resourceType == null || resourceType.trim().isEmpty() || quantity <= 0 || price== 0) {
        throw new IllegalArgumentException("Invalid resource type or quantity.");
    }
   
    
    
    

    String requestId = UUID.randomUUID().toString(); // Generate a unique ID
    ResourceRequest newRequest = new ResourceRequest(requestId, resourceType, quantity, requestedBy,from,price);
    resourceRequests.add(newRequest); // Add to the list of requests
    System.out.println("Request created: " + newRequest);
    return newRequest;
}
    // Allocate resources to a request
    

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
    if (!availableResources.containsKey(resourceType)) {
        System.out.println("Error: Resource type " + resourceType + " not found.");
        return false;
    }

    int availableQuantity = availableResources.get(resourceType);
    if (availableQuantity >= quantityUsed) {
        availableResources.put(resourceType, availableQuantity - quantityUsed);
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

   
    // List all resource requests
    public void listRequests() {
        System.out.println("All Resource Requests:");
        for (ResourceRequest request : resourceRequests) {
            System.out.println(request);
        }
    }
    
    
    public Map<String, Integer> listAvailableResources() {
    return new HashMap<>(availableResources);
}
    public List<ResourceRequest> getAllRequests() {
    return new ArrayList<>(resourceRequests);
}

}

