/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roles;

import java.util.ArrayList;
import model.Role;
import model.User;
import utils.IDGenerator;
import utils.ValidationUtils;

/**
 *
 * @author DELL
 */
public class SystemAdmin extends Role {
    private ArrayList<User> users;

    public SystemAdmin() {
        super("SystemAdmin");
        this.users = new ArrayList<>();
    }

    

    public void deleteUser(String userId) {
        boolean removed = users.removeIf(user -> user.getId().equals(userId));
        if (removed) {
            System.out.println("User with ID " + userId + " has been removed.");
        } else {
            System.out.println("Error: User with ID " + userId + " not found.");
        }
    }

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }
        System.out.println("Listing all users:");
        for (User user : users) {
            System.out.println("- " + user.getName() + " (" + user.getRole().getClass().getSimpleName() + ")");
        }
    }

    @Override
    public void performRoleSpecificWork() {
        System.out.println("System Admin managing users and roles...");
    }
}
