package vms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vms.model.ServiceRecord;
import vms.service.ServiceRecordService;

@RestController
@RequestMapping("/api/service-records")
@CrossOrigin(origins = "*")
public class ServiceRecordController {

    @Autowired
    private ServiceRecordService serviceRecordService;

    @PostMapping
    public void addService(@RequestBody ServiceRecord record) throws IOException {
        serviceRecordService.addServiceRecord(record);
    }

    @GetMapping
    public List<ServiceRecord> getAllServiceRecords() throws IOException {
        return serviceRecordService.getAllServiceRecords();
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceRecord> getRecordsByVehicleId(@PathVariable String vehicleId) throws IOException {
    return serviceRecordService.getRecordsByVehicleId(vehicleId);
    }

    @GetMapping("/customer/{customerId}")
    public List<ServiceRecord> getRecordsByCustomerId(@PathVariable String customerId) throws IOException {
    return serviceRecordService.getRecordsByCustomerId(customerId);
    }




    

}
