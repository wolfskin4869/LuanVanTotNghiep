package com.example.lenovo.luanvantotnghiep.Model.Models;

import com.example.lenovo.luanvantotnghiep.Model.Objects.ChiTietKhuyenMai;
import com.example.lenovo.luanvantotnghiep.Model.Objects.KhuyenMai;
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
 * Created by Lenovo on 11/7/2017.
 */

public class ModelKhuyenMai {

    public List<KhuyenMai> layDanhSachKhuyenMai(String tenHam, String tenMang){
        List<KhuyenMai> khuyenMaiList = new ArrayList<>();

        List<HashMap<String, String>> attrs = new ArrayList<>();
        String dataJSON = "";

        String path = Server.SERVER_NAME;

        HashMap<String, String> hsHam = new HashMap<>();
        hsHam.put("ham", tenHam);

        attrs.add(hsHam);

        DownloadJSON downloadJSON = new DownloadJSON(path, attrs);
        downloadJSON.execute();

        try {
            dataJSON = downloadJSON.get();

            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray jsonDanhSachKhuyenMai = jsonObject.getJSONArray(tenMang);
            int count = jsonDanhSachKhuyenMai.length();

            for (int i = 0; i < count; i++){
                KhuyenMai khuyenMai = new KhuyenMai();
                JSONObject object = jsonDanhSachKhuyenMai.getJSONObject(i);
                khuyenMai.setMaKhuyenMai(object.getInt("MAKHUYENMAI"));
                khuyenMai.setTenKhuyenMai(object.getString("TENKHUYENMAI"));
                khuyenMai.setTenLoaiSP(object.getString("TENLOAISP"));
                khuyenMai.setHinhKhuyenMai(Server.SERVER+object.getString("HINHKHUYENMAI"));

                List<SanPham> sanPhamList = new ArrayList<>();
                JSONArray arrayDSSanPham = object.getJSONArray("DANHSACHSANPHAM");
                int dem = arrayDSSanPham.length();
                for(int j = 0; j < dem; j++){
                    JSONObject objectSanPham = arrayDSSanPham.getJSONObject(j);
                    SanPham sanPham = new SanPham();
                    sanPham.setMaSanPham(objectSanPham.getInt("MASANPHAM"));
                    sanPham.setTenSanPham(objectSanPham.getString("TENSANPHAM"));
                    sanPham.setGiaSanPham(objectSanPham.getInt("GIASANPHAM"));
                    sanPham.setHinhLon(Server.SERVER + objectSanPham.getString("HINHLON"));
                    sanPham.setHinhNho(Server.SERVER + objectSanPham.getString("HINHNHO"));

                    ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai();
                    chiTietKhuyenMai.setPhanTramKM(objectSanPham.getInt("PHANTRAMKM"));

                    sanPham.setChiTietKhuyenMai(chiTietKhuyenMai);
                    sanPhamList.add(sanPham);
                }
                khuyenMai.setDsSanPhamSale(sanPhamList);
                khuyenMaiList.add(khuyenMai);

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return khuyenMaiList;
    }
}
