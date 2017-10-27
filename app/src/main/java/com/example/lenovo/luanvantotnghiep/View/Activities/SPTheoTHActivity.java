package com.example.lenovo.luanvantotnghiep.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterSanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicSPTheoTH;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewSPTheoThuongHieu;

import java.util.List;

/**
 * Created by Lenovo on 6/26/2017.
 */

public class SPTheoTHActivity extends AppCompatActivity implements IViewSPTheoThuongHieu, View.OnClickListener {

    RecyclerView recyclerView;
    Button btnChange;
    Toolbar toolBar;
    boolean dangGrid = true;
    RecyclerView.LayoutManager layoutManager;
    PresenterLogicSPTheoTH sanPhamTheoThuongHieu;
    String mathuonghieu;
    AdapterSanPham adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_san_pham_theo_thuong_hieu);
        addControls();
        addEvents();
        toolBar = (Toolbar) findViewById(R.id.toolBar);

        Intent intent = getIntent();
        mathuonghieu = intent.getStringExtra("MATHUONGHIEU");
        String tenthuonghieu = intent.getStringExtra("TENSANPHAM");
        toolBar.setTitle(tenthuonghieu);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        sanPhamTheoThuongHieu = new PresenterLogicSPTheoTH(this);
        sanPhamTheoThuongHieu.layDanhSachTheoMaThuongHieu(mathuonghieu);

    }

    private void addEvents() {
        btnChange.setOnClickListener(this);
    }

    private void addControls() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerSanPhamTheoThuongHieu);
        btnChange = (Button) findViewById(R.id.btnChange);
    }

    @Override
    public void hienThiDSSanPham(List<SanPham> sanPhams) {
        if(dangGrid){
            layoutManager = new GridLayoutManager(SPTheoTHActivity.this, 2);
            adapter = new AdapterSanPham(SPTheoTHActivity.this,sanPhams,R.layout.custom_recyclerview_mobile);
        }else{
            layoutManager = new LinearLayoutManager(SPTheoTHActivity.this);
            adapter = new AdapterSanPham(SPTheoTHActivity.this,sanPhams,R.layout.custom_listview_sptheothuonghieu);
        }
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loiHienThiDSSanPham() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Toolbar back to previous fragment
            case android.R.id.home:
                Intent parentIntent = NavUtils.getParentActivityIntent(this);
                parentIntent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
                        | Intent.FLAG_ACTIVITY_SINGLE_TOP
                        | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(parentIntent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnChange:
                dangGrid = !dangGrid;
                sanPhamTheoThuongHieu.layDanhSachTheoMaThuongHieu(mathuonghieu);
                break;
        }
    }
}
