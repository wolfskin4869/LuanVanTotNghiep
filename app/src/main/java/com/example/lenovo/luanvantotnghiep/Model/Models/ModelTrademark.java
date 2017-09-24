package com.example.lenovo.luanvantotnghiep.Model.Models;

import com.example.lenovo.luanvantotnghiep.MyPublic.DownloadJSON;
import com.example.lenovo.luanvantotnghiep.Model.Objects.ThuongHieu;
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

public class ModelTrademark {

    public List<ThuongHieu> layDanhSachTrademark(){

        List<ThuongHieu> thuongHieus = new ArrayList<>();
        List<HashMap<String, String>> attrs = new ArrayList<>();
        String dataJSON = "";

        String path = Server.SERVER_NAME;

        HashMap<String, String> hsHam = new HashMap<>();
        hsHam.put("ham", "LayDanhSachTrademark");

        attrs.add(hsHam);

        DownloadJSON downloadJSON = new DownloadJSON(path, attrs);
        downloadJSON.execute();

        try {
            dataJSON = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray jsonDsThuongHieu = jsonObject.getJSONArray("TRADEMARK");
            int count = jsonDsThuongHieu.length();
            for (int i = 0; i < count; i++){
                ThuongHieu thuongHieu = new ThuongHieu();
                JSONObject object = jsonDsThuongHieu.getJSONObject(i);
                thuongHieu.setMaThuongHieu(object.getString("MATHUONGHIEU"));
                thuongHieu.setTenThuongHieu(object.getString("TENTHUONGHIEU"));
                thuongHieu.setHinhThuongHieu(object.getString("HINHTHUONGHIEU"));
                thuongHieus.add(thuongHieu);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return thuongHieus;
    }
}
