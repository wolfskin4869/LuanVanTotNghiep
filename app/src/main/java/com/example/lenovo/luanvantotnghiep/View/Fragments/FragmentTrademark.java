package com.example.lenovo.luanvantotnghiep.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.luanvantotnghiep.Model.Objects.ThuongHieu;
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterTrademark;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicTrademark;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewTrademark;

import java.util.List;

/**
 * Created by Lenovo on 6/19/2017.
 */

public class FragmentTrademark extends Fragment implements IViewTrademark{

    AdapterTrademark adapterTrademark;
    RecyclerView recyclerTrademark;
    PresenterLogicTrademark presenterLogicTrademark;
    List<ThuongHieu> thuongHieuList;

    public FragmentTrademark() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trademark,container, false);
        recyclerTrademark = (RecyclerView) view.findViewById(R.id.recyclerTrademark);
        presenterLogicTrademark = new PresenterLogicTrademark(this);
        presenterLogicTrademark.layDanhSachTrademark();
        return view ;
    }

    @Override
    public void hienThiDanhSachTrademark(List<ThuongHieu> thuongHieus) {
        thuongHieuList = thuongHieus;
        adapterTrademark = new AdapterTrademark(getActivity(), thuongHieuList);
        recyclerTrademark.setHasFixedSize(true);
        recyclerTrademark.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerTrademark.setAdapter(adapterTrademark);
        adapterTrademark.notifyDataSetChanged();
    }
}
