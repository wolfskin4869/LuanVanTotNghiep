package com.example.lenovo.luanvantotnghiep.Model.Models;

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
 * Created by Lenovo on 6/26/2017.
 */

public class ModelSPTheoThuongHieu {

    public List<SanPham> layDSSanPhamTheoThuongHieu(int maThuongHieu, String tenmang, String tenham, int limit){
        List<SanPham> sanPhamList = new ArrayList<>();
        List<HashMap<String, String>> attrs = new ArrayList<>();
        String dataJSON = "";

        String path = Server.SERVER_NAME;

        HashMap<String, String> hsHam = new HashMap<>();
        hsHam.put("ham", tenham);            // hsHam.put("ham", "LayDanhSachSanPhamTheoThuongHieu");

        HashMap<String, String> hsMaThuongHieu = new HashMap<>();
        hsMaThuongHieu.put("MATHUONGHIEU", String.valueOf(maThuongHieu));

        HashMap<String, String> hsLimit = new HashMap<>();
        hsLimit.put("LIMIT", String.valueOf(limit));

        attrs.add(hsHam);
        attrs.add(hsMaThuongHieu);
        attrs.add(hsLimit);


        DownloadJSON downloadJSON = new DownloadJSON(path,attrs);
        downloadJSON.execute();

        try {
            dataJSON = downloadJSON.get();

            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray jsonArrayDSSanPham = jsonObject.getJSONArray(tenmang);
            int count = jsonArrayDSSanPham.length();

            for (int i = 0; i < count; i++){
                SanPham sanPham = new SanPham();
                JSONObject object = jsonArrayDSSanPham.getJSONObject(i);

                sanPham.setMaSanPham(object.getInt("MASANPHAM"));
                sanPham.setTenSanPham(object.getString("TENSANPHAM"));
                sanPham.setGiaSanPham(object.getInt("GIASANPHAM"));
                sanPham.setHinhLon(Server.SERVER+object.getString("HINHSANPHAM"));

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
