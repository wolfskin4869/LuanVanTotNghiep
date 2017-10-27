package com.example.lenovo.luanvantotnghiep.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.luanvantotnghiep.Model.Objects.KhuyenMai;
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterSale;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicSale;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewSale;

import java.util.List;

/**
 * Created by Lenovo on 6/19/2017.
 */

public class FragmentSale extends Fragment implements IViewSale{

    AdapterSale adapterSale;
    RecyclerView recyclerSale;
    PresenterLogicSale presenterLogicSale;
    List<KhuyenMai> khuyenMaiList;

    public FragmentSale() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sale_fragment,container, false);
        recyclerSale = (RecyclerView) view.findViewById(R.id.recyclerSale);
        presenterLogicSale = new PresenterLogicSale(this);
        presenterLogicSale.layDanhSachSale();
        return view ;
    }

    @Override
    public void hienThiDanhSachSale(List<KhuyenMai> khuyenMais) {
        khuyenMaiList = khuyenMais;
        adapterSale = new AdapterSale(getActivity(), khuyenMaiList);
        recyclerSale.setHasFixedSize(true);
        recyclerSale.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerSale.setAdapter(adapterSale);
        adapterSale.notifyDataSetChanged();
    }
}
