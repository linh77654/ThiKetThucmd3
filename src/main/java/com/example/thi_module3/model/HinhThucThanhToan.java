package com.example.thi_module3.model;

public class HinhThucThanhToan {
    private int id;
    private String paymentName;

    public HinhThucThanhToan() {
    }

    public HinhThucThanhToan(int id, String paymentName) {
        this.id = id;
        this.paymentName = paymentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
}
