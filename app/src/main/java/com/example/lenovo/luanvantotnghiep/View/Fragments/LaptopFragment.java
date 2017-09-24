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
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterLaptop;
import com.example.lenovo.luanvantotnghiep.Presenter.Logic_Presenters.PresenterLaptop;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.Interface_Views.IViewLaptop;

import java.util.List;

public class LaptopFragment extends Fragment implements IViewLaptop {

    AdapterLaptop adapterLaptop;
    RecyclerView recyclerLaptop;
    PresenterLaptop presenterLaptop;
    List<SanPham> sanPhamArray;

    public LaptopFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_laptop_fragment,container, false);
        recyclerLaptop = (RecyclerView) view.findViewById(R.id.recyclerLaptop);
        presenterLaptop = new PresenterLaptop(this);
        presenterLaptop.layDanhSachLaptop();
        return  view ;

    }

    @Override
    public void hienThiDanhSachLaptop(List<SanPham> sanPhams) {
        sanPhamArray = sanPhams;
        adapterLaptop = new AdapterLaptop(getActivity(),sanPhamArray);
        recyclerLaptop.setHasFixedSize(true);
        recyclerLaptop.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerLaptop.setAdapter(adapterLaptop);
        adapterLaptop.notifyDataSetChanged();
    }
}
