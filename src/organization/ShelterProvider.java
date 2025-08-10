package organization;

import roles.FieldVolunteer;
import roles.TransportManager;

 
public class ShelterProvider {
    private String name;
    private int capacity;
    private TransportManager transportManager;
 
    public ShelterProvider(String name, int capacity, TransportManager transportManager) {
        this.name = name;
        this.capacity = capacity;
        this.transportManager = transportManager;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getCapacity() {
        return capacity;
    }
 
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
 
 
 
    public TransportManager getTransportManager() {
        return transportManager;
    }
 
    public void setTransportManager(TransportManager transportManager) {
        this.transportManager = transportManager;
    }
}