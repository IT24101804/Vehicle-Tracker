package vms.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vms.model.Payment;
import vms.util.FileUtil;

@Service
public class PaymentService {
    private static final String FILE_NAME = "files/payments.txt";

    public void addPayment(Payment payment) throws IOException {
        FileUtil.appendLine(FILE_NAME, payment.toString());
    }

    public List<Payment> getPaymentsByCustomer(String customerId) throws IOException {
        List<Payment> result = new ArrayList<>();
        for (String line : FileUtil.readLines(FILE_NAME)) {
            Payment p = Payment.fromString(line);
            if (p.getCustomerId().equals(customerId)) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Payment> getAllPayments() throws IOException {
        List<Payment> result = new ArrayList<>();
        for (String line : FileUtil.readLines(FILE_NAME)) {
            result.add(Payment.fromString(line));
        }
        return result;
    }

    public void updatePayment(Payment updated) throws IOException {
        List<String> updatedLines = new ArrayList<>();
        for (String line : FileUtil.readLines(FILE_NAME)) {
            Payment p = Payment.fromString(line);
            if (p.getPaymentId().equals(updated.getPaymentId())) {
                updatedLines.add(updated.toString());
            } else {
                updatedLines.add(line);
            }
        }
        FileUtil.writeLines(FILE_NAME, updatedLines);
    }

    public void deletePayment(String paymentId) throws IOException {
        List<String> updatedLines = new ArrayList<>();
        for (String line : FileUtil.readLines(FILE_NAME)) {
            Payment p = Payment.fromString(line);
            if (!p.getPaymentId().equals(paymentId)) {
                updatedLines.add(line);
            }
        }
        FileUtil.writeLines(FILE_NAME, updatedLines);
    }
}
