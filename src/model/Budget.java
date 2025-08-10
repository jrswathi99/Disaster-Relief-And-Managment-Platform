/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class Budget {
    private String id;
    private double totalBudget=10000000;
    private double spentAmount;

    public Budget(String id, double totalBudget) {
        this.id = id;
        this.totalBudget = 10000000;
        this.spentAmount = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
    }

    public double getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(double spentAmount) {
        this.spentAmount = spentAmount;
    }
    
    public double getRemainingBudget() { return totalBudget - spentAmount; }
    
    
    public void allocateFunds(double amount) {
        if (amount <= getRemainingBudget()) {
            this.spentAmount += amount;
        } else {
            throw new IllegalArgumentException("Insufficient budget for allocation.");
        }
    }
    
}
