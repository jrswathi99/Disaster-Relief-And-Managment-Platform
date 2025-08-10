package organization;
 
import roles.FieldVolunteer;
import roles.MedicalOfficer;

 
public class MedicalTeam {
    private String name;
    private int numberOfDoctors;
    private MedicalOfficer medicalOfficer;
 
    public MedicalTeam(String name, int numberOfDoctors, MedicalOfficer medicalOfficer) {
        this.name = name;
        this.numberOfDoctors = numberOfDoctors;
        this.medicalOfficer = medicalOfficer;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getNumberOfDoctors() {
        return numberOfDoctors;
    }
 
    public void setNumberOfDoctors(int numberOfDoctors) {
        this.numberOfDoctors = numberOfDoctors;
    }
 
    public MedicalOfficer getMedicalOfficer() {
        return medicalOfficer;
    }
 
    public void setMedicalOfficer(MedicalOfficer medicalOfficer) {
        this.medicalOfficer = medicalOfficer;
    }
 
  
}