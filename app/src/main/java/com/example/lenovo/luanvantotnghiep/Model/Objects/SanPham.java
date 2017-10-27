package com.example.lenovo.luanvantotnghiep.Model.Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 6/21/2017.
 */

public class SanPham {

    String maSanPham, maLoaiSanPham, maThuongHieu, tenSanPham, thongTinSP, hinhLon, hinhNho;
    Integer giaSanPham;
    int soLuongTon, luotMuaSP;
    List<ThongSoKyThuat> thongSoKyThuatList;

    byte[] hinhgiohang;

    public SanPham() {
    }

    public SanPham(String maSanPham, String maLoaiSanPham, String maThuongHieu, String tenSanPham, String thongTinSP, String hinhLon,
                   Integer giaSanPham, int soLuongTon, int luotMuaSP, String hinhNho, List<ThongSoKyThuat> thongSoKyThuatList) {
        this.maSanPham = maSanPham;
        this.maLoaiSanPham = maLoaiSanPham;
        this.maThuongHieu = maThuongHieu;
        this.tenSanPham = tenSanPham;
        this.thongTinSP = thongTinSP;
        this.hinhLon = hinhLon;
        this.giaSanPham = giaSanPham;
        this.soLuongTon = soLuongTon;
        this.luotMuaSP = luotMuaSP;
        this.hinhNho = hinhNho;
        this.thongSoKyThuatList = thongSoKyThuatList;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
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

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
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

    public byte[] getHinhgiohang() {
        return hinhgiohang;
    }

    public void setHinhgiohang(byte[] hinhgiohang) {
        this.hinhgiohang = hinhgiohang;
    }
}
