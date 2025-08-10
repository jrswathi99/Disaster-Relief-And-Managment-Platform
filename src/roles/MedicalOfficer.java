/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roles;

/**
 *
 * @author DELL
 */

import utils.IDGenerator;
import utils.ValidationUtils;

import model.ResourceManager;
import model.ResourceRequest;
import model.Role;

public class MedicalOfficer extends Role {
    private ResourceManager resourceManager;

    public MedicalOfficer( ResourceManager resourceManager) {
        super("MedicalOfficer");
       this.resourceManager = resourceManager;
    }

    public void requestResource(String id,String resourceType, int quantity) {
        if (quantity <= 0 || resourceType == null || resourceType.trim().isEmpty()) {
            System.out.println("Error: Invalid resource request details.");
            return;
        }

        ResourceRequest request = resourceManager.createRequest1(this.getRoleName(),resourceType, quantity);
        System.out.println("Resource request submitted: " + resourceType + " (Quantity: " + quantity + ")");
    }

    // Use allocated resources
    public void useResource(String resourceType, int quantityUsed) {
        if (quantityUsed <= 0 || resourceType == null || resourceType.trim().isEmpty()) {
            System.out.println("Error: Invalid resource usage details.");
            return;
        }

        boolean success = resourceManager.consumeResource(resourceType, quantityUsed);

        if (success) {
            System.out.println("Used " + quantityUsed + " units of " + resourceType + ".");
        } else {
            System.out.println("Error: Insufficient resources for " + resourceType + ".");
        }
    }
    public void notifyRequestFulfilled(String requestId) {
    System.out.println("Request with ID " + requestId + " has been fulfilled.");
    // Additional logic to handle the notification
}
    
    public boolean useResource(ResourceManager resourceManager, String resourceType, int quantity) {
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
    // View all resource requests
    public void viewRequests() {
        resourceManager.listRequestsForRole(this.getRoleName());
    }
   public void requestResource(String Id,ResourceManager resourceManager, String resourceType, int quantity) {
    try {
        resourceManager.createRequest1(this.getRoleName(), resourceType, quantity);
        System.out.println("Resource request submitted: " + resourceType + " (Quantity: " + quantity + ")");
    } catch (IllegalArgumentException e) {
        System.out.println("Error submitting resource request: " + e.getMessage());
    }
}
//    public void useResource(ResourceManager resourceManager, String resourceType, int quantity) {
//    boolean success = resourceManager.consumeResource(resourceType, quantity);
//    if (!success) {
//        throw new IllegalArgumentException("Insufficient resources available.");
//    }
//}

    @Override
    public void performRoleSpecificWork() {
        System.out.println("Medical Officer managing resource requests and providing care...");
    }
}
