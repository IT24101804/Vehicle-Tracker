package vms.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

import vms.model.Employee;
import vms.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() throws IOException {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable String id) throws IOException {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public void add(@RequestBody Employee employee) throws IOException {
        employeeService.addEmployee(employee);
    }

    @PutMapping
    public void update(@RequestBody Employee employee) throws IOException {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws IOException {
        employeeService.deleteEmployee(id);
    }

    @PostMapping("/login")
    public Employee login(@RequestBody Map<String, String> credentials) throws IOException {
        String email = credentials.get("email");
        String password = credentials.get("password");
        return employeeService.authenticate(email, password);
    }
}
