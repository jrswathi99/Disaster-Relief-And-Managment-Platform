package enterprise;
 
import organization.MedicalTeam;
import organization.ResourceDistributionCenter;
import organization.SecurityTeam;
import organization.ShelterProvider;

public class VolunteerEnterprise {
    private String name;
    private MedicalTeam medicalTeam;
    private ResourceDistributionCenter resourceDistributionCenter;
    private ShelterProvider shelterProvider;
 
    public VolunteerEnterprise(String name, MedicalTeam medicalTeam, ResourceDistributionCenter resourceDistributionCenter, ShelterProvider shelterProvider) {
        this.name = name;
        this.medicalTeam = medicalTeam;
        this.resourceDistributionCenter = resourceDistributionCenter;
        this.shelterProvider = shelterProvider;
    }

    public VolunteerEnterprise(String local_Volunteers) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    
 
    public MedicalTeam getMedicalTeam() {
        return medicalTeam;
    }
 
    public void setMedicalTeam(MedicalTeam medicalTeam) {
        this.medicalTeam = medicalTeam;
    }
 
    public ResourceDistributionCenter getResourceDistributionCenter() {
        return resourceDistributionCenter;
    }
 
    public void setResourceDistributionCenter(ResourceDistributionCenter resourceDistributionCenter) {
        this.resourceDistributionCenter = resourceDistributionCenter;
    }
 
    public ShelterProvider getShelterProvider() {
        return shelterProvider;
    }
 
    public void setShelterProvider(ShelterProvider shelterProvider) {
        this.shelterProvider = shelterProvider;
    }
}
 