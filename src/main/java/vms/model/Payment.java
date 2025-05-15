package vms.model;

public class Payment {
    private String paymentId;
    private String customerId;
    private String appointmentId;
    private double amount;
    private String status; // e.g., "Paid", "Pending"

    public Payment() {}

    public Payment(String paymentId, String customerId, String appointmentId, double amount, String status) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.status = status;
    }

    // Getters and Setters
    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return paymentId + "," + customerId + "," + appointmentId + "," + amount + "," + status;
    }

    public static Payment fromString(String line) {
        String[] parts = line.split(",");
        return new Payment(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), parts[4]);
    }
}
