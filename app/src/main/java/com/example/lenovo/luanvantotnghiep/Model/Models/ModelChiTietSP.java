package com.example.lenovo.luanvantotnghiep.Model.Models;

import android.util.Log;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Model.Objects.ThongSoKyThuat;
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
 * Created by Lenovo on 8/29/2017.
 */

public class ModelChiTietSP {

    public SanPham LayChiTietSanPham(String maSP, String tenHam, String tenMang){

        SanPham sanPham = new SanPham();

        List<ThongSoKyThuat> tsktList = new ArrayList<>();

        List<HashMap<String, String>> attrs = new ArrayList<>();
        String dataJSON = "";

        String path = Server.SERVER_NAME;

        HashMap<String, String> hsHam = new HashMap<>();
        hsHam.put("ham", tenHam);

        HashMap<String, String> hsMaSP = new HashMap<>();
        hsMaSP.put("MASANPHAM", String.valueOf(maSP));

        attrs.add(hsHam);
        attrs.add(hsMaSP);

        DownloadJSON downloadJSON = new DownloadJSON(path, attrs);
        downloadJSON.execute();

        try {
            dataJSON = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dataJSON);
            Log.d("MEN", dataJSON.toString());
            JSONArray jsonChiTietSanPham = jsonObject.getJSONArray(tenMang);
            int count = jsonChiTietSanPham.length();
            for (int i = 0; i < count; i++){

                JSONObject object = jsonChiTietSanPham.getJSONObject(i);

                sanPham.setMaSanPham(object.getString("MASANPHAM"));
                sanPham.setTenSanPham(object.getString("TENSANPHAM"));
                sanPham.setGiaSanPham(object.getInt("GIASANPHAM"));
                sanPham.setThongTinSP(object.getString("THONGTINSP"));
                sanPham.setHinhNho(object.getString("HINHSANPHAM"));

                JSONArray jsonArrayTSKT = object.getJSONArray("THONGSOKYTHUAT");
                for (int j = 0; j < jsonArrayTSKT.length(); j++){
                    JSONObject jObjTSKT = jsonArrayTSKT.getJSONObject(j);

                    for (int k = 0; k < jObjTSKT.names().length(); k++){
                        String tenThongSo = jObjTSKT.names().getString(k);

                        ThongSoKyThuat thongSoKyThuat = new ThongSoKyThuat();
                        thongSoKyThuat.setTenThongSo(tenThongSo);
                        thongSoKyThuat.setGiaTriThongSo(jObjTSKT.getString(tenThongSo));

                        tsktList.add(thongSoKyThuat);
                    }
                }
                sanPham.setThongSoKyThuatList(tsktList);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sanPham;
    }
}
