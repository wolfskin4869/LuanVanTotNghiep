package com.example.lenovo.luanvantotnghiep.Presenter.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lenovo.luanvantotnghiep.Model.Objects.DanhGia;
import com.example.lenovo.luanvantotnghiep.R;

import java.util.List;

/**
 * Created by Lenovo on 10/13/2017.
 */

public class AdapterDanhGia extends RecyclerView.Adapter<AdapterDanhGia.ViewHolderDanhGia> {

    List<DanhGia> danhGiaList;
    int limit;
    Context context;

    public AdapterDanhGia(Context context, List<DanhGia> danhGiaList, int limit) {
        this.danhGiaList = danhGiaList;
        this.limit = limit;
        this.context = context;
    }

    public class ViewHolderDanhGia extends RecyclerView.ViewHolder {

        TextView txtTieuDe, txtNoiDung, txtWrittenBy, txtNgayDanhGia;
        RatingBar rbDanhGia;

        public ViewHolderDanhGia(View itemView) {
            super(itemView);
            txtTieuDe = (TextView) itemView.findViewById(R.id.txtTieuDe);
            txtNoiDung = (TextView) itemView.findViewById(R.id.txtNoiDung);
            txtWrittenBy = (TextView) itemView.findViewById(R.id.txtWrittenBy);
            txtNgayDanhGia = (TextView) itemView.findViewById(R.id.txtNgayDanhGia);
            rbDanhGia = (RatingBar) itemView.findViewById(R.id.rbDanhGia);
        }
    }

    @Override
    public ViewHolderDanhGia onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_layout_danhgiachitiet,parent,false);
        ViewHolderDanhGia viewHolderDanhGia = new ViewHolderDanhGia(view);
        return viewHolderDanhGia;
    }

    @Override
    public void onBindViewHolder(ViewHolderDanhGia holder, int position) {
        DanhGia danhGia = danhGiaList.get(position);
        holder.txtTieuDe.setText(danhGia.getTieuDe());
        holder.txtNoiDung.setText(danhGia.getNoiDung());
        holder.txtWrittenBy.setText("Được đánh giá bởi: "+danhGia.getTenThietBi());
        holder.txtNgayDanhGia.setText("Ngày đăng: "+danhGia.getNgayDanhGia());
        holder.rbDanhGia.setRating(danhGia.getSoSao());
    }

    @Override
    public int getItemCount() {
        int dong = 0;
        if(danhGiaList.size() < limit){
            dong = danhGiaList.size();
        }else{
            if(limit != 0){
                dong = limit;
            }else {
                dong = danhGiaList.size();
            }
        }
        return dong;
    }


}
