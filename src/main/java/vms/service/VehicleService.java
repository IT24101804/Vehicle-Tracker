package vms.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vms.model.Vehicle;
import vms.util.FileUtil;

@Service
public class VehicleService {
    private static final String FILE_NAME = "files/vehicle.txt";

    
    public void addVehicle(Vehicle vehicle) throws IOException {
        FileUtil.appendLine(FILE_NAME, vehicle.toString());
    }


    public List<Vehicle> getVehiclesByCustomer(String customerId) throws IOException {
        List<Vehicle> result = new ArrayList<>();
        List<String> lines = FileUtil.readLines(FILE_NAME);
        for (String line : lines) {
            Vehicle v = Vehicle.fromString(line);
            if (v.getCustomerId().equals(customerId)) {
                result.add(v);
            }
        }
        return result;
    }

    // Update an existing vehicle
    public void updateVehicle(Vehicle updatedVehicle) throws IOException {
        List<String> lines = FileUtil.readLines(FILE_NAME);
        List<String> updatedLines = new ArrayList<>();

        for (String line : lines) {
            Vehicle vehicle = Vehicle.fromString(line);
            if (vehicle.getVehicleId().equals(updatedVehicle.getVehicleId())) {
                updatedLines.add(updatedVehicle.toString()); // Replace with updated vehicle data
            } else {
                updatedLines.add(line); // Keep original vehicle data
            }
        }
        FileUtil.writeLines(FILE_NAME, updatedLines); // Write all lines back to the file
    }

    // Delete a vehicle by its vehicleId
    public void deleteVehicle(String vehicleId) throws IOException {
        List<String> lines = FileUtil.readLines(FILE_NAME);
        List<String> updatedLines = new ArrayList<>();

        for (String line : lines) {
            Vehicle vehicle = Vehicle.fromString(line);
            if (!vehicle.getVehicleId().equals(vehicleId)) {
                updatedLines.add(line); // Keep vehicles that don't match the vehicleId
            }
        }

        FileUtil.writeLines(FILE_NAME, updatedLines); // Write updated list back to the file
    }


    public List<Vehicle> getAllVehicles() throws IOException {
        List<String> lines = FileUtil.readLines(FILE_NAME);
        List<Vehicle> vehicles = new ArrayList<>();
        for (String line : lines) {
            vehicles.add(Vehicle.fromString(line));
        }
        return vehicles;
    }
    
    
    

    

}


