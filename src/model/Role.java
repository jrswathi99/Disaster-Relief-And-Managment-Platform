/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public abstract class Role {
    private String roleName;

    /**
     * Constructor to initialize the role name.
     *
     * @param roleName The name of the role (e.g., "DisasterCoordinator").
     */
    public Role(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Get the name of the role.
     *
     * @return The role name.
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Abstract method for specific work that a role performs.
     */
    public abstract void performRoleSpecificWork();

    @Override
    public String toString() {
        return roleName; // Ensures that roles display correctly in dropdowns
    }
}
