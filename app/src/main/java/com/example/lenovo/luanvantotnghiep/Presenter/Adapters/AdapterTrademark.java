package com.example.lenovo.luanvantotnghiep.Presenter.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.lenovo.luanvantotnghiep.Model.Objects.ThuongHieu;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.Activities.SPTheoThuongHieuActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Lenovo on 6/23/2017.
 */

public class AdapterTrademark extends RecyclerView.Adapter<AdapterTrademark.ViewHolderTrademark> {

    Context context;
    List<ThuongHieu> thuongHieus;

    public AdapterTrademark(Context context, List<ThuongHieu> thuongHieus) {
        this.context = context;
        this.thuongHieus = thuongHieus;
    }

    public class ViewHolderTrademark extends RecyclerView.ViewHolder {

        ImageView imgHinhTrademak;
        ProgressBar progressBarTrademak;
        LinearLayout lnThuongHieu;
        public ViewHolderTrademark(View itemView) {
            super(itemView);
            imgHinhTrademak = (ImageView) itemView.findViewById(R.id.imgHinhTrademark);
            progressBarTrademak = (ProgressBar) itemView.findViewById(R.id.progressBarTrademark);
            lnThuongHieu = (LinearLayout) itemView.findViewById(R.id.lnThuongHieu);
        }
    }

    @Override
    public ViewHolderTrademark onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_recyclerview_trademark,parent,false);
        ViewHolderTrademark viewHolder = new ViewHolderTrademark(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderTrademark holder, int position) {
        final ThuongHieu thuongHieu = thuongHieus.get(position);
        holder.lnThuongHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iSanPhamTheoDanhMuc = new Intent(context, SPTheoThuongHieuActivity.class);
                iSanPhamTheoDanhMuc.putExtra("MATHUONGHIEU", thuongHieu.getMaThuongHieu());
                iSanPhamTheoDanhMuc.putExtra("TENTHUONGHIEU", thuongHieu.getTenThuongHieu());
                context.startActivity(iSanPhamTheoDanhMuc);
            }
        });
        Picasso.with(context).load(thuongHieu.getHinhThuongHieu()).into(holder.imgHinhTrademak, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBarTrademak.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public int getItemCount() {
        return thuongHieus.size();
    }


}
