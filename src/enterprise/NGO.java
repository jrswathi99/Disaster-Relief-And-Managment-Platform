package enterprise;



import organization.ReliefCamp;
import organization.RescueTeam;
import organization.ResourceDistributionCenter;

public class NGO {
    private String name;
    private ReliefCamp reliefCamp;
    private RescueTeam rescueTeam;

    public NGO(String name, ReliefCamp reliefCamp, RescueTeam rescueTeam) {
        this.name = name;
        this.reliefCamp = reliefCamp;
        this.rescueTeam = rescueTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReliefCamp getReliefCamp() {
        return reliefCamp;
    }

    public void setReliefCamp(ReliefCamp reliefCamp) {
        this.reliefCamp = reliefCamp;
    }



    public RescueTeam getRescueTeam() {
        return rescueTeam;
    }

    public void setRescueTeam(RescueTeam rescueTeam) {
        this.rescueTeam = rescueTeam;
    }
}