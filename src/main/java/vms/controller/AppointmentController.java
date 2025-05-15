package vms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vms.model.Appointment;
import vms.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Get all appointments for a specific customer
    @GetMapping("/by-customer/{customerId}")
    public List<Appointment> getAppointmentsByCustomer(@PathVariable String customerId) throws IOException {
        return appointmentService.getAppointmentsByCustomer(customerId);
    }

    // Add a new appointment
    @PostMapping("/add")
    public void addAppointment(@RequestBody Appointment appointment) throws IOException {
        System.out.println("Received appointment: " + appointment.toString());
        appointmentService.addAppointment(appointment);
}


    

    // Delete an appointment by appointmentId
    /*@DeleteMapping("/delete/{appointmentId}")
    public void deleteAppointment(@PathVariable String appointmentId) throws IOException {
        appointmentService.deleteAppointment(appointmentId);
    }*/

    @DeleteMapping("/delete/{id}")
    public void deleteAppointment(@PathVariable String id) throws IOException {
    appointmentService.deleteAppointment(id);
}


    @PutMapping("/update")
    public ResponseEntity<String> updateAppointment(@RequestBody Appointment appointment) throws IOException {
        appointmentService.updateAppointment(appointment);
        return ResponseEntity.ok("Updated");
}

    // Get all appointments (Admin view)
    @GetMapping("/all")
    public List<Appointment> getAllAppointments() throws IOException {
    return appointmentService.getAllAppointments();
    }

    

    // Get all pending appointments
    @GetMapping("/pending")
    public List<Appointment> getPendingAppointments() throws IOException {
        return appointmentService.getPendingAppointments();
    }

    // Get all completed appointments
    @GetMapping("/completed")
    public List<Appointment> getCompletedAppointments() throws IOException {
        return appointmentService.getCompletedAppointments();
    }

    // Mark an appointment as completed
    @PostMapping("/{appointmentId}/complete")
    public void completeAppointment(@PathVariable String appointmentId) throws IOException {
        appointmentService.completeAppointment(appointmentId);
    }


    

    
}
