package vms.model;

public class Employee {
    private String employeeId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String nicNumber;
    private String password;

    public Employee() {}

    public Employee(String employeeId, String name, String email, String phone, String address, String nicNumber, String password) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.nicNumber = nicNumber;
        this.password = password;
    }

    // Getters and Setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getNicNumber() { return nicNumber; }
    public void setNicNumber(String nicNumber) { this.nicNumber = nicNumber; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return employeeId + "," + name + "," + email + "," + phone + "," + address + "," + nicNumber + "," + password;
    }

    public static Employee fromString(String line) {
        String[] parts = line.split(",", 7);
        return new Employee(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
    }
}
