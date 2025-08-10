package enterprise;

import organization.FoodDistributionCompany;
import organization.TransportationUnit;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aadar
 */

public class LogisticsCompany {
    private String name;
    private TransportationUnit transportationUnit;

    public FoodDistributionCompany getFoodDistributionCompany() {
        return foodDistributionCompany;
    }

    public void setFoodDistributionCompany(FoodDistributionCompany foodDistributionCompany) {
        this.foodDistributionCompany = foodDistributionCompany;
    }
    private FoodDistributionCompany foodDistributionCompany;

    public LogisticsCompany(String name, TransportationUnit transportationUnit,FoodDistributionCompany foodDistributionCompany) {
        this.name = name;
        this.transportationUnit = transportationUnit;
        this.foodDistributionCompany = foodDistributionCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TransportationUnit getTransportationUnit() {
        return transportationUnit;
    }

    public void setTransportationUnit(TransportationUnit transportationUnit) {
        this.transportationUnit = transportationUnit;
    }
}
