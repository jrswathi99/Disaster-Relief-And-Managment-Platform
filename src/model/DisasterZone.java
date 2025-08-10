/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class DisasterZone {
    private String id;
    private String name;
    private int severityLevel;

    public DisasterZone(String id, String name, int severityLevel) {
        if (severityLevel < 1 || severityLevel > 10) {
            throw new IllegalArgumentException("Invalid Severity Level");
        }
        this.id = id;
        this.name = name;
        this.severityLevel = severityLevel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(int severityLevel) {
        this.severityLevel = severityLevel;
    }
}
