/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roles;

import java.util.ArrayList;
import model.Role;
import model.RescueResourceManager;
import model.ResourceRequest;

/**
 *
 * @author DELL
 */

public class RescueOfficer extends Role {
    
    public RescueOfficer() {
        super("RescueOfficer");
        
    }
    public void assistRescueOperations(String location) {
        System.out.println("Assisting rescue operations at: " + location);
    }

    public void reportCompletion(String operationId) {
        System.out.println("Rescue operation completed for ID: " + operationId);
    }
    
    public void addResource(RescueResourceManager resourceManager, String resourceType, int quantity) {
    resourceManager.addResource(resourceType, quantity);
    System.out.println("Resource added: " + resourceType + " (Quantity: " + quantity + ")");
}
    
    public boolean fulfillRequest(RescueResourceManager resourceManager, String requestId, int quantityToAllocate) {
    // Find the request
    ResourceRequest request = resourceManager.getRequestById(requestId);
    if (request == null) {
        System.out.println("Request not found.");
        return false;
    }

    // Check available resources
    String resourceType = request.getResourceType();
    int availableQuantity = resourceManager.getAvailableQuantity(resourceType);

    if (availableQuantity < quantityToAllocate) {
        System.out.println("Insufficient resources.");
        return false;
    }

    // Deduct quantity and update request
    resourceManager.allocateResource(resourceType, quantityToAllocate);
    request.setStatus("Fulfilled");
    return true;
}

    @Override
    public void performRoleSpecificWork() {
        System.out.println("Rescue Officer managing rescue operations...");
    }
}

