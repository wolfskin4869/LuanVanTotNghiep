package com.example.lenovo.luanvantotnghiep.Presenter.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.luanvantotnghiep.Model.SQLite.ModelGioHang;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.R;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Lenovo on 10/22/2017.
 */

public class AdapterGioHang extends RecyclerView.Adapter<AdapterGioHang.ViewHolderGioHang> {


    Context context;
    List<SanPham> sanPhamList;
    ModelGioHang modelGioHang;

    public AdapterGioHang(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
        modelGioHang = new ModelGioHang();
        modelGioHang.moKetNoi(context);
    }

    public class ViewHolderGioHang extends RecyclerView.ViewHolder {
        TextView txtTenSanPham, txtGiaSanPham, txtSoLuongSP, txtGiamGia;
        ImageView imgHinhSanPham, imgXoaSanPham;
        ImageButton btnAdd, btnRemove;
        public ViewHolderGioHang(View itemView) {
            super(itemView);
            txtTenSanPham = (TextView) itemView.findViewById(R.id.txtTenSanPham);
            txtGiaSanPham = (TextView) itemView.findViewById(R.id.txtGiaSanPham);
            txtSoLuongSP = (TextView) itemView.findViewById(R.id.txtSoLuongSP);
            txtGiamGia = (TextView) itemView.findViewById(R.id.txtGiamGia);
            imgHinhSanPham = (ImageView) itemView.findViewById(R.id.imgHinhSanPham);
            imgXoaSanPham = (ImageView) itemView.findViewById(R.id.imgXoaSanPham);
            btnAdd = (ImageButton) itemView.findViewById(R.id.btnAdd);
            btnRemove = (ImageButton) itemView.findViewById(R.id.btnRemove);
        }
    }

    @Override
    public ViewHolderGioHang onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_recyclerview_gio_hang,parent,false);
        ViewHolderGioHang viewHolderGioHang = new ViewHolderGioHang(view);
        return viewHolderGioHang;
    }

    @Override
    public void onBindViewHolder(final ViewHolderGioHang holder, final int position) {
        final SanPham sanPham = sanPhamList.get(position);

        holder.txtTenSanPham.setText(sanPham.getTenSanPham());

        int giaTien = sanPham.getGiaSanPham();
//        int phanTramKM = sanPham.getGiaSanPham()
/*        if(phanTramKM > 0){
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            holder.txtGiamGia.setVisibility(View.VISIBLE);
            holder.txtGiamGia.setPaintFlags(holder.txtGiamGia.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            holder.txtGiamGia.setText("Giá cũ: "+decimalFormat.format(giaTien)+ " VNĐ");
            giaTien = giaTien - (phanTramKM*phanTramKM/100);
        }*/

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGiaSanPham.setText("Giá: "+decimalFormat.format(sanPham.getGiaSanPham())+ " VNĐ");




        byte[] hinhSanPham = sanPham.getHinhSQLite();
        Bitmap bitmapHinhSP = BitmapFactory.decodeByteArray(hinhSanPham,0,hinhSanPham.length);
        holder.imgHinhSanPham.setImageBitmap(bitmapHinhSP);

        holder.imgXoaSanPham.setTag(sanPham.getMaSanPham());
        holder.imgXoaSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelGioHang modelGioHang = new ModelGioHang();
                modelGioHang.moKetNoi(context);
                modelGioHang.xoaSanPhamTrongGioHang((int) v.getTag());
                sanPhamList.remove(position);
                notifyDataSetChanged();
            }
        });

        holder.txtSoLuongSP.setText(String.valueOf(sanPham.getSoLuongDat()));

        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soLuongDat = Integer.parseInt(holder.txtSoLuongSP.getText().toString());
                int soLuongTon = sanPham.getSoLuongTon();

                if(soLuongDat < soLuongTon){
                    soLuongDat++;
                }else{
                    Toast.makeText(context, "Xin lỗi! Chúng tôi chỉ còn "+soLuongDat+" sản phẩm này", Toast.LENGTH_SHORT).show();
                }
                modelGioHang.capNhatSoLuongSPTrongGioHang(sanPham.getMaSanPham(),soLuongDat);

                holder.txtSoLuongSP.setText(String.valueOf(soLuongDat));
            }
        });

        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int soLuong = Integer.parseInt(holder.txtSoLuongSP.getText().toString());

                if(soLuong > 1){
                    soLuong--;
                }
                modelGioHang.capNhatSoLuongSPTrongGioHang(sanPham.getMaSanPham(),soLuong);
                holder.txtSoLuongSP.setText(String.valueOf(soLuong));
            }
        });
    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }


}
