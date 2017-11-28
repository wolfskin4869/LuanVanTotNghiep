package com.example.lenovo.luanvantotnghiep.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lenovo.luanvantotnghiep.Model.Objects.KhuyenMai;
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterKhuyenMai;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicKhuyenMai;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewKhuyenMai;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Lenovo on 6/19/2017.
 */

public class FragmentKhuyenMai extends Fragment implements IViewKhuyenMai{

    LinearLayout lnHinhKhuyenMai;
    RecyclerView rclDanhSachKhuyenMai;
    PresenterLogicKhuyenMai presenterLogicKhuyenMai;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chuongtrinhkhuyenmai,container, false);
        lnHinhKhuyenMai = (LinearLayout) view.findViewById(R.id.lnHinhKhuyenMai);
        rclDanhSachKhuyenMai = (RecyclerView) view.findViewById(R.id.rclDanhSachKhuyenMai);
        presenterLogicKhuyenMai = new PresenterLogicKhuyenMai(this);
        presenterLogicKhuyenMai.layDanhSachKhuyenMai();
        return view ;
    }

    @Override
    public void hienThiDanhSachKhuyenMai(List<KhuyenMai> khuyenMaiList) {

        int demhinh = khuyenMaiList.size();
        if(demhinh >5){
            demhinh = 5;
        }else{
            demhinh = khuyenMaiList.size();
        }

        lnHinhKhuyenMai.removeAllViews();
        for(int i = 0; i < demhinh; i++){
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
            layoutParams.setMargins(0,5,0,5);
            imageView.setLayoutParams(layoutParams);
            Picasso.with(getContext()).load(khuyenMaiList.get(i).getHinhKhuyenMai()).into(imageView);

            lnHinhKhuyenMai.addView(imageView);

        }
        AdapterKhuyenMai adapterKhuyenMai = new AdapterKhuyenMai(getContext(), khuyenMaiList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        rclDanhSachKhuyenMai.setLayoutManager(layoutManager);
        rclDanhSachKhuyenMai.setAdapter(adapterKhuyenMai);
        adapterKhuyenMai.notifyDataSetChanged();
    }
}
