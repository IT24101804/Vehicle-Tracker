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

import vms.model.Payment;
import vms.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public void addPayment(@RequestBody Payment payment) throws IOException {
        paymentService.addPayment(payment);
    }

    @GetMapping("/by-customer/{customerId}")
    public List<Payment> getByCustomer(@PathVariable String customerId) throws IOException {
        return paymentService.getPaymentsByCustomer(customerId);
    }

    @GetMapping("/all")
    public List<Payment> getAllPayments() throws IOException {
        return paymentService.getAllPayments();
    }

    @PutMapping("/update")
    public void update(@RequestBody Payment payment) throws IOException {
        paymentService.updatePayment(payment);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) throws IOException {
        paymentService.deletePayment(id);
    }
}
