// src/model/organization/FinanceDepartment.java
package organization;

import roles.FinanceManager;

public class FinanceDepartment {
    private String name;
    private double budget;
    private FinanceManager financeManager;

    public FinanceDepartment(String name, double budget, FinanceManager financeManager) {
        this.name = name;
        this.budget = budget;
        this.financeManager = financeManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public FinanceManager getFinanceManager() {
        return financeManager;
    }

    public void setFinanceManager(FinanceManager financeManager) {
        this.financeManager = financeManager;
    }
}