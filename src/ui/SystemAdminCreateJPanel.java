/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import Configuration.DisasterReliefNetwork1;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Camp;
import model.Place;
import model.ResourceManager;
import model.ResourceRequest;
import model.Role;
import model.User;
import model.Zone;
import roles.CampManager;
import roles.DisasterCoordinator;
import roles.FieldVolunteer;
import roles.FinanceManager;
import roles.LogisticsManager;
import roles.MedicalOfficer;
import roles.RescueOfficer;
import roles.SecurityOfficer;
import roles.SystemAdmin;
import roles.ZoneManager;
import utils.IDGenerator;
import utils.ValidationUtils;

/**
 *
 * @author DELL
 */
public class SystemAdminCreateJPanel extends javax.swing.JPanel {
    
    private ArrayList<Role> availableRoles;
    HashMap<String, ArrayList<User>> registeredUsers;
    private JPanel userProcessContainer;
    DisasterCoordinator disasterCoordinator;
     private ResourceManager resourceManager;
     private ResourceRequest resourceRequest;
     private DisasterReliefNetwork1 disasterReliefNetwork;
    /**
     * Creates new form SystemAdminJPanel
     */
    public SystemAdminCreateJPanel(JPanel mainContainer, ArrayList<Role> availableRoles, HashMap<String, ArrayList<User>> registeredUsers,DisasterCoordinator disasterCoordinator,ResourceManager resourceManager,ResourceRequest resourceRequest,
            DisasterReliefNetwork1 disasterReliefNetwork) {
    this.availableRoles = availableRoles;
    this.registeredUsers=registeredUsers;
    this.disasterCoordinator=disasterCoordinator;
    this.resourceManager=resourceManager;
    this.disasterReliefNetwork = disasterReliefNetwork;
    initComponents();
    if (availableRoles == null || availableRoles.isEmpty()) {
            this.availableRoles = new ArrayList<>();
            initRoles();
        } else {
            this.availableRoles = availableRoles;
        }
    populateRoleDropdown(); 
    this.userProcessContainer = mainContainer;
     toggleDynamicFields(false);
    
}
    
    private void initRoles() {
       
        availableRoles = new ArrayList<>();
        availableRoles.add(disasterCoordinator);
        availableRoles.add(new ZoneManager(disasterCoordinator));
        ZoneManager zonemanagerxyz=new ZoneManager(disasterCoordinator);
        availableRoles.add(new ZoneManager(disasterCoordinator));
        availableRoles.add(new CampManager(zonemanagerxyz));
        availableRoles.add(new FieldVolunteer());
        availableRoles.add(new FinanceManager(resourceManager));
        availableRoles.add(new LogisticsManager(resourceManager));
        availableRoles.add(new MedicalOfficer(resourceManager));
        availableRoles.add(new RescueOfficer());
        availableRoles.add(new SecurityOfficer());
        availableRoles.add(new SystemAdmin());
    }
    
     private void populateRoleDropdown() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Role role : availableRoles) {
            model.addElement(role.getClass().getSimpleName());
        }
        rolecombo.setModel(model);
        rolecombo.addActionListener(e -> handleRoleSelection());
    }
     
       private void handleRoleSelection() {
        String selectedRole = (String) rolecombo.getSelectedItem();
        toggleDynamicFields(false); // Hide all dynamic fields first

        switch (selectedRole) {
            case "DisasterCoordinator":
                lblplace.setVisible(true);
                txtplace.setVisible(true);
                break;
            case "ZoneManager":
                lblplace1.setVisible(true);
                comboplace.setVisible(true);
                lblzone.setVisible(true);
                combozone.setVisible(true);
                populatePlaceComboBox();
                break;
            case "CampManager":
                lblplace1.setVisible(true);
                comboplace.setVisible(true);
                lblzone.setVisible(true);
                combozone.setVisible(true);
                lblcamp.setVisible(true);
                combocamp.setVisible(true);
                populatePlaceComboBox();
                break;
            case "FieldVolunteer":
                lblplace1.setVisible(true);
                comboplace.setVisible(true);
                lblzone.setVisible(true);
                combozone.setVisible(true);
                lblcamp.setVisible(true);
                combocamp.setVisible(true);
                populatePlaceComboBox();
                break;
            default:
                break;
        }
    }
      private void populatePlaceComboBox() {
    comboplace.removeAllItems();
    for (Place place : disasterCoordinator.getPlaces()) { // Assuming getPlaces() exists in DisasterCoordinator
        comboplace.addItem(place.getName());
    }
    comboplace.addActionListener(e -> populateZoneComboBox());
    if (comboplace.getItemCount() > 0) {
        comboplace.setSelectedIndex(0);
        populateZoneComboBox();
    }
}
      private void populateZoneComboBox() {
    combozone.removeAllItems();
    String selectedPlace = (String) comboplace.getSelectedItem();
    if (selectedPlace != null) {
        for (Place place : disasterCoordinator.getPlaces()) {
            if (place.getName().equals(selectedPlace)) {
                for (Zone zone : place.getZones()) {
                    combozone.addItem(zone.getName());
                }
            }
        }
    }
    combozone.addActionListener(e -> populateCampComboBox());
    if (combozone.getItemCount() > 0) {
        combozone.setSelectedIndex(0);
        populateCampComboBox();
    }
}
      
      private void populateCampComboBox() {
    combocamp.removeAllItems();
    String selectedZone = (String) combozone.getSelectedItem();
    String selectedPlace = (String) comboplace.getSelectedItem();

    if (selectedZone != null && selectedPlace != null) {
        for (Place place : disasterCoordinator.getPlaces()) {
            if (place.getName().equals(selectedPlace)) {
                for (Zone zone : place.getZones()) {
                    if (zone.getName().equals(selectedZone)) {
                        for (Camp camp : zone.getCamps()) {
                            combocamp.addItem(camp.getName());
                        }
                    }
                }
            }
        }
    }
}

      
      private void toggleDynamicFields(boolean isVisible) {
        lblplace.setVisible(isVisible);
        lblplace1.setVisible(isVisible);
        txtplace.setVisible(isVisible);
        comboplace.setVisible(isVisible);
        lblzone.setVisible(isVisible);
        combozone.setVisible(isVisible);
        lblcamp.setVisible(isVisible);
        combocamp.setVisible(isVisible);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        lblrole = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        rolecombo = new javax.swing.JComboBox<>();
        btnRegister = new javax.swing.JButton();
        lblplace = new javax.swing.JLabel();
        txtplace = new javax.swing.JTextField();
        comboplace = new javax.swing.JComboBox<>();
        combozone = new javax.swing.JComboBox<>();
        combocamp = new javax.swing.JComboBox<>();
        lblplace1 = new javax.swing.JLabel();
        lblzone = new javax.swing.JLabel();
        lblcamp = new javax.swing.JLabel();
        lblname1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblname2 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblname3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create a New User Role");

        lblname.setForeground(new java.awt.Color(255, 255, 255));
        lblname.setText("Name");

        lblrole.setForeground(new java.awt.Color(255, 255, 255));
        lblrole.setText("Role");

        rolecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRegister.setBackground(new java.awt.Color(0, 0, 0));
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        lblplace.setForeground(new java.awt.Color(255, 255, 255));
        lblplace.setText("Place");

        comboplace.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        combozone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        combocamp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblplace1.setForeground(new java.awt.Color(255, 255, 255));
        lblplace1.setText("Place");

        lblzone.setForeground(new java.awt.Color(255, 255, 255));
        lblzone.setText("Zone");

        lblcamp.setForeground(new java.awt.Color(255, 255, 255));
        lblcamp.setText("Camp");

        lblname1.setForeground(new java.awt.Color(255, 255, 255));
        lblname1.setText("Email");

        lblname2.setForeground(new java.awt.Color(255, 255, 255));
        lblname2.setText("Age");

        lblname3.setForeground(new java.awt.Color(255, 255, 255));
        lblname3.setText("Password");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(586, Short.MAX_VALUE)
                .addComponent(btnRegister)
                .addGap(534, 534, 534))
            .addGroup(layout.createSequentialGroup()
                .addGap(416, 416, 416)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblrole, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rolecombo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblname1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblname3)
                        .addGap(5, 5, 5)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblname2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblcamp)
                        .addGap(27, 27, 27)
                        .addComponent(combocamp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblplace)
                            .addComponent(lblplace1)
                            .addComponent(lblzone))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(combozone, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboplace, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtplace, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rolecombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblrole))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblname)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblname1)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblname2)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblname3)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblplace)
                            .addComponent(txtplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblplace1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combozone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblzone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combocamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcamp))))
                .addGap(168, 168, 168)
                .addComponent(btnRegister)
                .addContainerGap(301, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
       
     
String selectedRole = (String) rolecombo.getSelectedItem();
String name=txtname.getText().trim();
String email= txtEmail.getText().trim();
String age = txtAge.getText().trim();
String password = txtPassword.getText().trim();

if (name.isEmpty() || email.isEmpty() || age.isEmpty() || password.isEmpty()) {
    JOptionPane.showMessageDialog(this, "All fields are required. Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

// Validation
if (!ValidationUtils.isValidName(name)) {
    JOptionPane.showMessageDialog(this, "Invalid name. Please enter a valid name.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

// Validation for Email
if (!ValidationUtils.isValidEmail(email)) {
    JOptionPane.showMessageDialog(this, "Invalid email. Please enter a valid email address in the format example@domain.com.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

// Validation for Age
if (!ValidationUtils.isValidAge(age)) {
    JOptionPane.showMessageDialog(this, "Invalid age. Please enter a valid age between 18 and 120.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

// Validation for Password
if (!ValidationUtils.isValidPassword(password)) {
    JOptionPane.showMessageDialog(this, "Invalid password. Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

// Role-specific logic
if ("DisasterCoordinator".equals(selectedRole)) {
    
    String placeName = txtplace.getText().trim();
    if (name.isEmpty() || placeName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Place cannot be empty for Disaster Coordinator.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check for duplicate places
    if (disasterCoordinator.getPlaces() == null) {
    disasterCoordinator.getPlaces(); // Ensure the list is initialized
}


if (placeName.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Place name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

if (disasterCoordinator.placeExists(placeName)) {
    JOptionPane.showMessageDialog(this, "Place already exists.", "Error", JOptionPane.ERROR_MESSAGE);
} else {
    disasterCoordinator.addPlace(new Place(placeName));
    User user = new User(IDGenerator.generateID(), name,txtEmail.getText().trim(),txtPassword.getText().trim(),Integer.parseInt(txtAge.getText().trim()), disasterCoordinator);
    registeredUsers.putIfAbsent("DisasterCoordinator", new ArrayList<>()); // Ensure list exists
    registeredUsers.get("DisasterCoordinator").add(user); // Add user to list
    JOptionPane.showMessageDialog(this, "Place added successfully!");
}
} else if ("ZoneManager".equals(selectedRole)) {
    String selectedPlace = (String) comboplace.getSelectedItem();
    String selectedZone = (String) combozone.getSelectedItem();
    String selectedName= (String) txtname.getText();
    

    if (selectedPlace == null || selectedZone == null) {
        JOptionPane.showMessageDialog(this, "Please select a valid place and zone for Zone Manager.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Place place = disasterCoordinator.getPlaces()
                                     .stream()
                                     .filter(p -> p.getName().equals(selectedPlace))
                                     .findFirst()
                                     .orElse(null);

    if (place == null) {
        JOptionPane.showMessageDialog(this, "Invalid place selected. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Zone zone = place.getZones()
                     .stream()
                     .filter(z -> z.getName().equals(selectedZone))
                     .findFirst()
                     .orElse(null);

    if (zone == null) {
        JOptionPane.showMessageDialog(this, "Invalid zone selected. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    ZoneManager zoneManager = new ZoneManager(disasterCoordinator);
    
    zone.setManager(zoneManager);
    disasterCoordinator.assignZoneManager(selectedPlace, selectedZone, zoneManager);
    User user = new User(IDGenerator.generateID(), selectedName,txtEmail.getText().trim(),txtPassword.getText().trim(),Integer.parseInt(txtAge.getText().trim()), zoneManager);
    registeredUsers.putIfAbsent("ZoneManager", new ArrayList<>()); // Ensure list exists
    registeredUsers.get("ZoneManager").add(user); // Add user to list
    JOptionPane.showMessageDialog(this, "Zone Manager registered for zone: " + selectedZone);

} else if ("CampManager".equals(selectedRole)) {
    String selectedPlace = (String) comboplace.getSelectedItem();
    String selectedZone = (String) combozone.getSelectedItem();
    String selectedCamp = (String) combocamp.getSelectedItem();
    String name2 = (String) txtname.getText();

    if (selectedPlace == null || selectedZone == null || selectedCamp == null || name2 == null || name2.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a valid name, place, zone, and camp for Camp Manager.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if( name2.trim().isEmpty()){
        JOptionPane.showMessageDialog(this, "Please enter a valid name Camp Manager.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Place place = disasterCoordinator.getPlaces()
                                     .stream()
                                     .filter(p -> p.getName().equals(selectedPlace))
                                     .findFirst()
                                     .orElse(null);

    if (place == null) {
        JOptionPane.showMessageDialog(this, "Invalid place selected. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Zone zone = place.getZones()
                     .stream()
                     .filter(z -> z.getName().equals(selectedZone))
                     .findFirst()
                     .orElse(null);

    if (zone == null) {
        JOptionPane.showMessageDialog(this, "Invalid zone selected. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    ZoneManager zoneManager = zone.getManager(); // Fetch the ZoneManager instance
    if (zoneManager == null) {
        JOptionPane.showMessageDialog(this, "Zone Manager not found for the selected zone.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Camp camp = zone.getCamps()
                    .stream()
                    .filter(c -> c.getName().equals(selectedCamp))
                    .findFirst()
                    .orElse(null);

    if (camp == null) {
        JOptionPane.showMessageDialog(this, "Invalid camp selected. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    CampManager campManager = new CampManager(zoneManager);
    camp.setManager(campManager);

    try {
        // Create the user
        User user = new User(IDGenerator.generateID(), txtname.getText(),txtEmail.getText().trim(),txtPassword.getText().trim(),Integer.parseInt(txtAge.getText().trim()), campManager);
        registeredUsers.putIfAbsent("CampManager", new ArrayList<>()); // Ensure list exists
        registeredUsers.get("CampManager").add(user); // Add user to list
        // Register the user
//        registeredUsers.putIfAbsent(selectedRole, new ArrayList<>());
//        registeredUsers.get(selectedRole).add(user);

        // Show success message
        JOptionPane.showMessageDialog(this, "Camp Manager registered successfully for camp: " + selectedCamp);

    } catch (IllegalArgumentException ex) {
        // Show error message if User creation fails
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
} else if ("LogisticsManager".equals(selectedRole)) {
    String nameuser=(String) txtname.getText().trim();
// Common logic for registering the user
User user = new User(IDGenerator.generateID(), nameuser,txtEmail.getText().trim(),txtPassword.getText().trim(),Integer.parseInt(txtAge.getText().trim()), availableRoles.stream()
                                                                   .filter(role -> role.getClass().getSimpleName().equals(selectedRole))
                                                                   .findFirst()
                                                                   .orElse(null));
registeredUsers.putIfAbsent("LogisticsManager", new ArrayList<>()); // Ensure list exists
registeredUsers.get("LogisticsManager").add(user); // Add user to list

JOptionPane.showMessageDialog(this, "User registered successfully!");
}else if ("MedicalOfficer".equals(selectedRole)) {
    String nameuser=(String) txtname.getText().trim();
// Common logic for registering the user
User user = new User(IDGenerator.generateID(), nameuser,txtEmail.getText().trim(),txtPassword.getText().trim(),Integer.parseInt(txtAge.getText().trim()), availableRoles.stream()
                                                                   .filter(role -> role.getClass().getSimpleName().equals(selectedRole))
                                                                   .findFirst()
                                                                   .orElse(null));
registeredUsers.putIfAbsent("MedicalOfficer", new ArrayList<>()); // Ensure list exists
registeredUsers.get("MedicalOfficer").add(user); // Add user to list

JOptionPane.showMessageDialog(this, "User registered successfully!");
}else if ("FinanceManager".equals(selectedRole)) {
    String nameuser=(String) txtname.getText().trim();
// Common logic for registering the user
User user = new User(IDGenerator.generateID(), nameuser,txtEmail.getText().trim(),txtPassword.getText().trim(),Integer.parseInt(txtAge.getText().trim()), availableRoles.stream()
                                                                   .filter(role -> role.getClass().getSimpleName().equals(selectedRole))
                                                                   .findFirst()
                                                                   .orElse(null));
registeredUsers.putIfAbsent("FinanceManager", new ArrayList<>()); // Ensure list exists
registeredUsers.get("FinanceManager").add(user); // Add user to list

JOptionPane.showMessageDialog(this, "User registered successfully!");
}
// Clear the input fields
txtname.setText("");
txtplace.setText("");
txtEmail.setText("");
txtAge.setText("");
txtPassword.setText("");
comboplace.setSelectedIndex(-1);
combozone.setSelectedIndex(-1);
combocamp.setSelectedIndex(-1);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    userProcessContainer.remove(this);
    
    // Refresh and revalidate the container to ensure the previous panel is displayed
    java.awt.CardLayout layout = (java.awt.CardLayout) userProcessContainer.getLayout();
    layout.previous(userProcessContainer);        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox<String> combocamp;
    private javax.swing.JComboBox<String> comboplace;
    private javax.swing.JComboBox<String> combozone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblcamp;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblname1;
    private javax.swing.JLabel lblname2;
    private javax.swing.JLabel lblname3;
    private javax.swing.JLabel lblplace;
    private javax.swing.JLabel lblplace1;
    private javax.swing.JLabel lblrole;
    private javax.swing.JLabel lblzone;
    private javax.swing.JComboBox<String> rolecombo;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtplace;
    // End of variables declaration//GEN-END:variables
}
