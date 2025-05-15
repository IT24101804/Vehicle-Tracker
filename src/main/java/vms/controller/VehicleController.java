package vms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vms.model.Vehicle;
import vms.service.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // Get all vehicles for a specific customer
    @GetMapping("/by-customer/{customerId}")
    public List<Vehicle> getVehiclesByCustomer(@PathVariable String customerId) throws IOException {
        return vehicleService.getVehiclesByCustomer(customerId);
    }

    // Add a new vehicle
    @PostMapping("/add")
    public void addVehicle(@RequestBody Vehicle vehicle) throws IOException {
        vehicleService.addVehicle(vehicle);
    }

    // Update an existing vehicle
    @PutMapping("/update")
    public void updateVehicle(@RequestBody Vehicle vehicle) throws IOException {
        vehicleService.updateVehicle(vehicle);
    }

    // Delete a vehicle by vehicleId
    @DeleteMapping("/delete/{vehicleId}")
    public void deleteVehicle(@PathVariable String vehicleId) throws IOException {
        vehicleService.deleteVehicle(vehicleId);
    }

    @GetMapping("/all")
        public List<Vehicle> getAllVehicles() throws IOException {
        return vehicleService.getAllVehicles();
    }


}



