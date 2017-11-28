package com.example.lenovo.luanvantotnghiep.Model.Models;

import android.util.Log;

import com.example.lenovo.luanvantotnghiep.Model.Objects.ChiTietHoaDon;
import com.example.lenovo.luanvantotnghiep.Model.Objects.ChiTietKhuyenMai;
import com.example.lenovo.luanvantotnghiep.Model.Objects.HoaDon;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.MyPublic.DownloadJSON;
import com.example.lenovo.luanvantotnghiep.MyPublic.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Lenovo on 11/6/2017.
 */

public class ModelThanhToan {

    public boolean themHoaDon(HoaDon hoaDon){

        String path = Server.SERVER_NAME;
        Boolean kiemtra = false;
        List<HashMap<String,String>> atts = new ArrayList<>();

        HashMap<String,String> hsmHam = new HashMap<>();
        hsmHam.put("ham","ThemHoaDon");

        List<ChiTietHoaDon> chiTietHoaDonList = hoaDon.getChiTietHoaDonList();

        String chuoijson = "{\"DANHSACHSANPHAM\" :[ ";
        for (int i=0; i<chiTietHoaDonList.size();i++){
            chuoijson += "{";
            chuoijson += "\"MASANPHAM\" : \"" + chiTietHoaDonList.get(i).getMaSanPham() + "\", ";
            chuoijson += "\"SOLUONGDAT\" : \"" + chiTietHoaDonList.get(i).getSoLuongDat()+ "\"";

            if(i==chiTietHoaDonList.size() -1 ){
                chuoijson += "}";
            }else{
                chuoijson += "}, ";
            }

        }

        chuoijson += "]}";

        Log.d("chuoiJSON",chuoijson);

        HashMap<String,String> hsmDanhSachSanPham = new HashMap<>();
        hsmDanhSachSanPham.put("DANHSACHSANPHAM", chuoijson);

        HashMap<String,String> hsmTenNguoiNhan= new HashMap<>();
        hsmTenNguoiNhan.put("TENNGUOINHAN",hoaDon.getTenNguoiNhan());

        HashMap<String,String> hsmSoDienThoai = new HashMap<>();
        hsmSoDienThoai.put("SODIENTHOAI",hoaDon.getSoDienThoai());

        HashMap<String,String> hsmDiaChiGiao = new HashMap<>();
        hsmDiaChiGiao.put("DIACHIGIAO",hoaDon.getDiaChiGiao());

        HashMap<String,String> hsmChuyenKhoan = new HashMap<>();
        hsmChuyenKhoan.put("HINHTHUCTHANHTOAN", hoaDon.getHinhThucThanhToan());

        atts.add(hsmHam);
        atts.add(hsmDanhSachSanPham);
        atts.add(hsmTenNguoiNhan);
        atts.add(hsmSoDienThoai);
        atts.add(hsmDiaChiGiao);
        atts.add(hsmChuyenKhoan);

        DownloadJSON downloadJSON = new DownloadJSON(path,atts);
        downloadJSON.execute();

        try {
            String dulieuJSON = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dulieuJSON);
            String ketqua = jsonObject.getString("ketqua");
            Log.d("duLieuThanhToan",dulieuJSON.toString());
            if(ketqua.equals("true")){
                kiemtra = true;
            }else{
                kiemtra = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return kiemtra;
    }
}
