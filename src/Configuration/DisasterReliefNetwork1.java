// src/model/enterprise/DisasterReliefNetwork.java
 
package Configuration;

import network.*;

import enterprise.GovernmentAgency;

import enterprise.LogisticsCompany;

import enterprise.MedicalEnterprise;

import enterprise.NGO;

import enterprise.VolunteerEnterprise;

import java.util.List;

public class DisasterReliefNetwork1 {
 
    private GovernmentAgency governmentAgency;

     private NGO ngo;
 
    private LogisticsCompany logisticsCompany;
 
    private VolunteerEnterprise volunteerEnterprise;
 
    private MedicalEnterprise medicalEnterprise;

    public DisasterReliefNetwork1(GovernmentAgency governmentAgency, NGO ngo, LogisticsCompany logisticsCompany, VolunteerEnterprise volunteerEnterprise, MedicalEnterprise medicalEnterprise) {
 
        this.governmentAgency =governmentAgency;
 
        this. ngo = ngo;
 
        this.logisticsCompany = logisticsCompany;
 
        this.volunteerEnterprise = volunteerEnterprise;
 
        this.medicalEnterprise = medicalEnterprise;
 
    }
 
    public GovernmentAgency getGovernmentAgency() {

        return governmentAgency;

    }
 
    public void setGovernmentAgency(GovernmentAgency governmentAgency) {

        this.governmentAgency = governmentAgency;

    }
 
    public NGO getNgo() {

        return ngo;

    }
 
    public void setNgo(NGO ngo) {

        this.ngo = ngo;

    }
 
    public LogisticsCompany getLogisticsCompany() {

        return logisticsCompany;

    }
 
    public void setLogisticsCompany(LogisticsCompany logisticsCompany) {

        this.logisticsCompany = logisticsCompany;

    }
 
    public VolunteerEnterprise getVolunteerEnterprise() {

        return volunteerEnterprise;

    }
 
    public void setVolunteerEnterprise(VolunteerEnterprise volunteerEnterprise) {

        this.volunteerEnterprise = volunteerEnterprise;

    }
 
    public MedicalEnterprise getMedicalEnterprise() {

        return medicalEnterprise;

    }
 
    public void setMedicalEnterprise(MedicalEnterprise medicalEnterprise) {

        this.medicalEnterprise = medicalEnterprise;

    }
 
   


}