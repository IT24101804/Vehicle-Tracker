/* package vms.model;

public class Vehicle {
    private String vehicleId;
    private String customerId;
    private String make;   // changed from 'brand'
    private String model;
    private String year;

    public Vehicle() {}

    public Vehicle(String vehicleId, String customerId, String make, String model, String year) {
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters and setters
    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getMake() { return make; } // changed
    public void setMake(String make) { this.make = make; } // changed

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    @Override
    public String toString() {
        return vehicleId + "," + customerId + "," + make + "," + model + "," + year;
    }

    public static Vehicle fromString(String line) {
        String[] parts = line.split(",");
        return new Vehicle(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }

    
    
}*/


package vms.model;

public class Vehicle {
    private String vehicleId;
    private String customerId;
    private String make;
    private String model;
    private String year;

    public Vehicle() {}

    public Vehicle(String vehicleId, String customerId, String make, String model, String year) {
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters and setters
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return vehicleId + "," + customerId + "," + make + "," + model + "," + year;
    }

    public static Vehicle fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 5) {
            return new Vehicle(parts[0], parts[1], parts[2], parts[3], parts[4]);
        } else {
            return null; // Or handle error case
        }
    }
}





