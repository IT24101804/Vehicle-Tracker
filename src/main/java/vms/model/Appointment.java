package vms.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
    private String appointmentId;
    private String customerId;
    private String vehicleId;
    private LocalDateTime appointmentDate;
    private String status;

    public Appointment() {}

    public Appointment(String appointmentId, String customerId, String vehicleId, LocalDateTime appointmentDate, String status) {
        this.appointmentId = appointmentId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }

    public LocalDateTime getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDateTime appointmentDate) { this.appointmentDate = appointmentDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    /*@Override
    public String toString() {
        return appointmentId + "," + customerId + "," + vehicleId + "," + appointmentDate.toString() + "," + status;
    }*/

    /*public static Appointment fromString(String line) {
        String[] parts = line.split(",");
        // Handle parsing date correctly for cases with or without time
        LocalDateTime appointmentDate = parseDate(parts[3]);
        return new Appointment(parts[0], parts[1], parts[2], appointmentDate, parts[4]);
    }*/

    // Method to handle parsing of date with or without time
    public static LocalDateTime parseDate(String dateStr) {
        try {
            // If the date string length is 10 (only date), add default time part
            if (dateStr.length() == 10) {
                dateStr += "T00:00:00"; // Add default time part
            }
            return LocalDateTime.parse(dateStr, DateTimeFormatter.ISO_DATE_TIME);
        } catch (Exception e) {
            e.printStackTrace();
            return LocalDateTime.now(); // Fallback to current date/time in case of error
        }
    }

    @Override
    public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return appointmentId + "," + customerId + "," + vehicleId + "," + appointmentDate.format(formatter) + "," + status;
    }

    // Parse the string from the file
    public static Appointment fromString(String line) {
        String[] parts = line.split(",");
        // Parse date and time correctly
        LocalDateTime appointmentDate = LocalDateTime.parse(parts[3], DateTimeFormatter.ISO_DATE_TIME);
        return new Appointment(parts[0], parts[1], parts[2], appointmentDate, parts[4]);
    }

}
