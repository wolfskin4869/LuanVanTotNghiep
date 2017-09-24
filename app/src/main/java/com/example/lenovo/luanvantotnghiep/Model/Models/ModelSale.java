package com.example.lenovo.luanvantotnghiep.Model.Models;

import com.example.lenovo.luanvantotnghiep.MyPublic.DownloadJSON;
import com.example.lenovo.luanvantotnghiep.Model.Objects.KhuyenMai;
import com.example.lenovo.luanvantotnghiep.MyPublic.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Lenovo on 6/22/2017.
 */

public class ModelSale {

    public List<KhuyenMai> layDanhSachSale(){

        List<KhuyenMai> khuyenMais = new ArrayList<>();
        String dataJSON = "";

        List<HashMap<String, String>> attrs = new ArrayList<>();
        String path = Server.SERVER_NAME;
        HashMap<String, String> hsHam = new HashMap<>();
        hsHam.put("ham", "LayDanhSachSale");
        attrs.add(hsHam);

        DownloadJSON downloadJSON = new DownloadJSON(path, attrs);
        downloadJSON.execute();

        try {
            dataJSON = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray jsonDsKhuyenMai = jsonObject.getJSONArray("SALE");
            int count = jsonDsKhuyenMai.length();
            for (int i = 0; i < count; i++){
                KhuyenMai khuyenMai = new KhuyenMai();
                JSONObject object = jsonDsKhuyenMai.getJSONObject(i);
                khuyenMai.setMaKhuyenMai(object.getString("MAKHUYENMAI"));
                khuyenMai.setHinhKhuyenMai(object.getString("HINHKHUYENMAI"));
                khuyenMais.add(khuyenMai);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return khuyenMais;
    }
}
