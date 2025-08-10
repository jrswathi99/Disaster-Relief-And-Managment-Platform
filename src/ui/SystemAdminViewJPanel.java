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
import javax.swing.table.DefaultTableModel;
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
public class SystemAdminViewJPanel extends javax.swing.JPanel {
    
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
    public SystemAdminViewJPanel(JPanel mainContainer, ArrayList<Role> availableRoles, HashMap<String, ArrayList<User>> registeredUsers,DisasterCoordinator disasterCoordinator,ResourceManager resourceManager,ResourceRequest resourceRequest,
            DisasterReliefNetwork1 disasterReliefNetwork) {
    this.availableRoles = availableRoles;
    this.registeredUsers=registeredUsers;
    this.disasterCoordinator=disasterCoordinator;
    this.resourceManager=resourceManager;
    this.disasterReliefNetwork = disasterReliefNetwork;
    initComponents();
      populateUserTable();
      tblUsers.getSelectionModel().addListSelectionListener(event -> {
    if (!event.getValueIsAdjusting()) {
        int selectedRow = tblUsers.getSelectedRow();
        if (selectedRow >= 0) {
            String role = (String) tblUsers.getValueAt(selectedRow, 0);
            String name = (String) tblUsers.getValueAt(selectedRow, 1);
            String email = (String) tblUsers.getValueAt(selectedRow, 2);
            int age = (int) tblUsers.getValueAt(selectedRow, 3);
            String password = (String) tblUsers.getValueAt(selectedRow, 4);

            txtname.setText(name);
            txtEmail.setText(email);
            txtAge.setText(String.valueOf(age));
            txtPassword.setText(password);
        }
    }
});

   
    
}
private void populateUserTable() {
    DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();
    model.setRowCount(0); // Clear existing rows

    for (String role : registeredUsers.keySet()) {
        for (User user : registeredUsers.get(role)) {
            Object[] row = new Object[5];
            row[0] = role;
            row[1] = user.getName();
            row[2] = user.getEmail();
            row[3] = user.getAge();
            row[4] = user.getPassword();
            model.addRow(row);
        }
    }
}

    
    
  
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        lblname1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblname2 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblname3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update User");

        lblname.setForeground(new java.awt.Color(255, 255, 255));
        lblname.setText("Name");

        btnDelete.setBackground(new java.awt.Color(0, 0, 0));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblname1.setForeground(new java.awt.Color(255, 255, 255));
        lblname1.setText("Email");

        lblname2.setForeground(new java.awt.Color(255, 255, 255));
        lblname2.setText("Age");

        lblname3.setForeground(new java.awt.Color(255, 255, 255));
        lblname3.setText("Password");

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblUsers.setBackground(new java.awt.Color(0, 0, 0));
        tblUsers.setForeground(new java.awt.Color(255, 255, 255));
        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Role", "Name", "Email", "Age", "Password"
            }
        ));
        jScrollPane1.setViewportView(tblUsers);

        btnUpdate.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(134, 134, 134))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(445, 445, 445))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addGap(513, 513, 513))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
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
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(btnUpdate)
                .addGap(117, 117, 117))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblUsers.getSelectedRow();
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select a user to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String role = (String) tblUsers.getValueAt(selectedRow, 0);
    String name = (String) tblUsers.getValueAt(selectedRow, 1); 

    registeredUsers.get(role).removeIf(user -> user.getName().equals(name));

    JOptionPane.showMessageDialog(this, "User deleted successfully.");
    populateUserTable();
     

    
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    userProcessContainer.remove(this);
    
    // Refresh and revalidate the container to ensure the previous panel is displayed
    java.awt.CardLayout layout = (java.awt.CardLayout) userProcessContainer.getLayout();
    layout.previous(userProcessContainer);       
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
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
        int selectedRow = tblUsers.getSelectedRow();
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select a user to update.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String role = (String) tblUsers.getValueAt(selectedRow, 0);
    String oldName = (String) tblUsers.getValueAt(selectedRow, 1); 

    for (User user : registeredUsers.get(role)) {
        if (user.getName().equals(oldName)) {
            user.setName(txtname.getText().trim());
            user.setEmail(txtEmail.getText().trim());
            user.setAge(Integer.parseInt(txtAge.getText().trim()));
            user.setPassword(txtPassword.getText().trim());
            break;
        }
    }

    JOptionPane.showMessageDialog(this, "User details updated successfully.");
    populateUserTable();
    }//GEN-LAST:event_btnUpdateActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblname1;
    private javax.swing.JLabel lblname2;
    private javax.swing.JLabel lblname3;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
