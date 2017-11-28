package com.example.lenovo.luanvantotnghiep.Presenter.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lenovo.luanvantotnghiep.Model.Objects.ChiTietKhuyenMai;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.Activities.ChiTietSanPhamActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Lenovo on 6/22/2017.
 */

public class AdapterSanPham extends RecyclerView.Adapter<AdapterSanPham.ViewHolderSanPham> {

    Context context;
    List<SanPham> sanPhams;
    int layout;

    public AdapterSanPham(Context context, List<SanPham> sanPhams, int layout) {
        this.context = context;
        this.sanPhams = sanPhams;
        this.layout = layout;
    }

    public class ViewHolderSanPham extends RecyclerView.ViewHolder {
        TextView txtTenSanPham, txtGiaSanPham, txtGiamGia;
        ImageView imgHinhSanPham;
        ProgressBar progressBar;
        CardView cardView;
        public ViewHolderSanPham(View itemView) {
            super(itemView);
            txtTenSanPham = (TextView) itemView.findViewById(R.id.txtTenSanPham);
            txtGiaSanPham = (TextView) itemView.findViewById(R.id.txtGiaSanPham);
            imgHinhSanPham = (ImageView) itemView.findViewById(R.id.imgHinhSanPham);
            txtGiamGia = (TextView) itemView.findViewById(R.id.txtGiamGia);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
            cardView = (CardView) itemView.findViewById(R.id.cardView);

        }
    }

    @Override
    public ViewHolderSanPham onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layout,parent,false);
        ViewHolderSanPham viewHolder = new ViewHolderSanPham(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderSanPham holder, int position) {
        final SanPham sanPham = sanPhams.get(position);
        holder.txtTenSanPham.setMaxLines(1);
        holder.txtTenSanPham.setEllipsize(TextUtils.TruncateAt.END);
        holder.txtTenSanPham.setText(sanPham.getTenSanPham());

        ChiTietKhuyenMai chiTietKhuyenMai = sanPham.getChiTietKhuyenMai();
        int giaTien = sanPham.getGiaSanPham();
        if(chiTietKhuyenMai != null){
            int phanTramKM = chiTietKhuyenMai.getPhanTramKM();

            if(phanTramKM > 0){ // Nếu có phần trăm giảm giá

                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                String giaSP = decimalFormat.format(giaTien);

                holder.txtGiamGia.setVisibility(View.VISIBLE);
                holder.txtGiamGia.setPaintFlags(holder.txtGiamGia.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
                holder.txtGiamGia.setText("Giá cũ: "+giaSP+ " VNĐ");

                giaTien = giaTien - (giaTien*phanTramKM/100);

            }else {
                holder.txtGiamGia.setVisibility(View.GONE);
            }
        }
        DecimalFormat format = new DecimalFormat("###,###,###");
        holder.txtGiaSanPham.setText("Giá: "+format.format(giaTien)+ " VNĐ");


        Picasso.with(context).load(sanPham.getHinhLon()).into(holder.imgHinhSanPham, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iChiTietSanPham = new Intent(context, ChiTietSanPhamActivity.class);
                iChiTietSanPham.putExtra("MASANPHAM", sanPham.getMaSanPham());
                context.startActivity(iChiTietSanPham);
            }
        });

    }

    @Override
    public int getItemCount() {
        return sanPhams.size();
    }


}
