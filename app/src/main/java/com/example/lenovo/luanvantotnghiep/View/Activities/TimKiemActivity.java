package com.example.lenovo.luanvantotnghiep.View.Activities;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.luanvantotnghiep.Model.Objects.ILoadMore;
import com.example.lenovo.luanvantotnghiep.Model.Objects.LoadMoreScroll;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterSanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicTimKiem;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewTimKiem;

import java.util.List;

public class TimKiemActivity extends AppCompatActivity implements IViewTimKiem, SearchView.OnQueryTextListener{

    Toolbar toolbar;
    RecyclerView recyclerTimKiem;
    TextView txtThongBao;
    PresenterLogicTimKiem presenterLogicTimKiem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        recyclerTimKiem = (RecyclerView) findViewById(R.id.recyclerTimKiem);
        txtThongBao = (TextView) findViewById(R.id.txtThongBao);
        actionBar();
        presenterLogicTimKiem = new PresenterLogicTimKiem(this);
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_timkiem, menu);
        MenuItem itSearch = menu.findItem(R.id.itSearch);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(itSearch);
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public void timKiemThanhCong(List<SanPham> sanPhamList) {
        recyclerTimKiem.setVisibility(View.VISIBLE);
        txtThongBao.setVisibility(View.GONE);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        AdapterSanPham adapterSanPham = new AdapterSanPham(this,sanPhamList,R.layout.custom_listview_sanpham_theothuonghieu);

        recyclerTimKiem.setLayoutManager(layoutManager);
        recyclerTimKiem.setAdapter(adapterSanPham);
        adapterSanPham.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if ( id == android.R.id.home ) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void timKiemThatBai() {
        recyclerTimKiem.setVisibility(View.GONE);
        txtThongBao.setVisibility(View.VISIBLE);
        txtThongBao.setText("Không tìm thấy sản phẩm");
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        presenterLogicTimKiem.timKiemSanPhamTheoTen(s,0);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}
