package com.example.lenovo.luanvantotnghiep.Model.Objects;

/**
 * Created by Lenovo on 6/22/2017.
 */

public class KhuyenMai {

    String maKhuyenMai, tenKhuyenMai, hinhKhuyenMai, ngayBatDauKM, ngayKetThucKM;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, String hinhKhuyenMai, String ngayBatDauKM, String ngayKetThucKM) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.hinhKhuyenMai = hinhKhuyenMai;
        this.ngayBatDauKM = ngayBatDauKM;
        this.ngayKetThucKM = ngayKetThucKM;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public String getHinhKhuyenMai() {
        return hinhKhuyenMai;
    }

    public void setHinhKhuyenMai(String hinhKhuyenMai) {
        this.hinhKhuyenMai = hinhKhuyenMai;
    }

    public String getNgayBatDauKM() {
        return ngayBatDauKM;
    }

    public void setNgayBatDauKM(String ngayBatDauKM) {
        this.ngayBatDauKM = ngayBatDauKM;
    }

    public String getNgayKetThucKM() {
        return ngayKetThucKM;
    }

    public void setNgayKetThucKM(String ngayKetThucKM) {
        this.ngayKetThucKM = ngayKetThucKM;
    }
}
