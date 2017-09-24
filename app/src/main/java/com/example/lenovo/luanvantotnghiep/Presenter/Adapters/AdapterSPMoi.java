package com.example.lenovo.luanvantotnghiep.Presenter.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Lenovo on 6/21/2017.
 */

public class AdapterSPMoi extends RecyclerView.Adapter<AdapterSPMoi.ViewHolderSP>{

    Context context;
    List<SanPham> sanPhams;

    public AdapterSPMoi(Context context, List<SanPham> sanPhams) {
        this.context = context;
        this.sanPhams = sanPhams;
    }

    public class ViewHolderSP extends RecyclerView.ViewHolder {
        TextView txtTenSanPham, txtGiaSanPham;
        ImageView imgHinhSanPham;
        ProgressBar progressBar;
        public ViewHolderSP(View itemView) {
            super(itemView);
            txtTenSanPham = (TextView) itemView.findViewById(R.id.txtTenSanPham);
            txtGiaSanPham = (TextView) itemView.findViewById(R.id.txtGiaSanPham);
            imgHinhSanPham = (ImageView) itemView.findViewById(R.id.imgHinhSanPham);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
        }
    }

    @Override
    public ViewHolderSP onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_recyclerview_sanphammoi,parent,false);

        ViewHolderSP viewHolder = new ViewHolderSP(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderSP holder, int position) {
        SanPham sanPham = sanPhams.get(position);
        holder.txtTenSanPham.setText(sanPham.getTenSanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGiaSanPham.setText("Giá: "+decimalFormat.format(sanPham.getGiaSanPham())+ " VNĐ");
        Picasso.with(context).load(sanPham.getHinhLon()).into(holder.imgHinhSanPham, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public int getItemCount() {
        return sanPhams.size();
    }

}
