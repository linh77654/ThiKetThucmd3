package com.example.thi_module3.model;

import java.util.Date;

public class PhongTro {
    private int id;
    private String tenPhongTro;
    private String soDienThoai;
    private Date ngayBatDau;
    private String hinhThucThanhToan;
    private String ghiChu;

    public PhongTro(int id, String tenPhongTro, String soDienThoai, Date ngayBatDau, String hinhThucThanhToan, String ghiChu) {
        this.id = id;
        this.tenPhongTro = tenPhongTro;
        this.soDienThoai = soDienThoai;
        this.ngayBatDau = ngayBatDau;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ghiChu = ghiChu;
    }

    public PhongTro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhongTro() {
        return tenPhongTro;
    }

    public void setTenPhongTro(String tenPhongTro) {
        this.tenPhongTro = tenPhongTro;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}