
package organization;
 
import roles.FieldVolunteer;
import roles.SecurityOfficer;

 
public class SecurityTeam {
    private String name;
    private int numberOfOfficers;
    private SecurityOfficer securityOfficer;
 
    public SecurityTeam(String name, int numberOfOfficers, SecurityOfficer securityOfficer) {
        this.name = name;
        this.numberOfOfficers = numberOfOfficers;
        this.securityOfficer = securityOfficer;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getNumberOfOfficers() {
        return numberOfOfficers;
    }
 
    public void setNumberOfOfficers(int numberOfOfficers) {
        this.numberOfOfficers = numberOfOfficers;
    }
 
    public SecurityOfficer getSecurityOfficer() {
        return securityOfficer;
    }
 
    public void setSecurityOfficer(SecurityOfficer securityOfficer) {
        this.securityOfficer = securityOfficer;
    }
 
   
}