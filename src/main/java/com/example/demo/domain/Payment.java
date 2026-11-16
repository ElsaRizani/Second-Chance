package com.example.demo.domain;

import java.time.LocalDateTime;

public class Payment {
    private Long id;
    private Long donationId; 
    private String transactionId; //(Stripe/PayPal)
    private String paymentMethod; //Psh"Credit Card", "PayPal"
    private String status; 
    private LocalDateTime paymentDate;

    public Payment(Long id, Long donationId, String transactionId, String paymentMethod) {
        this.id = id;
        this.donationId = donationId;
        this.transactionId = transactionId;
        this.paymentMethod = paymentMethod;
        this.status = "Pending";
        this.paymentDate = LocalDateTime.now();
    }

    public void markAsSuccessful() {
        if (!this.status.equals("Pending")) {
            throw new IllegalStateException("Pagesa nuk mund të përditësohet. Statusi aktual është: " + this.status);
        }
        this.status = "Successful";
    }

    public void markAsFailed() {
        if (!this.status.equals("Pending")) {
            throw new IllegalStateException("Pagesa nuk mund të shënohet si e dështuar.");
        }
        this.status = "Failed";
    }

    public Long getId() { return id; }
    public Long getDonationId() { return donationId; }
    public String getTransactionId() { return transactionId; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getStatus() { return status; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
}