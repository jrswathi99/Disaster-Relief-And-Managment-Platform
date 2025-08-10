package organization;

import roles.FieldVolunteer;
import roles.LogisticsManager;

public class ResourceDistributionCenter {
    private String name;
    private int inventory;
    private LogisticsManager logisticsManager;
 
    public ResourceDistributionCenter(String name, int inventory, LogisticsManager logisticsManager) {
        this.name = name;
        this.inventory = inventory;
        this.logisticsManager = logisticsManager;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getInventory() {
        return inventory;
    }
 
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
 
    public LogisticsManager getLogisticsManager() {
        return logisticsManager;
    }
 
    public void setLogisticsManager(LogisticsManager logisticsManager) {
        this.logisticsManager = logisticsManager;
    }
 

}
