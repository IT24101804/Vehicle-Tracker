package vms.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vms.model.Customer;
import vms.util.FileUtil;

@Service
public class CustomerService {
    private final String FILE_NAME = "files/customers.txt";

    // Register new customer
    public void registerCustomer(Customer customer) throws IOException {
        List<String> lines = FileUtil.readLines(FILE_NAME);
        lines.add(customer.toString());
        FileUtil.writeLines(FILE_NAME, lines);
    }

    // Login existing customer
    public Customer loginCustomer(String email, String password) throws IOException {
        List<String> lines = FileUtil.readLines(FILE_NAME);
        for (String line : lines) {
            Customer customer = Customer.fromString(line);
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }

    // Update customer (by customerId)
    public void updateCustomer(Customer updatedCustomer) throws IOException {
        List<String> lines = FileUtil.readLines(FILE_NAME);
        List<String> updatedLines = new ArrayList<>();

        for (String line : lines) {
            Customer customer = Customer.fromString(line);
            if (customer.getCustomerId().equals(updatedCustomer.getCustomerId())) {
                updatedLines.add(updatedCustomer.toString()); // Replace with updated data
            } else {
                updatedLines.add(line); // Keep existing
            }
        }

        FileUtil.writeLines(FILE_NAME, updatedLines);
    }


    public List<Customer> getAllCustomers() throws IOException {
        List<String> lines = FileUtil.readLines(FILE_NAME);
        List<Customer> customers = new ArrayList<>();
        for (String line : lines) {
            customers.add(Customer.fromString(line));
        }
        return customers;
    }


    public void deleteCustomer(String customerId) throws IOException {
        List<String> lines = FileUtil.readLines(FILE_NAME);
        List<String> updatedLines = new ArrayList<>();

        for (String line : lines) {
            Customer customer = Customer.fromString(line);
            if (!customer.getCustomerId().equals(customerId)) {
                updatedLines.add(line); // Keep all except the one to delete
            }
        }

        FileUtil.writeLines(FILE_NAME, updatedLines);
    }
}
