package com.example.lenovo.luanvantotnghiep.Model.Objects;

import java.util.List;

/**
 * Created by Lenovo on 6/22/2017.
 */

public class KhuyenMai {

    int maKhuyenMai;
    int maLoaiSP;
    String tenLoaiSP, tenKhuyenMai, hinhKhuyenMai, ngayBatDau, ngayKetThuc;
    List<SanPham> dsSanPhamSale;

    public int getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(int maKhuyenMai) {
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

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public List<SanPham> getDsSanPhamSale() {
        return dsSanPhamSale;
    }

    public void setDsSanPhamSale(List<SanPham> dsSanPhamSale) {
        this.dsSanPhamSale = dsSanPhamSale;
    }

    public int getMaLoaiSP() {
        return maLoaiSP;
    }

    public void setMaLoaiSP(int maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public String getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }
}
