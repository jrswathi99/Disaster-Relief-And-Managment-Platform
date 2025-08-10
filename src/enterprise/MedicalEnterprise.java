package enterprise;

import organization.MedicalTeam;

 
public class MedicalEnterprise {
    private String name;
    private MedicalTeam medicalTeam;
 
    public MedicalEnterprise(String name, MedicalTeam medicalTeam) {
        this.name = name;
        this.medicalTeam = medicalTeam;
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
}