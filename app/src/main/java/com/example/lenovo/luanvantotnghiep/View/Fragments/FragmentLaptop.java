package com.example.lenovo.luanvantotnghiep.View.Fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterSanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicLaptop;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewLaptop;

import java.util.List;

public class FragmentLaptop extends Fragment implements IViewLaptop {

    AdapterSanPham adapterLaptop;
    RecyclerView recyclerLaptop;
    PresenterLogicLaptop presenterLogicLaptop;
    List<SanPham> sanPhamArray;

    public FragmentLaptop() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_laptop_fragment,container, false);
        recyclerLaptop = (RecyclerView) view.findViewById(R.id.recyclerLaptop);
        presenterLogicLaptop = new PresenterLogicLaptop(this);
        presenterLogicLaptop.layDanhSachLaptop();
        return  view ;

    }

    @Override
    public void hienThiDanhSachLaptop(List<SanPham> sanPhams) {
        sanPhamArray = sanPhams;
        adapterLaptop = new AdapterSanPham(getActivity(),sanPhamArray,R.layout.custom_recyclerview_laptop);
        recyclerLaptop.setHasFixedSize(true);
        recyclerLaptop.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerLaptop.setAdapter(adapterLaptop);
        adapterLaptop.notifyDataSetChanged();
    }
}
