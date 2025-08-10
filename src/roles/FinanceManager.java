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
import java.util.List;
import model.Budget;
import model.ResourceManager;
import model.ResourceRequest;
import model.Role;

public class FinanceManager extends Role {
    private ArrayList<Budget> budgets;
    private List<ResourceRequest> requests;
    private Budget budget;
    ResourceManager resourceManager;
    public FinanceManager(ResourceManager resourceManager) {
        super("FinanceManager");
        this.budgets = new ArrayList<>();
        this.requests = resourceManager.getAllRequests();
        this.resourceManager=resourceManager;
        this.budget = new Budget("Budget1", 10000000);
    }

    public void trackBudget() {
        if (budgets.isEmpty()) {
            System.out.println("No budgets available to track.");
            return;
        }
        System.out.println("Tracking Budgets:");
        for (Budget budget : budgets) {
            System.out.println("- ID: " + budget.getId() + ", Total: $" + budget.getTotalBudget()
                    + ", Spent: $" + budget.getSpentAmount() + ", Remaining: $" + budget.getRemainingBudget());
        }
    }
    public Budget getBudget() {
        return budget;
    }

    public void allocateFunds(String budgetId, double amount) {
        for (Budget budget : budgets) {
            if (budget.getId().equals(budgetId)) {
                budget.allocateFunds(amount);
                System.out.println("Funds allocated successfully: $" + amount + " to Budget ID: " + budgetId);
                return;
            }
        }
        System.out.println("Error: Budget ID " + budgetId + " not found.");
    }
    
    public double getRemainingBudget() {
    return budget.getRemainingBudget(); // Directly use the budget object
}
    public void allocateFunds(double amount) {
    for (Budget budget : budgets) {
        if (budget.getRemainingBudget() >= amount) {
            budget.allocateFunds(amount);
            return;
        }
    }
    throw new IllegalArgumentException("Insufficient budget to allocate funds.");
}

   public void createBudget(double totalBudget) {
    if (totalBudget <= 0) {
        System.out.println("Error: Budget must be greater than zero.");
        return;
    }
    Budget budget = new Budget(IDGenerator.generateID(), totalBudget);
    budgets.add(budget);
    System.out.println("New Budget Created with ID: " + budget.getId() + " and Total Amount: $" + totalBudget);
}
public boolean approveRequest(String requestId, double totalCost) {
    return resourceManager.approveRequest(requestId, totalCost, budget);
}

   
    @Override
    public void performRoleSpecificWork() {
        System.out.println("Finance Manager managing budgets...");
    }
}
