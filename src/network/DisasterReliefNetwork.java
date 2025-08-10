// src/model/enterprise/DisasterReliefNetwork.java

package network;
 
import enterprise.GovernmentAgency;
import enterprise.LogisticsCompany;
import enterprise.MedicalEnterprise;
import enterprise.NGO;
import enterprise.VolunteerEnterprise;
import java.util.List;
 
public class DisasterReliefNetwork {

    private List<GovernmentAgency> governmentAgencies;

    private List<NGO> ngos;

    private List<LogisticsCompany> logisticsCompanies;

    private List<VolunteerEnterprise> volunteerEnterprises;

    private List<MedicalEnterprise> medicalEnterprises;
 
    public DisasterReliefNetwork(List<GovernmentAgency> governmentAgencies, List<NGO> ngos, List<LogisticsCompany> logisticsCompanies, List<VolunteerEnterprise> volunteerEnterprises, List<MedicalEnterprise> medicalEnterprises) {

        this.governmentAgencies = governmentAgencies;

        this.ngos = ngos;

        this.logisticsCompanies = logisticsCompanies;

        this.volunteerEnterprises = volunteerEnterprises;

        this.medicalEnterprises = medicalEnterprises;

    }
 
    public List<GovernmentAgency> getGovernmentAgencies() {

        return governmentAgencies;

    }
 
    public void setGovernmentAgencies(List<GovernmentAgency> governmentAgencies) {

        this.governmentAgencies = governmentAgencies;

    }
 
    public List<NGO> getNgos() {

        return ngos;

    }
 
    public void setNgos(List<NGO> ngos) {

        this.ngos = ngos;

    }
 
    public List<LogisticsCompany> getLogisticsCompanies() {

        return logisticsCompanies;

    }
 
    public void setLogisticsCompanies(List<LogisticsCompany> logisticsCompanies) {

        this.logisticsCompanies = logisticsCompanies;

    }
 
    public List<VolunteerEnterprise> getVolunteerOrganizations() {

        return volunteerEnterprises;

    }
 
    public void setVolunteerOrganizations(List<VolunteerEnterprise> volunteerOrganizations) {

        this.volunteerEnterprises = volunteerOrganizations;

    }
 
    public List<MedicalEnterprise> getMedicalOrganizations() {

        return medicalEnterprises;

    }
 
    public void setMedicalOrganizations(List<MedicalEnterprise> medicalOrganizations) {

        this.medicalEnterprises = medicalOrganizations;

    }

}
 