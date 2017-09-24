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
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterTablet;
import com.example.lenovo.luanvantotnghiep.Presenter.Logic_Presenters.PresenterTablet;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.Interface_Views.IViewTablet;

import java.util.List;

/**
 * Created by Lenovo on 6/19/2017.
 */

public class TabletFragment extends Fragment implements IViewTablet {

    AdapterTablet adapterTablet;
    RecyclerView recyclerTablet;
    PresenterTablet presenterTablet;
    List<SanPham> sanPhamArray;

    public TabletFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tablet_fragment,container, false);
        recyclerTablet = (RecyclerView) view.findViewById(R.id.recyclerTablet);
        presenterTablet = new PresenterTablet(this);
        presenterTablet.layDanhSachTablet();
        return  view ;

    }

    @Override
    public void hienThiDanhSachTablet(List<SanPham> sanPhams) {
        sanPhamArray = sanPhams;
        adapterTablet = new AdapterTablet(getActivity(),sanPhamArray);
        recyclerTablet.setHasFixedSize(true);
        recyclerTablet.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerTablet.setAdapter(adapterTablet);
        adapterTablet.notifyDataSetChanged();
    }
}
