/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuration;

import enterprise.GovernmentAgency;
import enterprise.LogisticsCompany;
import enterprise.MedicalEnterprise;
import enterprise.NGO;
import enterprise.VolunteerEnterprise;
import java.util.ArrayList;
import java.util.List;
import model.ResourceManager;
import model.User;
import organization.FinanceDepartment;
import organization.FoodDistributionCompany;
import organization.GovernmentAgent;
import organization.MedicalTeam;
import organization.ReliefCamp;
import organization.RescueTeam;
import organization.ResourceDistributionCenter;
import organization.SecurityTeam;
import organization.ShelterProvider;
import organization.TransportationUnit;
import roles.CampManager;
import roles.DisasterCoordinator;
import roles.FieldVolunteer;
import roles.FinanceManager;
import roles.LogisticsManager;
import roles.MedicalOfficer;
import roles.RescueOfficer;
import roles.SecurityOfficer;
import roles.TransportManager;
import roles.ZoneManager;
import utils.IDGenerator;



//import com.github.javafaker.Faker;
/**
 *
 * @author jrswa
 */
public class ConfigueNetwork {
//     private Faker faker = new Faker();
    
    public static DisasterReliefNetwork1 initialize(ResourceManager resourceManager){
        
        
        
        ConfigueNetwork configureNetwork = new ConfigueNetwork();
       
        
        DisasterCoordinator disasterCoordinator = new DisasterCoordinator();
        FieldVolunteer fieldVolunteer = new FieldVolunteer();
        MedicalOfficer medicalOfficer = new MedicalOfficer(resourceManager);
        FinanceManager financeManager = new FinanceManager(resourceManager);
        LogisticsManager logisticsManager = new LogisticsManager(resourceManager);
        SecurityOfficer securityOfficer = new SecurityOfficer();
        TransportManager transportManager = new TransportManager();
        ZoneManager zoneManager = new ZoneManager(disasterCoordinator);
        RescueOfficer rescueOfficer = new RescueOfficer();
        CampManager campManager = new CampManager(zoneManager);
        
        
        
        FinanceDepartment financeDepartment = new FinanceDepartment("Finance Department A", 1000000.0, financeManager);
        RescueTeam rescueTeam = new RescueTeam("Rescue Team A", 500, rescueOfficer);
        SecurityTeam securityTeam = new SecurityTeam("Security Team A", 5000, securityOfficer);
        ShelterProvider shelterProvider = new ShelterProvider("Shelter Provider A", 200, transportManager);
        TransportationUnit transportationUnit = new TransportationUnit("Transportation Unit A", 20000, logisticsManager, transportManager);
        FoodDistributionCompany foodDistributionCompany = new FoodDistributionCompany("Food Distribution Company A", logisticsManager, transportManager, 10000000);
        GovernmentAgent governmentAgent = new GovernmentAgent("Govt Agent A", zoneManager, campManager, disasterCoordinator);
        MedicalTeam medicalTeam = new MedicalTeam("Medical Team A", 10899, medicalOfficer);
        ReliefCamp reliefCamp = new ReliefCamp("Relief Camp A", 2009, fieldVolunteer);
        ResourceDistributionCenter resourceDistributionCenter = new ResourceDistributionCenter("Resource Distribution Center A", 500000, logisticsManager);
        
        
        GovernmentAgency governmentAgency = new GovernmentAgency(
            "Government Agency A",
            securityTeam,
            governmentAgent,
            rescueTeam,
            financeDepartment
        );
        
        LogisticsCompany logisticsCompany = new LogisticsCompany("Logistics Company A", transportationUnit, foodDistributionCompany);
        MedicalEnterprise medicalEnterprise = new MedicalEnterprise("Medical Enterprise A", medicalTeam);
        NGO ngo = new NGO("NGO A", reliefCamp, rescueTeam);
        VolunteerEnterprise volunteerEnterprise = new VolunteerEnterprise("Volunteer Enterprise A", medicalTeam, resourceDistributionCenter, shelterProvider);
        
       DisasterReliefNetwork1 disasterReliefNetwork = new DisasterReliefNetwork1(governmentAgency, ngo, logisticsCompany, volunteerEnterprise, medicalEnterprise);  
        
        
        
        return disasterReliefNetwork;
        
    }
    
}