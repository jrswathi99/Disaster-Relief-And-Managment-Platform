package organization;
 
import roles.FieldVolunteer;
import roles.RescueOfficer;

public class RescueTeam {
    private String name;
    private int numberOfRescuers;
    private RescueOfficer rescueOfficer;
 
    public RescueTeam(String name, int numberOfRescuers, RescueOfficer rescueOfficer) {
        this.name = name;
        this.numberOfRescuers = numberOfRescuers;
        this.rescueOfficer = rescueOfficer;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getNumberOfRescuers() {
        return numberOfRescuers;
    }
 
    public void setNumberOfRescuers(int numberOfRescuers) {
        this.numberOfRescuers = numberOfRescuers;
    }
 
    public RescueOfficer getRescueOfficer() {
        return rescueOfficer;
    }
 
    public void setRescueOfficer(RescueOfficer rescueOfficer) {
        this.rescueOfficer = rescueOfficer;
    }
 
 
}