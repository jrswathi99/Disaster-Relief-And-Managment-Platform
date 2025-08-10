/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import Configuration.DisasterReliefNetwork1;
import roles.*;
import model.User;

import javax.swing.*;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import model.Camp;
import model.Place;
import model.RescueResourceManager;
import model.ResourceManager;
import model.ResourceRequest;
import model.Role;
import model.SecurityResourceManager;
import model.TransportVehicleDirectory;
import model.User;
import model.Zone;
import ui.LogisticsManager.LogisticsJPanel;
import ui.CampManager.CampManagerJPanel;
import ui.DisasterCoordinator.DisasterCoordinatorJPanel;
import ui.FieldVolunteer.FieldVolunteerJPanel;
import ui.FinanceManager.FinanceManagerJPanel;
import ui.MedicalOfficer.MedicalOfficerJPanel;
import ui.RescueOfficer.RescueOfficerJPanel;
import ui.SecurityOfficer.SecurityOfficerJPanel;
import ui.ZoneManager.ZoneManagerJPanel;
import ui.TransportManager.TransportManagerJPanel;

/**
 *
 * @author DELL
 */
public class RoleLoginJPanel extends javax.swing.JPanel {

    private ArrayList<Role> availableRoles; // List of roles
    private HashMap<String, ArrayList<User>> registeredUsers; // Role to users mapping
    private JPanel mainContainer; // Main container for navigation
    private DisasterCoordinator disasterCoordinator;
    private ResourceManager resourceManager;
    private SecurityResourceManager securityResourceManager;
    private RescueResourceManager rescueResourceManager;
    private ResourceRequest resourceRequest;
    private DisasterReliefNetwork1 disasterReliefNetwork;

    /**
     * Creates new form RoleLoginJPanel
     */
    public RoleLoginJPanel(JPanel mainContainer, ArrayList<Role> availableRoles, HashMap<String, ArrayList<User>> registeredUsers, DisasterCoordinator disasterCoordinator, ResourceManager resourceManager,
            SecurityResourceManager securityResourceManager, RescueResourceManager rescueResourceManager,
            DisasterReliefNetwork1 disasterReliefNetwork) {
        this.mainContainer = mainContainer;
        this.availableRoles = availableRoles;
        this.registeredUsers = registeredUsers;
        this.resourceManager = resourceManager;
        this.disasterCoordinator = disasterCoordinator;
        this.securityResourceManager = securityResourceManager;
        this.rescueResourceManager = rescueResourceManager;
        this.resourceRequest = resourceRequest;
        this.disasterReliefNetwork = disasterReliefNetwork;
        initComponents();
        populateRoleDropdown();
    }

    private void populateRoleDropdown() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (String roleName : registeredUsers.keySet()) {
            model.addElement(roleName);
        }
        rolecombo.setModel(model);

        // Add action listener for role selection
        rolecombo.addActionListener(e -> handleRoleSelection());
        handleRoleSelection(); // Handle initial selection
        populateNameDropdown();
    }

    private void handleRoleSelection() {
        String selectedRole = (String) rolecombo.getSelectedItem();

        if (selectedRole == null) {
            System.out.println("No role selected.");
            return; // Exit the method if no role is selected
        }

        // Hide all fields by default
        toggleDynamicFields(false);

        switch (selectedRole) {
            case "DisasterCoordinator":
                lblplace.setVisible(true);
                comboplace.setVisible(true);
                populatePlaceComboBox();
                break;
            case "ZoneManager":
                lblplace.setVisible(true);
                comboplace.setVisible(true);
                lblzone.setVisible(true);
                combozone.setVisible(true);
                populatePlaceComboBox(); // Populate places and set zones for first place
                break;
            case "CampManager":
                lblplace.setVisible(true);
                comboplace.setVisible(true);
                lblzone.setVisible(true);
                combozone.setVisible(true);
                lblcamp.setVisible(true);
                jComboBox3.setVisible(true);
                populatePlaceComboBox(); // Populate places, zones, and camps
                break;
            case "FieldVolunteer":
                lblplace.setVisible(true);
                comboplace.setVisible(true);
                lblzone.setVisible(true);
                combozone.setVisible(true);
                lblcamp.setVisible(true);
                jComboBox3.setVisible(true);
                populatePlaceComboBox();
                break;
            case "MedicalOfficer":
                populateNameDropdown();
                break;
            case "LogisticsManager":
                populateNameDropdown();
                break;
            case "FinanceManager":
                populateNameDropdown();
                break;
            case "SecurityOfficer":
                populateNameDropdown();
                break;
            case "RescueOfficer":
                populateNameDropdown();
                break;
            case "TransportManager":
                populateNameDropdown();
                break;
            default:
                System.out.println("Unknown role: " + selectedRole);
                break;
        }

    }

    private void populatePlaceComboBox() {
        comboplace.removeAllItems(); // Clear existing items

        if (disasterCoordinator == null || disasterCoordinator.getPlaces() == null) {
            System.out.println("disasterCoordinator or places list is null.");
            return;
        }

        for (Place place : disasterCoordinator.getPlaces()) {
            comboplace.addItem(place.getName());
        }

        if (comboplace.getItemCount() > 0) {
            comboplace.setSelectedIndex(0); // Set the first item as selected
            populateZoneComboBox(); // Populate zones based on the selected place
            populateNameDropdown();
        }
    }

    private void populateZoneComboBox() {
        combozone.removeAllItems();
        String selectedPlace = (String) comboplace.getSelectedItem();
        if (selectedPlace != null) {
            for (Zone zone : disasterCoordinator.getZonesForPlace(selectedPlace)) {
                combozone.addItem(zone.getName());
            }
        }
        combozone.addActionListener(e -> populateCampComboBox());
        populateCampComboBox();
        populateNameDropdown();// Populate camps for the first zone
    }

    private void populateCampComboBox() {
        jComboBox3.removeAllItems();
        String selectedZone = (String) combozone.getSelectedItem();
        if (selectedZone != null) {
            for (Camp camp : disasterCoordinator.getCampsForZone(selectedZone)) {
                jComboBox3.addItem(camp.getName());
            }
        }
        jComboBox3.addActionListener(e -> populateNameDropdown());
        populateNameDropdown();
    }

    private void toggleDynamicFields(boolean isVisible) {
        lblplace.setVisible(isVisible);
        comboplace.setVisible(isVisible);
        lblzone.setVisible(isVisible);
        combozone.setVisible(isVisible);
        lblcamp.setVisible(isVisible);
        jComboBox3.setVisible(isVisible);
    }

    private void populateNameDropdown() {
        String selectedRole = (String) rolecombo.getSelectedItem();
        if (selectedRole == null) {
            System.out.println("No role selected.");
            return;
        }

        ArrayList<User> users = registeredUsers.getOrDefault(selectedRole, new ArrayList<>());
        if (users.isEmpty()) {
            System.out.println("No users found for role: " + selectedRole);
        }

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (User user : users) {
            model.addElement(user.getName());
        }
        comboname.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblrole = new javax.swing.JLabel();
        rolecombo = new javax.swing.JComboBox<>();
        lblname = new javax.swing.JLabel();
        comboname = new javax.swing.JComboBox<>();
        btnlogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblplace = new javax.swing.JLabel();
        comboplace = new javax.swing.JComboBox<>();
        lblzone = new javax.swing.JLabel();
        combozone = new javax.swing.JComboBox<>();
        lblcamp = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        lblname3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblname4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 102));
        setForeground(new java.awt.Color(255, 255, 255));

        lblrole.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblrole.setForeground(new java.awt.Color(255, 255, 255));
        lblrole.setText("Role");

        rolecombo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rolecombo.setForeground(new java.awt.Color(255, 255, 255));
        rolecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblname.setForeground(new java.awt.Color(255, 255, 255));
        lblname.setText("Name");

        comboname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboname.setForeground(new java.awt.Color(255, 255, 255));
        comboname.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combonameActionPerformed(evt);
            }
        });

        btnlogin.setBackground(new java.awt.Color(0, 0, 0));
        btnlogin.setForeground(new java.awt.Color(255, 255, 255));
        btnlogin.setText("Login");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        lblplace.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblplace.setForeground(new java.awt.Color(255, 255, 255));
        lblplace.setText("Place");

        comboplace.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboplace.setForeground(new java.awt.Color(255, 255, 255));
        comboplace.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblzone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblzone.setForeground(new java.awt.Color(255, 255, 255));
        lblzone.setText("Zone");

        combozone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        combozone.setForeground(new java.awt.Color(255, 255, 255));
        combozone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblcamp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblcamp.setForeground(new java.awt.Color(255, 255, 255));
        lblcamp.setText("Camp");

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblname3.setForeground(new java.awt.Color(255, 255, 255));
        lblname3.setText("Password");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        lblname4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblname4.setForeground(new java.awt.Color(255, 255, 255));
        lblname4.setText("Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnlogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblzone)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblrole)
                                .addComponent(lblplace))
                            .addComponent(lblcamp))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rolecombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboplace, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combozone, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblname4)
                            .addComponent(lblname)
                            .addComponent(lblname3))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboname, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(152, 152, 152)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblrole)
                    .addComponent(rolecombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblplace)
                    .addComponent(comboplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblzone)
                    .addComponent(combozone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcamp)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblname)
                    .addComponent(comboname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblname4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblname3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(btnlogin)
                .addContainerGap(261, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private DisasterCoordinator getDisasterCoordinator() {
        return DisasterCoordinator.getInstance();
    }
    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        String selectedRole = (String) rolecombo.getSelectedItem();
        String selectedName = (String) comboname.getSelectedItem();

        System.out.println("Attempting login for Role: " + selectedRole + ", Name: " + selectedName);

        if (selectedRole == null || selectedName == null) {
            JOptionPane.showMessageDialog(this, "Please select a role and a name to login.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<User> users = registeredUsers.getOrDefault(selectedRole, new ArrayList<>());
        System.out.println("Users available for " + selectedRole + ": " + users.size());
        User selectedUser = null;
        for (User user : users) {
            if (user.getName().equals(selectedName)) {
                selectedUser = user;
                break;
            }
        }
        if (selectedUser == null) {
            JOptionPane.showMessageDialog(this, "User not found. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!selectedUser.getEmail().equals(txtEmail.getText()) || !selectedUser.getPassword().equals(txtPassword.getText())) {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Navigate to the respective UI based on the selected role
        switch (selectedRole) {
            case "DisasterCoordinator":
                String place1 = (String) comboplace.getSelectedItem();
                disasterCoordinator = (DisasterCoordinator) selectedUser.getRole();
                String coordinatorName = disasterCoordinator.getName(); // Get the name
                DisasterCoordinatorJPanel disasterPanel = new DisasterCoordinatorJPanel(mainContainer, disasterCoordinator, place1, rescueResourceManager, securityResourceManager);
                mainContainer.add("DisasterCoordinatorJPanel", disasterPanel);
                break;

            case "ZoneManager":
                String place = (String) comboplace.getSelectedItem();
                String zone = (String) combozone.getSelectedItem();
                if (place == null || zone == null) {
                    JOptionPane.showMessageDialog(this, "Please select a valid place and zone.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ZoneManager zoneManager = (ZoneManager) selectedUser.getRole();
                if (zoneManager == null) {
                    System.out.println("Error: ZoneManager is null for the selected user.");
                    return;
                }

                if (zoneManager.getDisasterCoordinator() == null) {
                    System.out.println("Error: DisasterCoordinator is null in the ZoneManager object.");
                    return;
                }

                ZoneManagerJPanel zoneManagerPanel = new ZoneManagerJPanel(mainContainer, zoneManager, place, zone);

                mainContainer.add("ZoneManagerJPanel", zoneManagerPanel);
                break;

            case "CampManager":
                String selectedPlace = (String) comboplace.getSelectedItem();
                String selectedZone = (String) combozone.getSelectedItem();
                String selectedCamp = (String) jComboBox3.getSelectedItem();

                if (selectedPlace == null || selectedZone == null || selectedCamp == null) {
                    JOptionPane.showMessageDialog(this, "Please select a valid place, zone, and camp.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Retrieve the CampManager instance
                CampManager campManager = (CampManager) selectedUser.getRole();
                if (campManager == null) {
                    JOptionPane.showMessageDialog(this, "Camp Manager role is not assigned to the user.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Retrieve the ZoneManager for the selected zone
                Place selectedPlaceObj = disasterCoordinator.getPlaces()
                        .stream()
                        .filter(p -> p.getName().equals(selectedPlace))
                        .findFirst()
                        .orElse(null);

                if (selectedPlaceObj == null) {
                    JOptionPane.showMessageDialog(this, "Invalid place selected.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Zone zone123 = selectedPlaceObj.getZones()
                        .stream()
                        .filter(z -> z.getName().equals(selectedZone))
                        .findFirst()
                        .orElse(null);

                if (zone123 == null) {
                    JOptionPane.showMessageDialog(this, "Invalid zone selected.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ZoneManager zoneManager213 = zone123.getManager();
                if (zoneManager213 == null) {
                    JOptionPane.showMessageDialog(this, "Zone Manager not found for the selected zone.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Camp selectedCampObj = zone123.getCamps()
                        .stream()
                        .filter(c -> c.getName().equals(selectedCamp))
                        .findFirst()
                        .orElse(null);

                if (selectedCampObj == null) {
                    JOptionPane.showMessageDialog(this, "Camp not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Pass ZoneManager, CampManager, and selected camp details to the CampManagerJPanel
                CampManagerJPanel campManagerPanel = new CampManagerJPanel(mainContainer, campManager, zoneManager213, selectedCampObj, selectedCamp);
                mainContainer.add("CampManagerJPanel", campManagerPanel);
                break;
            case "FieldVolunteer":
                FieldVolunteer fieldVolunteer = (FieldVolunteer) selectedUser.getRole();

                // Fetch the selected place, zone, and camp from the disaster coordinator
                String assignedPlace = (String) comboplace.getSelectedItem();
                String assignedZone = (String) combozone.getSelectedItem();
                String assignedCamp = (String) jComboBox3.getSelectedItem();

                if (assignedPlace == null || assignedZone == null || assignedCamp == null) {
                    JOptionPane.showMessageDialog(this, "Please select a valid place, zone, and camp.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Fetch the Place, Zone, and Camp objects
                Place placeObj = disasterCoordinator.getPlaces()
                        .stream()
                        .filter(p -> p.getName().equals(assignedPlace))
                        .findFirst()
                        .orElse(null);

                Zone zoneObj = placeObj.getZones()
                        .stream()
                        .filter(z -> z.getName().equals(assignedZone))
                        .findFirst()
                        .orElse(null);
                ZoneManager zoneManager2134 = zoneObj.getManager();
                if (zoneManager2134 == null) {
                    JOptionPane.showMessageDialog(this, "Zone Manager not found for the selected zone.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Camp campObj = zoneObj.getCamps()
                        .stream()
                        .filter(c -> c.getName().equals(assignedCamp))
                        .findFirst()
                        .orElse(null);

                String currentPriority = zoneObj.getPriority();
                String currentStatus = campObj.getStatus();

                FieldVolunteerJPanel fieldVolunteerPanel = new FieldVolunteerJPanel(mainContainer, zoneObj, campObj, zoneObj.getName(), campObj.getName(), currentPriority, currentStatus, zoneManager2134);
                mainContainer.add("FieldVolunteerJPanel", fieldVolunteerPanel);
                break;

            case "FinanceManager":
                FinanceManager financeManager = (FinanceManager) selectedUser.getRole();
                FinanceManagerJPanel financeManagerPanel = new FinanceManagerJPanel(mainContainer, resourceManager, financeManager, resourceRequest);
                mainContainer.add("FinanceManagerJPanel", financeManagerPanel);
                break;

            case "LogisticsManager":
                LogisticsManager logisticsManager = (LogisticsManager) selectedUser.getRole();
                MedicalOfficer medicalOfficer1 = this.disasterReliefNetwork.getMedicalEnterprise().getMedicalTeam().getMedicalOfficer();
                LogisticsJPanel logisticsPanel = new LogisticsJPanel(mainContainer, logisticsManager, medicalOfficer1, resourceManager, resourceRequest);
                mainContainer.add("LogisticsManagerJPanel", logisticsPanel);
                break;

            case "MedicalOfficer":
                MedicalOfficer medicalOfficer = (MedicalOfficer) selectedUser.getRole();
                LogisticsManager logisticsManager1 = this.disasterReliefNetwork.getLogisticsCompany().getTransportationUnit().getLogisticsManager();
                MedicalOfficerJPanel medicalOfficerPanel = new MedicalOfficerJPanel(mainContainer, logisticsManager1, medicalOfficer, resourceManager, resourceRequest);
                mainContainer.add("MedicalOfficerJPanel", medicalOfficerPanel);
                break;

            case "RescueOfficer":
                RescueOfficer rescueOfficer = (RescueOfficer) selectedUser.getRole();
                RescueOfficerJPanel rescueOfficerPanel = new RescueOfficerJPanel(mainContainer, rescueOfficer, disasterCoordinator, rescueResourceManager);
                mainContainer.add("RescueOfficerJPanel", rescueOfficerPanel);
                break;

            case "SecurityOfficer":
                SecurityOfficer securityOfficer = (SecurityOfficer) selectedUser.getRole();
                SecurityOfficerJPanel securityOfficerPanel = new SecurityOfficerJPanel(mainContainer, securityOfficer, disasterCoordinator, securityResourceManager);
                mainContainer.add("SecurityOfficerJPanel", securityOfficerPanel);
                break;
                
             case "TransportManager":
                TransportManager transportManager = (TransportManager) selectedUser.getRole();
                 TransportVehicleDirectory vehicleDirectory = new TransportVehicleDirectory();
                 TransportManagerJPanel transportManagerPanel = new TransportManagerJPanel(mainContainer, transportManager, vehicleDirectory);
                mainContainer.add("TransportManagerJPanel", transportManagerPanel);
                break;

            default:
                JOptionPane.showMessageDialog(this, "Role not recognized!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }

        // Switch to the selected panel
        CardLayout layout = (CardLayout) mainContainer.getLayout();
        layout.show(mainContainer, selectedRole + "JPanel");

    }//GEN-LAST:event_btnloginActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void combonameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combonameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combonameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JComboBox<String> comboname;
    private javax.swing.JComboBox<String> comboplace;
    private javax.swing.JComboBox<String> combozone;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblcamp;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblname3;
    private javax.swing.JLabel lblname4;
    private javax.swing.JLabel lblplace;
    private javax.swing.JLabel lblrole;
    private javax.swing.JLabel lblzone;
    private javax.swing.JComboBox<String> rolecombo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
