package vms.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import vms.model.ServiceRecord;

@Service
public class ServiceRecordService {
    private final String FILE_PATH = "files/service-records.txt";

    public void addServiceRecord(ServiceRecord record) throws IOException {
        if (record.getServiceId() == null || record.getServiceId().isEmpty()) {
            record.setServiceId("SR-" + UUID.randomUUID().toString().substring(0, 10));
        }
    
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs(); // ✅ Ensures 'files/' directory exists
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(record.toString());
            writer.newLine();
        }
    }
    

    public List<ServiceRecord> getAllServiceRecords() throws IOException {
        List<ServiceRecord> records = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) return records;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(ServiceRecord.fromString(line));
            }
        }
        return records;
    }

    public List<ServiceRecord> getRecordsByVehicleId(String vehicleId) throws IOException {
        List<ServiceRecord> all = getAllServiceRecords();
        List<ServiceRecord> result = new ArrayList<>();
        for (ServiceRecord r : all) {
            if (r.getVehicleId().equals(vehicleId)) {
                result.add(r);
            }
        }
        return result;
    }

    public List<ServiceRecord> getServiceRecordsByVehicleId(String vehicleId) throws IOException {
        List<ServiceRecord> allRecords = getAllServiceRecords();
        List<ServiceRecord> result = new ArrayList<>();
        for (ServiceRecord record : allRecords) {
            if (record.getVehicleId().equals(vehicleId)) {
                result.add(record);
            }
        }
        return result;
    }

    public List<ServiceRecord> getRecordsByCustomerId(String customerId) throws IOException {
        List<ServiceRecord> all = getAllServiceRecords();
        List<ServiceRecord> result = new ArrayList<>();
        for (ServiceRecord r : all) {
            if (r.getCustomerId().equals(customerId)) {
                result.add(r);
            }
        }
        return result;
    }
    
       
}

