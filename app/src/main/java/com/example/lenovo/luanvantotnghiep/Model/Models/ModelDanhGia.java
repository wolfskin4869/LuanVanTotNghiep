package com.example.lenovo.luanvantotnghiep.Model.Models;

import android.util.Log;

import com.example.lenovo.luanvantotnghiep.Model.Objects.DanhGia;
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
 * Created by Lenovo on 10/3/2017.
 */

public class ModelDanhGia {

    public List<DanhGia> layDanhSachDanhGia(int maSP, int limit){
        List<DanhGia> danhGiaList = new ArrayList<>();
        List<HashMap<String, String>> attrs = new ArrayList<>();
        String dataJSON = "";

        String path = Server.SERVER_NAME;

        HashMap<String, String> hsHam = new HashMap<>();
        hsHam.put("ham", "LayDanhSachDanhGiaTheoMaSP");            // hsHam.put("ham", "LayDanhSachSanPhamTheoThuongHieu");

        HashMap<String, String> hsmMaSP = new HashMap<>();
        hsmMaSP.put("MASANPHAM", String.valueOf(maSP));

        HashMap<String, String> hsmLimit = new HashMap<>();
        hsmLimit.put("LIMIT", String.valueOf(limit));

        attrs.add(hsHam);
        attrs.add(hsmMaSP);
        attrs.add(hsmLimit);


        DownloadJSON downloadJSON = new DownloadJSON(path,attrs);
        downloadJSON.execute();

        try {
            dataJSON = downloadJSON.get();

            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray jsonArrayDSDanhGia = jsonObject.getJSONArray("DANHSACHDANHGIA");
            int count = jsonArrayDSDanhGia.length();

            for (int i = 0; i < count; i++){
                DanhGia danhGia = new DanhGia();
                JSONObject object = jsonArrayDSDanhGia.getJSONObject(i);

                danhGia.setTenThietBi(object.getString("TENTHIETBI"));
                danhGia.setMaSP(object.getString("MASANPHAM"));
                danhGia.setTieuDe(object.getString("TIEUDE"));
                danhGia.setNoiDung(object.getString("NOIDUNG"));
                danhGia.setSoSao(Float.parseFloat(object.getString("SOSAO")));
                danhGia.setNgayDanhGia(object.getString("NGAYDANHGIA"));
                danhGiaList.add(danhGia);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return danhGiaList;
    }

    public boolean themDanhGia(DanhGia danhGia){

        String path = Server.SERVER_NAME;
        Boolean kiemtra = false;
        List<HashMap<String,String>> atts = new ArrayList<>();

        HashMap<String,String> hsmHam = new HashMap<>();
        hsmHam.put("ham","ThemDanhGia");

        HashMap<String,String> hsmMaDanhGia = new HashMap<>();
        hsmMaDanhGia.put("MADANHGIA",danhGia.getMaDanhGia());

        HashMap<String,String> hsmMaSanPham = new HashMap<>();
        hsmMaSanPham.put("MASANPHAM",danhGia.getMaSP());

        HashMap<String,String> hsmTenThietBi= new HashMap<>();
        hsmTenThietBi.put("TENTHIETBI",danhGia.getTenThietBi());

        HashMap<String,String> hsmTieuDe = new HashMap<>();
        hsmTieuDe.put("TIEUDE",danhGia.getTieuDe());

        HashMap<String,String> hsmNoiDung = new HashMap<>();
        hsmNoiDung.put("NOIDUNG",danhGia.getNoiDung());

        HashMap<String,String> hsmSoSao = new HashMap<>();
        hsmSoSao.put("SOSAO",String.valueOf(danhGia.getSoSao()));

        HashMap<String,String> hsmNgayDanhGia = new HashMap<>();
        hsmNgayDanhGia.put("NGAYDANHGIA",danhGia.getNgayDanhGia());

        atts.add(hsmHam);
        atts.add(hsmMaDanhGia);
        atts.add(hsmMaSanPham);
        atts.add(hsmTenThietBi);
        atts.add(hsmNgayDanhGia);
        atts.add(hsmNoiDung);
        atts.add(hsmTieuDe);
        atts.add(hsmSoSao);

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
