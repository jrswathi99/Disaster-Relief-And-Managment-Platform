/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import Configuration.DisasterReliefNetwork1;
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
import model.User;
import model.WorkRequest;
import model.Zone;
import network.DisasterReliefNetwork;
import roles.CampManager;
import roles.DisasterCoordinator;
import roles.FieldVolunteer;
import roles.FinanceManager;
import roles.LogisticsManager;
import roles.MedicalOfficer;
import roles.RescueOfficer;
import roles.SecurityOfficer;
import roles.ZoneManager;
import ui.DisasterCoordinator.DisasterCoordinatorJPanel;

/**
 *
 * @author DELL
 */
public class MainJFrame extends javax.swing.JFrame {

    private ArrayList<Role> availableRoles; // List of available roles
    private HashMap<String, ArrayList<User>> registeredUsers;
    private DisasterCoordinator disasterCoordinator;
    private ZoneManager zoneManager;
    private ResourceManager resourceManager;
    private SecurityResourceManager securityResourceManager;
    private RescueResourceManager rescueResourceManager;
    private ResourceRequest resourceRequest;
    private DisasterReliefNetwork1 disasterReliefNetwork;

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        resourceManager = new ResourceManager();
        disasterReliefNetwork = Configuration.ConfigueNetwork.initialize(resourceManager);
        disasterCoordinator = disasterReliefNetwork.getGovernmentAgency().getGovernmentAgent().getDisasterCoordinator();
        resourceManager = new ResourceManager();
        securityResourceManager = new SecurityResourceManager();
        rescueResourceManager = new RescueResourceManager();
        initializeRoles();
        setSize(1300, 1000);
        setResizable(true);

        availableRoles = new ArrayList<>();
        registeredUsers = new HashMap<>();

        addDummyData();

        // Add dummy data
//    addDummyData(disasterCoordinator);
        // Ensure the table gets populated
    }

    private void initializeRoles() {

        zoneManager = new ZoneManager(disasterCoordinator);
    }

    private void addDummyData() {
        // Add roles
        // Add roles
        availableRoles.add(disasterCoordinator);
        availableRoles.add(new ZoneManager(disasterCoordinator));
        availableRoles.add(new CampManager(zoneManager));
        availableRoles.add(new FieldVolunteer());
        availableRoles.add(new FinanceManager(resourceManager));
        availableRoles.add(new LogisticsManager(resourceManager));
        availableRoles.add(new MedicalOfficer(resourceManager));
        availableRoles.add(new RescueOfficer());
        availableRoles.add(new SecurityOfficer());
 
        // Add places
        Place place1 = new Place("City A");
        Place place2 = new Place("City B");
        disasterCoordinator.addPlace(place1);
        disasterCoordinator.addPlace(place2);
 
        // Add zones
        Zone zone1 = new Zone("Zone E","medium");
        Zone zone2 = new Zone("Zone F","medium");
        place1.addZone(zone1);
        place1.addZone(zone2);
 
        Zone zone3 = new Zone("Zone 3","medium");
        Zone zone4 = new Zone("Zone 4","medium");
        place2.addZone(zone3);
        place2.addZone(zone4);
 
        // Add camps
        Camp camp1 = new Camp("Camp 1","medium",50,100);
        Camp camp2 = new Camp("Camp 2","medium",50,100);
        zone1.addCamp(camp1);
        zone1.addCamp(camp2);
 
        Camp camp3 = new Camp("Camp 3","medium",50,100);
        Camp camp4 = new Camp("Camp 4","medium",50,100);
        zone2.addCamp(camp3);
        zone2.addCamp(camp4);
 
        // Add users
        User disasterUser = new User("D001", "Alice","user@email.com","password123",22, disasterCoordinator);
        User campManagerUser = new User("C001", "Charlie","user@email.com","password123",22, new CampManager(zoneManager));
        User financeManagerUser = new User("F001", "Diana","user@email.com","password123",22, new FinanceManager(resourceManager));
        User logisticsManagerUser = new User("L001", "Eve", "user@email.com","password123",22,new LogisticsManager(resourceManager));
        User medicalOfficerUser = new User("M001", "Frank","user@email.com","password123",22, new MedicalOfficer(resourceManager));
 
        // Register users
        registeredUsers.putIfAbsent("DisasterCoordinator", new ArrayList<>());
        registeredUsers.get("DisasterCoordinator").add(disasterUser);
 
        registeredUsers.putIfAbsent("ZoneManager", new ArrayList<>());
 
        registeredUsers.putIfAbsent("CampManager", new ArrayList<>());
        registeredUsers.get("CampManager").add(campManagerUser);
 
        registeredUsers.putIfAbsent("FinanceManager", new ArrayList<>());
        registeredUsers.get("FinanceManager").add(financeManagerUser);
 
        registeredUsers.putIfAbsent("LogisticsManager", new ArrayList<>());
        registeredUsers.get("LogisticsManager").add(logisticsManagerUser);
 
        registeredUsers.putIfAbsent("MedicalOfficer", new ArrayList<>());
        registeredUsers.get("MedicalOfficer").add(medicalOfficerUser);
        
        Iterable<User> userList = Configuration.ConfigureUser.initialize(resourceManager);
        for (User user : userList) {
            String roleName = user.getRole().getClass().getSimpleName();
            registeredUsers.putIfAbsent(roleName, new ArrayList<>());
            registeredUsers.get(roleName).add(user);
        }

 
        System.out.println("Dummy data added successfully.");
    }

    public DisasterCoordinator getDisasterCoordinator() {
        return disasterCoordinator;
    }

    public ZoneManager getZoneManager() {
        return zoneManager;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        controlpanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        workarea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        controlpanel.setBackground(new java.awt.Color(0, 0, 0));
        controlpanel.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("System Admin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Role Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnReports.setBackground(new java.awt.Color(0, 102, 102));
        btnReports.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        btnReports.setForeground(new java.awt.Color(255, 255, 255));
        btnReports.setText("Reports");
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlpanelLayout = new javax.swing.GroupLayout(controlpanel);
        controlpanel.setLayout(controlpanelLayout);
        controlpanelLayout.setHorizontalGroup(
            controlpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        controlpanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        controlpanelLayout.setVerticalGroup(
            controlpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlpanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jButton1)
                .addGap(29, 29, 29)
                .addComponent(jButton2)
                .addGap(41, 41, 41)
                .addComponent(btnReports)
                .addContainerGap(573, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(controlpanel);

        workarea.setBackground(new java.awt.Color(0, 102, 102));
        workarea.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(workarea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

// TODO add your handling code here:
        SystemAdminLoginJPanel awajp = new SystemAdminLoginJPanel(workarea, availableRoles, registeredUsers, disasterCoordinator, resourceManager, resourceRequest, disasterReliefNetwork);
        workarea.add("SystemAdminLoginJPanel", awajp);
        CardLayout layout = (CardLayout) workarea.getLayout();
        layout.next(workarea);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        RoleLoginJPanel awajp1 = new RoleLoginJPanel(workarea, availableRoles, registeredUsers, disasterCoordinator, resourceManager, securityResourceManager,
                rescueResourceManager, disasterReliefNetwork);

        workarea.add("RoleLoginJPanel", awajp1);
        CardLayout layout = (CardLayout) workarea.getLayout();
        layout.next(workarea);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        ReportJPanel reportPanel = new ReportJPanel(disasterReliefNetwork,disasterCoordinator);
        workarea.add(" ReportJPanel",reportPanel);
        CardLayout layout = (CardLayout)workarea.getLayout();
        layout.next(workarea);        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReports;
    private javax.swing.JPanel controlpanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel workarea;
    // End of variables declaration//GEN-END:variables
}
