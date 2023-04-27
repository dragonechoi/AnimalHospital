package com.cys.animalhospital;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.VH> {

    Context context;
    ArrayList<AnimalItem> animalItems;

    public AnimalAdapter(Context context, ArrayList<AnimalItem> animalItems) {
        this.context = context;
        this.animalItems = animalItems;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        AnimalItem item=animalItems.get(position);
        holder.iv_Call.setImageResource(item.iv_Call);
        holder.app_logo.setImageResource(item.app_logo);

        holder.BIZPLC_NM.setText(item.BIZPLC_NM);
        holder.REFINE_ROADNM_ADDR.setText(item.REFINE_ROADNM_ADDR);
        holder.REFINE_LOTNO_ADDR.setText(item.REFINE_LOTNO_ADDR);
        holder.BSN_STATE_NM.setText(item.BSN_STATE_NM);
        holder.LOCPLC_FACLT_TELNO.setText(item.LOCPLC_FACLT_TELNO);
        holder.REFINE_ZIP_CD.setText(item.REFINE_ZIP_CD);
    }

    @Override
    public int getItemCount() {
        return animalItems.size();
    }

    class VH  extends RecyclerView.ViewHolder{
        TextView BIZPLC_NM,REFINE_ROADNM_ADDR, REFINE_LOTNO_ADDR,BSN_STATE_NM,LOCPLC_FACLT_TELNO,REFINE_ZIP_CD;
        ImageView app_logo;
        ImageButton iv_Call;
        public VH(@NonNull View itemView) {
            super(itemView);

            BIZPLC_NM=itemView.findViewById(R.id.BIZPLC_NM);
            REFINE_ROADNM_ADDR=itemView.findViewById(R.id.REFINE_ROADNM_ADDR);
            REFINE_LOTNO_ADDR=itemView.findViewById(R.id.REFINE_LOTNO_ADDR);
            REFINE_LOTNO_ADDR=itemView.findViewById(R.id.REFINE_LOTNO_ADDR);
            BSN_STATE_NM=itemView.findViewById(R.id.tv_open_close);
            LOCPLC_FACLT_TELNO=itemView.findViewById(R.id.LOCPLC_FACLT_TELNO);
            app_logo=itemView.findViewById(R.id.app_logo);
            iv_Call=itemView.findViewById(R.id.iv_Call);
            REFINE_ZIP_CD=itemView.findViewById(R.id.REFINE_ZIP_CD);

        }
    }
}


