package com.example.lenovo.luanvantotnghiep.View.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterGioHang;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicGioHang;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewGioHang;

import java.util.List;

public class GioHangActivity extends AppCompatActivity implements IViewGioHang{

    RecyclerView recyclerView;
    PresenterLogicGioHang presenterLogicGioHang;
    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerGioHang);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        actionBar();

        presenterLogicGioHang = new PresenterLogicGioHang(this);
        presenterLogicGioHang.layDSSPTrongGioHang(this);
    }

    private void actionBar() {
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if ( id == android.R.id.home ) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void hienThiDSSPTrongGioHang(List<SanPham> sanPhamList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        AdapterGioHang adapterGioHang = new AdapterGioHang(this,sanPhamList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterGioHang);
        adapterGioHang.notifyDataSetChanged();
    }
}
