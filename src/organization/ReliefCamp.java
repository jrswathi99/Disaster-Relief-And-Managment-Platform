package organization;

import roles.FieldVolunteer;

 
public class ReliefCamp {
    private String name;
    private int capacity;
    private FieldVolunteer fieldVolunteer;
 
    public ReliefCamp(String name, int capacity, FieldVolunteer fieldVolunteer) {
        this.name = name;
        this.capacity = capacity;
        this.fieldVolunteer = fieldVolunteer;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getCapacity() {
        return capacity;
    }
 
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
 
    public FieldVolunteer getFieldVolunteer() {
        return fieldVolunteer;
    }
 
    public void setFieldVolunteer(FieldVolunteer fieldVolunteer) {
        this.fieldVolunteer = fieldVolunteer;
    }
}