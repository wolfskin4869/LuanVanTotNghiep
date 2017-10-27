package com.example.lenovo.luanvantotnghiep.View.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.lenovo.luanvantotnghiep.Model.Objects.DanhGia;
import com.example.lenovo.luanvantotnghiep.Model.Objects.ILoadMore;
import com.example.lenovo.luanvantotnghiep.Model.Objects.LoadMoreScroll;
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterDanhGia;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicDanhGia;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewDanhGia;

import java.util.ArrayList;
import java.util.List;

public class TatCaDanhGiaActivity extends AppCompatActivity implements IViewDanhGia, ILoadMore{

    RecyclerView recyclerViewDSDanhGia;
    ProgressBar progressBar;
    String maSP;
    PresenterLogicDanhGia presenterLogicDanhGia;
    List<DanhGia> allDanhGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tat_ca_danh_gia);
        recyclerViewDSDanhGia = (RecyclerView) findViewById(R.id.recyclerDSDanhGia);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        maSP = getIntent().getStringExtra("MASANPHAM");
        allDanhGia = new ArrayList<>();
        presenterLogicDanhGia = new PresenterLogicDanhGia(this);
        presenterLogicDanhGia.layDSDanhGiaTheoSP(maSP,0,progressBar);

    }

    @Override
    public void danhGiaThanhCong() {

    }

    @Override
    public void danhGiaThatBai() {

    }

    @Override
    public void hienThiDSDanhGiaTheoSP(List<DanhGia> danhGiaList) {
        allDanhGia.addAll(danhGiaList);
        AdapterDanhGia adapterDanhGia = new AdapterDanhGia(this, allDanhGia,0);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewDSDanhGia.setLayoutManager(layoutManager);
        recyclerViewDSDanhGia.setAdapter(adapterDanhGia);
        recyclerViewDSDanhGia.addOnScrollListener(new LoadMoreScroll(layoutManager,this));
        adapterDanhGia.notifyDataSetChanged();
    }

    @Override
    public void loadMore(int tongItem) {
        presenterLogicDanhGia.layDSDanhGiaTheoSP(maSP,tongItem,progressBar);
    }
}
