package com.example.lenovo.luanvantotnghiep.Presenter.Adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.luanvantotnghiep.Model.Objects.KhuyenMai;
import com.example.lenovo.luanvantotnghiep.R;

import java.util.List;

/**
 * Created by Lenovo on 11/8/2017.
 */

public class AdapterKhuyenMai extends RecyclerView.Adapter<AdapterKhuyenMai.ViewHolderKhuyenMai> {

    Context context;
    List<KhuyenMai> khuyenMaiList;

    public AdapterKhuyenMai(Context context, List<KhuyenMai> khuyenMaiList) {
        this.context = context;
        this.khuyenMaiList = khuyenMaiList;
    }

    public class ViewHolderKhuyenMai extends RecyclerView.ViewHolder {

        RecyclerView rclItemKhuyenMai;
        TextView txtTieuDeKM;

        public ViewHolderKhuyenMai(View itemView) {
            super(itemView);
            txtTieuDeKM = (TextView) itemView.findViewById(R.id.txtTieuDeKM);
            rclItemKhuyenMai = (RecyclerView) itemView.findViewById(R.id.rclItemKhuyenMai);

        }
    }

    @Override
    public ViewHolderKhuyenMai onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_recyclerview_khuyenmai,parent,false);
        ViewHolderKhuyenMai viewHolderKhuyenMai = new ViewHolderKhuyenMai(view);
        return viewHolderKhuyenMai;
    }

    @Override
    public void onBindViewHolder(ViewHolderKhuyenMai holder, int position) {
        KhuyenMai khuyenMai = khuyenMaiList.get(position);
        holder.txtTieuDeKM.setText(khuyenMai.getTenLoaiSP());

        AdapterSanPham adapterSanPham = new AdapterSanPham(context,khuyenMai.getDsSanPhamSale(),R.layout.custom_item_khuyenmai);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.rclItemKhuyenMai.setLayoutManager(layoutManager);
        holder.rclItemKhuyenMai.setAdapter(adapterSanPham);
    }

    @Override
    public int getItemCount() {
        return khuyenMaiList.size();
    }
}
