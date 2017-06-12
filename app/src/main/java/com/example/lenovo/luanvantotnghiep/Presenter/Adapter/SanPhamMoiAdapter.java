package com.example.lenovo.luanvantotnghiep.Presenter.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.luanvantotnghiep.Model.Class.SanPhamMoi;
import com.example.lenovo.luanvantotnghiep.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Lenovo on 6/9/2017.
 */

public class SanPhamMoiAdapter extends RecyclerView.Adapter<SanPhamMoiAdapter.ItemHolder> {

    Context context;
    ArrayList<SanPhamMoi> arraySanPhamMoi;

    public SanPhamMoiAdapter(Context context, ArrayList<SanPhamMoi> arraySanPhamMoi) {
        this.context = context;
        this.arraySanPhamMoi = arraySanPhamMoi;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_sanphammoi, null);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        SanPhamMoi sanPhamMoi = arraySanPhamMoi.get(position);
        holder.txtTenSanPham.setText(sanPhamMoi.getTenSP());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGiaSanPham.setText("Giá : "+decimalFormat.format(sanPhamMoi.getGiaSP())+ "VNĐ");
        Picasso.with(context).load(sanPhamMoi.getMaSP()).into(holder.imgHinhSanPham);
    }

    @Override
    public int getItemCount() {
        return arraySanPhamMoi.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imgHinhSanPham;
        public TextView txtTenSanPham, txtGiaSanPham;

        public ItemHolder(View itemView) {
            super(itemView);
            imgHinhSanPham = (ImageView) itemView.findViewById(R.id.imgHinhSanPham);
            txtTenSanPham = (TextView) itemView.findViewById(R.id.txtTenSanPham);
            txtGiaSanPham = (TextView) itemView.findViewById(R.id.txtGiaSanPham);
        }
    }
}
