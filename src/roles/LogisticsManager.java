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

import java.util.ArrayList;
import model.ResourceManager;
import model.ResourceRequest;

import model.Role;

public class LogisticsManager extends Role {
    private ResourceManager resourceManager;

    public LogisticsManager( ResourceManager resourceManager) {
        super("LogisticsManager");
        this.resourceManager = resourceManager;
    }
    
    public boolean fullfilRequest(ResourceManager resourceManager,String requesId,int quantity){
        ResourceRequest request=resourceManager.getRequestById(requesId);
        if(request !=null && "Pending".equals(request.getStatus())){
            resourceManager.updateRequestStatus(requesId, "Approved");
            resourceManager.allocateResource(request.getResourceType(), quantity);
            return true;
        }
        return false;
    }










    public void addResource(ResourceManager resourceManager, String resourceType, int quantity) {
    resourceManager.addResource(resourceType, quantity);
    System.out.println("Resource added: " + resourceType + " (Quantity: " + quantity + ")");
}

    // Fulfill a resource request
//    public void fulfillRequest(ResourceManager resourceManager, String requestId, int quantityToAllocate) {
//    ResourceRequest request = resourceManager.getRequestById(requestId);
//    if (request == null) {
//        System.out.println("Error: Resource request not found.");
//        return;
//    }
//
//    if (quantityToAllocate <= 0 || quantityToAllocate > resourceManager.getAvailableQuantity(request.getResourceType())) {
//        System.out.println("Error: Insufficient or invalid quantity for allocation.");
//        return;
//    }
//
//    resourceManager.allocateResource(request.getResourceType(), quantityToAllocate);
//    request.setQuantityAssigned(quantityToAllocate);
//    request.setStatus("Fulfilled");
//    System.out.println("Fulfilled " + quantityToAllocate + " units of " + request.getResourceType());
//}
    
   

















    // View all available resources
    public void listAvailableResources() {
        resourceManager.listResources();
    }

    @Override
    public void performRoleSpecificWork() {
        System.out.println("Logistics Manager managing resources and fulfilling requests...");
    }
}
