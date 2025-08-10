package model;

public class TransportVehicle {
    private int id;
    private String type;
    private String status;

    public TransportVehicle(int id, String type, String status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public int getId() { return id; }
    public String getType() { return type; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getDetails() {
        return "ID: " + id + ", Type: " + type + ", Status: " + status;
    }
}
