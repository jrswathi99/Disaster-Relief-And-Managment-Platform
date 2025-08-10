/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuration;

import enterprise.*;
import model.ResourceManager;
import model.User;
import organization.*;
import roles.*;
import utils.IDGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.github.javafaker.Faker;
import model.Role;

public class ConfigureUser {

    private static String sanitizeName(String name) {
        if (name == null || name.isEmpty()) {
            return "Unknown Name";
        }
        return name.replaceAll("[^a-zA-Z\\s]", "").trim();
    }

    public static List<User> initialize(ResourceManager resourceManager) {
        // Initialize roles
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

        Faker faker = new Faker();

        // Create a list to hold users
        List<User> userList = new ArrayList<>();

        // Helper method to generate users for a role
        addUsersForRole(userList, faker, 5, disasterCoordinator);
        addUsersForRole(userList, faker, 5, fieldVolunteer);
        addUsersForRole(userList, faker, 3, medicalOfficer);
        addUsersForRole(userList, faker, 2, financeManager);
        addUsersForRole(userList, faker, 2, logisticsManager);
        addUsersForRole(userList, faker, 3, securityOfficer);
        addUsersForRole(userList, faker, 3, transportManager);
        addUsersForRole(userList, faker, 2, rescueOfficer);
        addUsersForRole(userList, faker, 3, campManager);

        // Return the list of users
        return userList;
    }

    private static void addUsersForRole(List<User> userList, Faker faker, int count, Role role) {
        for (int i = 0; i < count; i++) {
            String sanitizedFullName = sanitizeName(faker.name().fullName());
            int age = faker.number().numberBetween(20, 40);
            userList.add(new User(UUID.randomUUID().toString(), sanitizedFullName, "user@email.com", "password123", age, role));
        }
    }
}
