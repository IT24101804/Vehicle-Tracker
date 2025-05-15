package vms.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vms.model.Appointment;
import vms.util.FileUtil;

@Service
public class AppointmentService {

    private static final String FILE_NAME = "files/appointments.txt";
    private static final String COMPLETED_FILE_NAME = "files/completed-appointments.txt";
    
    // Add new appointment
    public void addAppointment(Appointment appointment) throws IOException {
        FileUtil.appendLine(FILE_NAME, appointment.toString());
    }

    // Get appointments by customerId
    public List<Appointment> getAppointmentsByCustomer(String customerId) throws IOException {
        List<Appointment> result = new ArrayList<>();
        List<String> lines = FileUtil.readLines(FILE_NAME);
        for (String line : lines) {
            Appointment appointment = Appointment.fromString(line);
            if (appointment.getCustomerId().equals(customerId)) {
                result.add(appointment);
            }
        }
        return result;
    }

    // Update appointment
    public void updateAppointment(Appointment updatedAppointment) throws IOException {
        List<String> lines = FileUtil.readLines(FILE_NAME);
        List<String> updatedLines = new ArrayList<>();

        for (String line : lines) {
            Appointment appointment = Appointment.fromString(line);
            if (appointment.getAppointmentId().equals(updatedAppointment.getAppointmentId())) {
                updatedLines.add(updatedAppointment.toString()); // Replace with updated appointment data
            } else {
                updatedLines.add(line); // Keep original appointment data
            }
        }
        FileUtil.writeLines(FILE_NAME, updatedLines); // Write all lines back to the file
    }

    // Delete an appointment by appointmentId
    public void deleteAppointment(String appointmentId) throws IOException {
        List<String> lines = FileUtil.readLines(FILE_NAME);
        List<String> updatedLines = new ArrayList<>();

        for (String line : lines) {
            Appointment appointment = Appointment.fromString(line);
            if (!appointment.getAppointmentId().equals(appointmentId)) {
                updatedLines.add(line); // Keep appointments that don't match the appointmentId
            }
        }

        FileUtil.writeLines(FILE_NAME, updatedLines); // Write updated list back to the file
    }

    public List<Appointment> getAllAppointments() throws IOException {
        List<Appointment> result = new ArrayList<>();
        List<String> lines = FileUtil.readLines(FILE_NAME);
        for (String line : lines) {
            Appointment appointment = Appointment.fromString(line);
            result.add(appointment);
        }
        return result;
    }
    

    // Get all pending appointments
    public List<Appointment> getPendingAppointments() throws IOException {
        List<Appointment> result = new ArrayList<>();
        List<String> lines = FileUtil.readLines(FILE_NAME);
        for (String line : lines) {
            Appointment appointment = Appointment.fromString(line);
            result.add(appointment);
        }
        return result;
    }

    // Move appointment to completed and delete from pending
    public void completeAppointment(String appointmentId) throws IOException {
        List<String> pendingLines = FileUtil.readLines(FILE_NAME);
        List<String> completedLines = FileUtil.readLines(COMPLETED_FILE_NAME);

        Appointment appointmentToMove = null;

        // Find and remove the appointment from the pending list
        for (String line : pendingLines) {
            Appointment appointment = Appointment.fromString(line);
            if (appointment.getAppointmentId().equals(appointmentId)) {
                appointmentToMove = appointment;
                break;
            }
        }

        if (appointmentToMove != null) {
            pendingLines.removeIf(line -> line.contains(appointmentId));
            completedLines.add(appointmentToMove.toString());
            FileUtil.writeLines(FILE_NAME, pendingLines);
            FileUtil.writeLines(COMPLETED_FILE_NAME, completedLines);
        }
    }

    // Get all completed appointments
    public List<Appointment> getCompletedAppointments() throws IOException {
        List<Appointment> result = new ArrayList<>();
        List<String> lines = FileUtil.readLines(COMPLETED_FILE_NAME);
        for (String line : lines) {
            Appointment appointment = Appointment.fromString(line);
            result.add(appointment);
        }
        return result;
    }
    
}
