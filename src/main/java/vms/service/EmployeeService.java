package vms.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vms.model.Employee;
import vms.util.FileUtil;

@Service
public class EmployeeService {
    private final String FILE_NAME = "files/employees.txt";

    public List<Employee> getAllEmployees() throws IOException {
        List<String> lines = FileUtil.readLines(FILE_NAME);
        List<Employee> list = new ArrayList<>();
        for (String line : lines) {
            list.add(Employee.fromString(line));
        }
        return list;
    }

    public Employee getEmployeeById(String id) throws IOException {
        for (Employee e : getAllEmployees()) {
            if (e.getEmployeeId().equals(id)) return e;
        }
        return null;
    }

    public void addEmployee(Employee employee) throws IOException {
        List<String> lines = FileUtil.readLines(FILE_NAME);
        lines.add(employee.toString());
        FileUtil.writeLines(FILE_NAME, lines);
    }

    public void updateEmployee(Employee updated) throws IOException {
        List<Employee> employees = getAllEmployees();
        List<String> lines = new ArrayList<>();

        for (Employee e : employees) {
            if (e.getEmployeeId().equals(updated.getEmployeeId())) {
                lines.add(updated.toString());
            } else {
                lines.add(e.toString());
            }
        }

        FileUtil.writeLines(FILE_NAME, lines);
    }

    public void deleteEmployee(String id) throws IOException {
        List<Employee> employees = getAllEmployees();
        List<String> lines = new ArrayList<>();

        for (Employee e : employees) {
            if (!e.getEmployeeId().equals(id)) {
                lines.add(e.toString());
            }
        }

        FileUtil.writeLines(FILE_NAME, lines);
    }

    public Employee authenticate(String email, String password) throws IOException {
        List<Employee> employees = getAllEmployees();
        for (Employee emp : employees) {
            if (emp.getEmail().equals(email) && emp.getPassword().equals(password)) {
                return emp;
            }
        }
        return null;
    }
}
