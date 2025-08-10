/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roles;

/**
 *
 * @author DELL
 */

import utils.IDGenerator;

import java.util.ArrayList;
import model.IncidentReport;
import model.Role;

public class FieldVolunteer extends Role {
    private ArrayList<IncidentReport> incidentReports;

    public FieldVolunteer() {
        super("FieldVolunteer");
        this.incidentReports = new ArrayList<>();
    }

    public void reportIncident(String location, int severity) {
        if (location == null || location.isEmpty() || severity < 1 || severity > 10) {
            System.out.println("Error: Invalid incident details.");
            return;
        }
        IncidentReport incident = new IncidentReport(IDGenerator.generateID(), location, severity);
        incidentReports.add(incident);
        System.out.println("Incident reported successfully at: " + location + " with Severity: " + severity);
    }

    public void listIncidents() {
        if (incidentReports.isEmpty()) {
            System.out.println("No incidents reported.");
            return;
        }
        System.out.println("Listing all incidents reported:");
        for (IncidentReport report : incidentReports) {
            System.out.println("- ID: " + report.getId() + ", Location: " + report.getLocation()
                    + ", Severity: " + report.getSeverity());
        }
    }

    @Override
    public void performRoleSpecificWork() {
        System.out.println("Field Volunteer reporting incidents and providing updates...");
    }
}
