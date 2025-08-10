// src/model/organization/TransportationUnit.java
package organization;

import roles.LogisticsManager;
import roles.TransportManager;


public class TransportationUnit {
    private String name;
    private int numberOfVehicles;
    private LogisticsManager logisticsManager;
    private TransportManager transportationManager;

    public TransportationUnit(String name, int numberOfVehicles, LogisticsManager logisticsManager, TransportManager transportationManager) {
        this.name = name;
        this.numberOfVehicles = numberOfVehicles;
        this.logisticsManager = logisticsManager;
        this.transportationManager = transportationManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    public LogisticsManager getLogisticsManager() {
        return logisticsManager;
    }

    public void setLogisticsManager(LogisticsManager logisticsManager) {
        this.logisticsManager = logisticsManager;
    }

    public TransportManager getTransportationManager() {
        return transportationManager;
    }

    public void setTransportationManager(TransportManager transportationManager) {
        this.transportationManager = transportationManager;
    }
}