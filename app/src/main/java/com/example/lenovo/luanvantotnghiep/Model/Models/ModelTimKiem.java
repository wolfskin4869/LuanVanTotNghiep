package com.example.lenovo.luanvantotnghiep.Model.Models;

import com.example.lenovo.luanvantotnghiep.Model.Objects.ChiTietKhuyenMai;
import com.example.lenovo.luanvantotnghiep.Model.Objects.DanhGia;
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
 * Created by Lenovo on 11/16/2017.
 */

public class ModelTimKiem {
    public List<SanPham> layDanhSachSanPhamTimKiem(String tenSP,int limit){

        List<SanPham> sanPhamList = new ArrayList<>();

        List<HashMap<String, String>> attrs = new ArrayList<>();
        String dataJSON = "";

        String path = Server.SERVER_NAME;

        HashMap<String, String> hsHam = new HashMap<>();
        hsHam.put("ham", "TimKiemSanPhamTheoTen");            // hsHam.put("ham", "LayDanhSachSanPhamTheoThuongHieu");

        HashMap<String, String> hsmTenSP = new HashMap<>();
        hsmTenSP.put("TENSANPHAM", tenSP);

        HashMap<String, String> hsmLimit = new HashMap<>();
        hsmLimit.put("LIMIT", String.valueOf(limit));

        attrs.add(hsHam);
        attrs.add(hsmTenSP);
        attrs.add(hsmLimit);


        DownloadJSON downloadJSON = new DownloadJSON(path,attrs);
        downloadJSON.execute();

        try {
            dataJSON = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray jsonArrayDSSPTimKiem = jsonObject.getJSONArray("TIMKIEMSANPHAM");
            int count = jsonArrayDSSPTimKiem.length();

            for (int i = 0; i < count; i++){
                SanPham sanPham = new SanPham();
                JSONObject object = jsonArrayDSSPTimKiem.getJSONObject(i);
                ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai();
                sanPham.setMaSanPham(object.getInt("MASANPHAM"));
                sanPham.setTenSanPham(object.getString("TENSANPHAM"));
                sanPham.setGiaSanPham(object.getInt("GIASANPHAM"));
                sanPham.setHinhLon(Server.SERVER+object.getString("HINHLON"));
                sanPham.setHinhNho(Server.SERVER+object.getString("HINHNHO"));
                chiTietKhuyenMai.setPhanTramKM(object.getInt("PHANTRAMKM"));
                sanPham.setChiTietKhuyenMai(chiTietKhuyenMai);
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
