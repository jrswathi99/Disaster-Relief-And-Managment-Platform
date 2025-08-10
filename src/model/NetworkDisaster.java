package model;

import java.util.ArrayList;
import java.util.List;

public class NetworkDisaster {
    // Collections for all system entities
    private List<Budget> budgets;
    private List<Camp> camps;
    private List<DisasterZone> disasterZones;
    private List<IncidentReport> incidentReports;
    private List<Place> places;
    private List<RescueResourceManager> rescueResourceManagers;
    private List<ResourceManager> resourceManagers;
    private List<ResourceRequest> resourceRequests;
    private List<Role> roles;
    private List<SecurityResourceManager> securityResourceManagers;
    private List<TransportVehicle> transportVehicles;
    private List<User> users;
    private List<WorkRequest> workRequests;
    private List<Zone> zones;

    public NetworkDisaster() {
        this.budgets = new ArrayList<>();
        this.camps = new ArrayList<>();
        this.disasterZones = new ArrayList<>();
        this.incidentReports = new ArrayList<>();
        this.places = new ArrayList<>();
        this.rescueResourceManagers = new ArrayList<>();
        this.resourceManagers = new ArrayList<>();
        this.resourceRequests = new ArrayList<>();
        this.roles = new ArrayList<>();
        this.securityResourceManagers = new ArrayList<>();
        this.transportVehicles = new ArrayList<>();
        this.users = new ArrayList<>();
        this.workRequests = new ArrayList<>();
        this.zones = new ArrayList<>();
    }

    public void addBudget(Budget budget) { budgets.add(budget); }
    public void addCamp(Camp camp) { camps.add(camp); }
    public void addDisasterZone(DisasterZone disasterZone) { disasterZones.add(disasterZone); }
    public void addIncidentReport(IncidentReport report) { incidentReports.add(report); }
    public void addPlace(Place place) { places.add(place); }
    public void addRescueResourceManager(RescueResourceManager manager) { rescueResourceManagers.add(manager); }
    public void addResourceManager(ResourceManager manager) { resourceManagers.add(manager); }
    public void addResourceRequest(ResourceRequest request) { resourceRequests.add(request); }
    public void addRole(Role role) { roles.add(role); }
    public void addSecurityResourceManager(SecurityResourceManager manager) { securityResourceManagers.add(manager); }
    public void addTransportVehicle(TransportVehicle vehicle) { transportVehicles.add(vehicle); }
    public void addUser(User user) { users.add(user); }
    public void addWorkRequest(WorkRequest request) { workRequests.add(request); }
    public void addZone(Zone zone) { zones.add(zone); }
}
