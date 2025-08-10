package organization;
 
import roles.LogisticsManager;
import roles.TransportManager;


public class FoodDistributionCompany {
    private String name;
    private LogisticsManager logisticsManager;
    private TransportManager transportManager;
    private int fooditems;

   
 
    public FoodDistributionCompany(String name, LogisticsManager logisticsManager, TransportManager transportManager, int fooditems) {
        this.name = name;
        this.logisticsManager = logisticsManager;
        this.transportManager = transportManager;
        this.fooditems= fooditems;
        
    }
    
     public int getFooditems() {
        return fooditems;
    }

    public void setFooditems(int fooditems) {
        this.fooditems = fooditems;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public LogisticsManager getLogisticsManager() {
        return logisticsManager;
    }
 
    public void setLogisticsManager(LogisticsManager logisticsManager) {
        this.logisticsManager = logisticsManager;
    }
 
    public TransportManager getTransportManager() {
        return transportManager;
    }
 
    public void setTransportManager(TransportManager transportManager) {
        this.transportManager = transportManager;
    }
}