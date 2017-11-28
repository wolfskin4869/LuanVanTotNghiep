package com.example.lenovo.luanvantotnghiep.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterSanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicTablet;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewTablet;

import java.util.List;

/**
 * Created by Lenovo on 6/19/2017.
 */

public class FragmentTablet extends Fragment implements IViewTablet {

    AdapterSanPham adapterTablet;
    RecyclerView recyclerTablet;
    PresenterLogicTablet presenterLogicTablet;
    List<SanPham> sanPhamArray;

    public FragmentTablet() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tablet,container, false);
        recyclerTablet = (RecyclerView) view.findViewById(R.id.recyclerTablet);
        presenterLogicTablet = new PresenterLogicTablet(this);
        presenterLogicTablet.layDanhSachTablet();
        return  view ;

    }

    @Override
    public void hienThiDanhSachTablet(List<SanPham> sanPhams) {
        sanPhamArray = sanPhams;
        adapterTablet = new AdapterSanPham(getContext(),sanPhamArray,R.layout.custom_recyclerview_mobile);
        recyclerTablet.setHasFixedSize(true);
        recyclerTablet.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerTablet.setAdapter(adapterTablet);
        adapterTablet.notifyDataSetChanged();
    }
}
