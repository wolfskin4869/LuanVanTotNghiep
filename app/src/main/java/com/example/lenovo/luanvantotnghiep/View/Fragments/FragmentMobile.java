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
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicMobile;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewMobile;

import java.util.List;

public class FragmentMobile extends Fragment implements IViewMobile{

    AdapterSanPham mobileAdapter;
    RecyclerView recyclerMobile;
    PresenterLogicMobile presenterLogicMobile;
    List<SanPham> sanPhamArray;

    public FragmentMobile() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mobile_fragment,container, false);
        recyclerMobile = (RecyclerView) view.findViewById(R.id.recyclerMobile);
        presenterLogicMobile = new PresenterLogicMobile(this);
        presenterLogicMobile.layDanhSachMobile();
        return  view ;

    }

    @Override
    public void hienThiDanhSachMobile(List<SanPham> sanPhams) {
        sanPhamArray = sanPhams;
        mobileAdapter = new AdapterSanPham(getActivity(),sanPhamArray,R.layout.custom_recyclerview_mobile);
        recyclerMobile.setHasFixedSize(true);
        recyclerMobile.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerMobile.setAdapter(mobileAdapter);
        mobileAdapter.notifyDataSetChanged();
    }
}
