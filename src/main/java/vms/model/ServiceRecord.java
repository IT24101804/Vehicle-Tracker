/*package vms.model;

public class ServiceRecord {
    private String serviceId;
    private String vehicleId;
    private String customerName;
    private String date;
    private String description;
    private String status;
    private String cost;

    // Constructors
    public ServiceRecord() {}

    public ServiceRecord(String serviceId, String vehicleId, String customerName, String date, String description, String status, String cost) {
        this.serviceId = serviceId;
        this.vehicleId = vehicleId;
        this.customerName = customerName;
        this.date = date;
        this.description = description;
        this.status = status;
        this.cost = cost;
    }

    // Getters and Setters
    public String getServiceId() { return serviceId; }
    public void setServiceId(String serviceId) { this.serviceId = serviceId; }

    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCost() { return cost; }
    public void setCost(String cost) { this.cost = cost; }

    @Override
    public String toString() {
        return serviceId + "," + vehicleId + "," + customerName + "," + date + "," + description + "," + status + "," + cost;
    }

    public static ServiceRecord fromString(String line) {
        String[] parts = line.split(",", -1);
        return new ServiceRecord(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
    }
}
*/ 

package vms.model;

public class ServiceRecord {
    private String serviceId;
    private String vehicleId;
    private String customerId;
    private String customerName;
    private String date;
    private String description;
    private String status;
    private String cost;

    public ServiceRecord() {}

    public ServiceRecord(String serviceId, String vehicleId, String customerId, String customerName, String date, String description, String status, String cost) {
        this.serviceId = serviceId;
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.date = date;
        this.description = description;
        this.status = status;
        this.cost = cost;
    }

    public String getServiceId() { return serviceId; }
    public void setServiceId(String serviceId) { this.serviceId = serviceId; }

    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCost() { return cost; }
    public void setCost(String cost) { this.cost = cost; }

    @Override
    public String toString() {
        return serviceId + "," + vehicleId + "," + customerId + "," + customerName + "," + date + "," + description + "," + status + "," + cost;
    }

    public static ServiceRecord fromString(String line) {
        String[] parts = line.split(",", -1);
        return new ServiceRecord(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
    }
}
