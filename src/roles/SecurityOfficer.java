/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roles;

import model.ResourceRequest;
import model.SecurityResourceManager;
import model.Role;

/**
 *
 * @author DELL
 */
public class SecurityOfficer extends Role {

    public SecurityOfficer() {
        super("SecurityOfficer");

    }

    public void manageSecurity(String zoneId) {
        System.out.println("Managing security in zone: " + zoneId);
    }

    public void reportIncident(String incidentDetails) {
        System.out.println("Security incident reported: " + incidentDetails);
    }

   
    public void addResource(SecurityResourceManager resourceManager, String resourceType, int quantity) {
    resourceManager.addResource(resourceType, quantity);
    System.out.println("Resource added: " + resourceType + " (Quantity: " + quantity + ")");
}
    
    public boolean fulfillRequest(SecurityResourceManager resourceManager, String requestId, int quantityToAllocate) {
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

    // View all available resources


    @Override
    public void performRoleSpecificWork() {
        System.out.println("Security Officer ensuring law and order...");
    }
}
