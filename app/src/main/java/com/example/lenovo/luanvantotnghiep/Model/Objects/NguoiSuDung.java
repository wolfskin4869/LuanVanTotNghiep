package com.example.lenovo.luanvantotnghiep.Model.Objects;

/**
 * Created by Lenovo on 6/20/2017.
 */

public class NguoiSuDung {
    String maNSD, tenNSD, tenDangNhap, matKhau, diaChi, ngaySinh, soDienThoai, eMail, maLoaiNSD;
    int gioiTinh;

    public NguoiSuDung() {
    }

    public NguoiSuDung(String maNSD, String tenNSD, String tenDangNhap, String matKhau, String diaChi,
                       String ngaySinh, String soDienThoai, String eMail, int gioiTinh, String maLoaiNSD) {
        this.maNSD = maNSD;
        this.tenNSD = tenNSD;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.eMail = eMail;
        this.gioiTinh = gioiTinh;
        this.maLoaiNSD = maLoaiNSD;
    }

    public String getMaNSD() {
        return maNSD;
    }

    public void setMaNSD(String maNSD) {
        this.maNSD = maNSD;
    }

    public String getTenNSD() {
        return tenNSD;
    }

    public void setTenNSD(String tenNSD) {
        this.tenNSD = tenNSD;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMaLoaiNSD() {
        return maLoaiNSD;
    }

    public void setMaLoaiNSD(String maLoaiNSD) {
        this.maLoaiNSD = maLoaiNSD;
    }
}
