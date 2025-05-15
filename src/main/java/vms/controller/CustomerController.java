package vms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vms.model.Customer;
import vms.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public void register(@RequestBody Customer customer) throws IOException {
        customerService.registerCustomer(customer);
    }

    @PostMapping("/login")
    public Customer login(@RequestBody Customer loginRequest) throws IOException {
        return customerService.loginCustomer(loginRequest.getEmail(), loginRequest.getPassword());
    }


    @PutMapping("/{id}")
    public void updateCustomerById(@PathVariable String id, @RequestBody Customer updatedCustomer) throws IOException {
        updatedCustomer.setCustomerId(id);
        customerService.updateCustomer(updatedCustomer);
    }


    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) throws IOException {
        customerService.deleteCustomer(id);
    }

    // ✅ Get all customers (used by admin)
    @GetMapping
    public List<Customer> getAllCustomers() throws IOException {
        return customerService.getAllCustomers();
    }
}
