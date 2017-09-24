package com.example.lenovo.luanvantotnghiep.Model.Models;

import android.util.Log;

import com.example.lenovo.luanvantotnghiep.MyPublic.DownloadJSON;
import com.example.lenovo.luanvantotnghiep.Model.Objects.NguoiSuDung;
import com.example.lenovo.luanvantotnghiep.MyPublic.Server;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Lenovo on 6/20/2017.
 */

public class ModelDangKy {

    public Boolean dangKyThanhVien(NguoiSuDung nsd){
        String path = Server.SERVER_NAME;
        Boolean kiemtra = false;
        List<HashMap<String,String>> atts = new ArrayList<>();

        HashMap<String,String> hsmHam = new HashMap<>();
        hsmHam.put("ham","DangKyThanhVien");

        HashMap<String,String> hsmTenNSD = new HashMap<>();
        hsmTenNSD.put("tennsd",nsd.getTenNSD());

        HashMap<String,String> hsmTenDN = new HashMap<>();
        hsmTenDN.put("tendangnhap",nsd.getTenDangNhap());

        HashMap<String,String> hsmMatKhau = new HashMap<>();
        hsmMatKhau.put("matkhau",nsd.getMatKhau());

        HashMap<String,String> hsmMaLoaiNSD = new HashMap<>();
        hsmMaLoaiNSD.put("maloainsd",nsd.getMaLoaiNSD());

        atts.add(hsmHam);
        atts.add(hsmTenNSD);
        atts.add(hsmTenDN);
        atts.add(hsmMatKhau);
        atts.add(hsmMaLoaiNSD);

        DownloadJSON downloadJSON = new DownloadJSON(path,atts);
        downloadJSON.execute();

        try {
            String dulieuJSON = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dulieuJSON);
            String ketqua = jsonObject.getString("ketqua");
            Log.d("kiemtra",ketqua);
            kiemtra = ketqua.equals("true");
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
