package roles;

import model.Role;
import model.TransportVehicle;
import model.TransportVehicleDirectory;

 
public class TransportManager extends Role {
    private TransportVehicleDirectory vehicleDirectory;
 
    // Constructor
    public TransportManager() {
        super("TransportManager");
        vehicleDirectory = TransportVehicleDirectory.getInstance();
    }
 
    // Method to add a vehicle to the directory
    public void addVehicle(TransportVehicle vehicle) {
        vehicleDirectory.addTransportVehicle(vehicle);
    }
 
    // Method to remove a vehicle by ID
    public void removeVehicle(int id) {
        boolean removed = vehicleDirectory.removeTransportVehicleById(id);
        if (removed) {
            System.out.println("Vehicle with ID " + id + " successfully removed.");
        } else {
            System.out.println("No vehicle with ID " + id + " found.");
        }
    }
 
    @Override
    public void performRoleSpecificWork() {
        System.out.println("Transport Manager overseeing transportation logistics...");
    }
}
