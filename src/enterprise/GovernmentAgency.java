package enterprise;
 
import organization.FinanceDepartment;
import organization.GovernmentAgent;
import organization.ReliefCamp;
import organization.RescueTeam;
import organization.ResourceDistributionCenter;
import organization.SecurityTeam;
import organization.ShelterProvider;
import organization.TransportationUnit;

 
public class GovernmentAgency {
    private String name;
    private SecurityTeam securityTeam;
    private GovernmentAgent governmentAgent;
    private RescueTeam rescueTeam;
    private FinanceDepartment financeDepartment;
 
    public GovernmentAgency(String name, SecurityTeam securityTeam, GovernmentAgent governmentAgent, RescueTeam rescueTeam, FinanceDepartment financeDepartment) {
        this.name = name;
        this.securityTeam = securityTeam;
        this.governmentAgent = governmentAgent;
        this.rescueTeam = rescueTeam;
        this.financeDepartment = financeDepartment;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public SecurityTeam getSecurityTeam() {
        return securityTeam;
    }
 
    public void setSecurityTeam(SecurityTeam securityTeam) {
        this.securityTeam = securityTeam;
    }
 
   
 
    public GovernmentAgent getGovernmentAgent() {
        return governmentAgent;
    }
 
    public void setGovernmentAgent(GovernmentAgent governmentAgent) {
        this.governmentAgent = governmentAgent;
    }
 
    public RescueTeam getRescueTeam() {
        return rescueTeam;
    }
 
    public void setRescueTeam(RescueTeam rescueTeam) {
        this.rescueTeam = rescueTeam;
    }
 
    public FinanceDepartment getFinanceDepartment() {
        return financeDepartment;
    }
 
    public void setFinanceDepartment(FinanceDepartment financeDepartment) {
        this.financeDepartment = financeDepartment;
    }
 
   
}
 