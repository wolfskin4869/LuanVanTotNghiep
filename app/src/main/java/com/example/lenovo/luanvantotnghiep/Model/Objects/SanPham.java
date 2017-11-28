package com.example.lenovo.luanvantotnghiep.Model.Objects;

import java.util.List;

/**
 * Created by Lenovo on 6/21/2017.
 */

public class SanPham {

    String maLoaiSanPham, maThuongHieu, tenSanPham, thongTinSP, hinhLon, hinhNho;
    Integer giaSanPham;
    int maSanPham, soLuongDat, luotMuaSP, soLuongTon;
    List<ThongSoKyThuat> thongSoKyThuatList;
    ChiTietKhuyenMai chiTietKhuyenMai;
    byte[] hinhSQLite;

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getMaLoaiSanPham() {
        return maLoaiSanPham;
    }

    public void setMaLoaiSanPham(String maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public String getMaThuongHieu() {
        return maThuongHieu;
    }

    public void setMaThuongHieu(String maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getThongTinSP() {
        return thongTinSP;
    }

    public void setThongTinSP(String thongTinSP) {
        this.thongTinSP = thongTinSP;
    }

    public String getHinhLon() {
        return hinhLon;
    }

    public void setHinhLon(String hinhLon) {
        this.hinhLon = hinhLon;
    }

    public Integer getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(Integer giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public int getSoLuongDat() {
        return soLuongDat;
    }

    public void setSoLuongDat(int soLuongDat) {
        this.soLuongDat = soLuongDat;
    }

    public int getLuotMuaSP() {
        return luotMuaSP;
    }

    public void setLuotMuaSP(int luotMuaSP) {
        this.luotMuaSP = luotMuaSP;
    }

    public String getHinhNho() {
        return hinhNho;
    }

    public void setHinhNho(String hinhNho) {
        this.hinhNho = hinhNho;
    }

    public List<ThongSoKyThuat> getThongSoKyThuatList() {
        return thongSoKyThuatList;
    }

    public void setThongSoKyThuatList(List<ThongSoKyThuat> thongSoKyThuatList) {
        this.thongSoKyThuatList = thongSoKyThuatList;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public ChiTietKhuyenMai getChiTietKhuyenMai() {
        return chiTietKhuyenMai;
    }

    public void setChiTietKhuyenMai(ChiTietKhuyenMai chiTietKhuyenMai) {
        this.chiTietKhuyenMai = chiTietKhuyenMai;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public byte[] getHinhSQLite() {
        return hinhSQLite;
    }

    public void setHinhSQLite(byte[] hinhSQLite) {
        this.hinhSQLite = hinhSQLite;
    }
}
