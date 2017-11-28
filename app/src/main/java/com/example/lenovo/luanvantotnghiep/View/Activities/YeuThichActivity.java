package com.example.lenovo.luanvantotnghiep.View.Activities;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterYeuThich;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicChiTietSP;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresentersLogicYeuThich;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewYeuThich;

import java.util.List;

public class YeuThichActivity extends AppCompatActivity implements IViewYeuThich, View.OnClickListener{

    RecyclerView recyclerYeuThich;
    Button btnAddToCart;
    Toolbar toolbar;
    TextView txtGioHang;
    PresentersLogicYeuThich presentersLogicYeuThich;
    PresenterLogicChiTietSP presenterLogicChiTietSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeu_thich);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        recyclerYeuThich = (RecyclerView) findViewById(R.id.recyclerYeuThich);
        btnAddToCart = (Button) findViewById(R.id.btnAddToCart);
        presentersLogicYeuThich = new PresentersLogicYeuThich(this,this);
        presentersLogicYeuThich.layDanhSachSanPhamYeuThich(this);
        btnAddToCart.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu_trangchu,menu);

        MenuItem iGioHang = menu.findItem(R.id.itemGioHang);
        View giaoDienCustomGioHang = MenuItemCompat.getActionView(iGioHang);

        giaoDienCustomGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGioHang = new Intent(YeuThichActivity.this, GioHangActivity.class);
                startActivity(iGioHang);
            }
        });
        txtGioHang = (TextView) giaoDienCustomGioHang.findViewById(R.id.txtSoLuongSPGioHang);
        txtGioHang.setText(String.valueOf(presenterLogicChiTietSP.demSPCoTrongGioHang(this)));

        return true;
    }

    @Override
    public void hienThiDanhSachSanPhamYeuThich(List<SanPham> sanPhamList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        AdapterYeuThich adapterYeuThich = new AdapterYeuThich(this,sanPhamList,this);
        recyclerYeuThich.setLayoutManager(layoutManager);
        recyclerYeuThich.setAdapter(adapterYeuThich);
        adapterYeuThich.notifyDataSetChanged();
    }

    @Override
    public void themVaoGioHangThanhCong() {
        Toast.makeText(this, "Thêm giỏ hàng thành công", Toast.LENGTH_SHORT).show();
        txtGioHang.setText(String.valueOf(presenterLogicChiTietSP.demSPCoTrongGioHang(this)));
    }

    @Override
    public void themVaoGioHangThatBai() {
        Toast.makeText(this, "Sản phảm đã có trong giỏ hàng", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if ( id == android.R.id.home ) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
