/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.UUID;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class ResourceRequest {
   private String id;
    private String resourceType; // e.g., "Beds", "Medicines"
    private int quantityRequested;
    private int quantityAssigned;
    private String status; // Pending, Approved, Fulfilled
    private String requestedBy; // Medical Officer's name
    private double price; // New field for price
    private String from; // Source of the request
    private ResourceManager resourceManager;
    private String rolename;
   
    public ResourceRequest(String id, String resourceType, int quantityRequested, String requestedBy, String from, double price) {
        this.id = id;
        this.resourceType = resourceType;
        this.quantityRequested = quantityRequested;
        this.quantityAssigned = 0;
        this.status = "Pending";
        this.requestedBy = requestedBy;
        this.from = from;
        this.price = price;
    }
    
    public ResourceRequest(String id, String resourceType, int quantityRequested, String requestedBy) {
        this.id = id;
        this.resourceType = resourceType;
        this.quantityRequested = quantityRequested;
        this.quantityAssigned = 0;
        this.status = "Pending";
        this.requestedBy = requestedBy;
       
        
    }
    public ResourceRequest(String id,String rolename, String resourceType, int quantityRequested){
        this.id=id;
          this.rolename=rolename;
        this.resourceType = resourceType;
        this.quantityRequested=quantityRequested;
         this.status = "Pending"; // Default status
         this.requestedBy = rolename; // Initialize requestedBy
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public int getQuantityRequested() {
        return quantityRequested;
    }

    public void setQuantityRequested(int quantityRequested) {
        this.quantityRequested = quantityRequested;
    }

    public int getQuantityAssigned() {
        return quantityAssigned;
    }

    public void setQuantityAssigned(int quantityAssigned) {
        this.quantityAssigned = quantityAssigned;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    // Update the allocated quantity and modify status
    public void updateAllocatedQuantity(int quantityToAllocate) {
        this.quantityAssigned += quantityToAllocate;
        if (this.quantityAssigned >= this.quantityRequested) {
            this.status = "Fulfilled";
        } else {
            this.status = "Partial";
        }
    }

    @Override
    public String toString() {
        return "Request ID: " + id +
               ", Resource: " + resourceType +
               ", Quantity Requested: " + quantityRequested +
               ", Quantity Assigned: " + quantityAssigned +
               ", Status: " + status +
               ", Requested By: " + requestedBy;
    }
}
