package com.example.lenovo.luanvantotnghiep.Model.Models;

import android.util.Log;

import com.example.lenovo.luanvantotnghiep.Model.Objects.ChiTietKhuyenMai;
import com.example.lenovo.luanvantotnghiep.MyPublic.DownloadJSON;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.MyPublic.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Lenovo on 6/21/2017.
 */

public class ModelSanPhamPMoi {


    public List<SanPham> layDsSanPhamMoi(){
        List<SanPham> sanPhamList = new ArrayList<>();
        List<HashMap<String, String>> attrs = new ArrayList<>();

        String dataJSON = "";

        String path = Server.SERVER_NAME;

        HashMap<String, String> hsHam = new HashMap<>();
        hsHam.put("ham", "LayDsSanPhamMoi");

        attrs.add(hsHam);

        DownloadJSON downloadJSON = new DownloadJSON(path, attrs);
        downloadJSON.execute();

        try {
            dataJSON = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray jsonDsSanPhamMoi = jsonObject.getJSONArray("SANPHAMMOI");
            Log.d("dataSanPhamMoi",dataJSON.toString());
            int count = jsonDsSanPhamMoi.length();
            for (int i = 0; i < count; i++){
                SanPham sanPham = new SanPham();
                JSONObject object = jsonDsSanPhamMoi.getJSONObject(i);
                ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai();
                chiTietKhuyenMai.setPhanTramKM(object.getInt("PHANTRAMKM"));

                sanPham.setChiTietKhuyenMai(chiTietKhuyenMai);
                sanPham.setMaSanPham(object.getInt("MASANPHAM"));
                sanPham.setTenSanPham(object.getString("TENSANPHAM"));
                sanPham.setGiaSanPham(object.getInt("GIASANPHAM"));
                sanPham.setHinhLon(Server.SERVER + object.getString("HINHLON"));
                sanPhamList.add(sanPham);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sanPhamList;
    }
}
