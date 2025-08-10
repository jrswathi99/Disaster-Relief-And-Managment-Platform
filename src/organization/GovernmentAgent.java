package organization;
 
import roles.CampManager;
import roles.DisasterCoordinator;
import roles.ZoneManager;


 
public class GovernmentAgent {
    private String name;
    private ZoneManager zoneManager;
    private CampManager campManager;
    private DisasterCoordinator disasterCoordinator;
 
    public GovernmentAgent(String name, ZoneManager zoneManager, CampManager campManager, DisasterCoordinator disasterCoordinator) {
        this.name = name;
        this.zoneManager = zoneManager;
        this.campManager = campManager;
        this.disasterCoordinator = disasterCoordinator;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public ZoneManager getZoneManager() {
        return zoneManager;
    }
 
    public void setZoneManager(ZoneManager zoneManager) {
        this.zoneManager = zoneManager;
    }
 
    public CampManager getCampManager() {
        return campManager;
    }
 
    public void setCampManager(CampManager campManager) {
        this.campManager = campManager;
    }
 
    public DisasterCoordinator getDisasterCoordinator() {
        return disasterCoordinator;
    }
 
    public void setDisasterCoordinator(DisasterCoordinator disasterCoordinator) {
        this.disasterCoordinator = disasterCoordinator;
    }
}