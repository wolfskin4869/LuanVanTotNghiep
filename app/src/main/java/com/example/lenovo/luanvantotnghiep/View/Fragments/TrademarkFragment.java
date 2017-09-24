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
import com.example.lenovo.luanvantotnghiep.Presenter.Logic_Presenters.PresenterTrademark;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.Interface_Views.IViewTrademark;

import java.util.List;

/**
 * Created by Lenovo on 6/19/2017.
 */

public class TrademarkFragment extends Fragment implements IViewTrademark{

    AdapterTrademark adapterTrademark;
    RecyclerView recyclerTrademark;
    PresenterTrademark presenterTrademark;
    List<ThuongHieu> thuongHieuList;

    public TrademarkFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_trademark_fragment,container, false);
        recyclerTrademark = (RecyclerView) view.findViewById(R.id.recyclerTrademark);
        presenterTrademark = new PresenterTrademark(this);
        presenterTrademark.layDanhSachTrademark();
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
