package model;

import java.util.ArrayList;
import java.util.List;

public class TransportVehicleDirectory {
    private static TransportVehicleDirectory instance;
    private List<TransportVehicle> transportVehicles;

    // Private constructor to enforce Singleton pattern
    public TransportVehicleDirectory() {
        transportVehicles = new ArrayList<>();
    }

    // Singleton accessor
    public static TransportVehicleDirectory getInstance() {
        if (instance == null) {
            instance = new TransportVehicleDirectory();
        }
        return instance;
    }

    // Add a transport vehicle to the directory
    public void addTransportVehicle(TransportVehicle vehicle) {
        transportVehicles.add(vehicle);
        System.out.println("Vehicle added: " + vehicle.getId());
    }

    // Remove a transport vehicle by ID
    public boolean removeTransportVehicleById(int id) {
        boolean result = transportVehicles.removeIf(vehicle -> vehicle.getId() == id);
        if (result) {
            System.out.println("Vehicle with ID " + id + " removed successfully.");
        } else {
            System.out.println("No vehicle found with ID: " + id);
        }
        return result;
    }

    // Get a transport vehicle by ID
    public TransportVehicle getTransportVehicleById(int id) {
        for (TransportVehicle vehicle : transportVehicles) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }

    // Get all transport vehicles
    public List<TransportVehicle> getAllTransportVehicles() {
        return transportVehicles;
    }
}
