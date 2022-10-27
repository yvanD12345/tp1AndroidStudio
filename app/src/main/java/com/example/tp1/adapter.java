package com.example.tp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {

    private Context context;

    private ArrayList companyName_id, poste_id;

    private ArrayList<OffreStageListModel> offreStageListModels;

    public adapter(Context context, ArrayList companyName_id, ArrayList poste_id/*, ArrayList<OffreStageListModel> offreStageListModels*/) {
        this.context = context;
        this.companyName_id = companyName_id;
;
        this.poste_id = poste_id;
       // this.offreStageListModels = offreStageListModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.companyname_id.setText(String.valueOf(companyName_id.get(position)) );
        holder.poste_id.setText(String.valueOf(poste_id.get(position)) );

    }

    @Override
    public int getItemCount() {
        return companyName_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView companyname_id, email_id, contact_id,poste_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            companyname_id = itemView.findViewById(R.id.companyName);
            poste_id = itemView.findViewById(R.id.nomPoste);
        }
    }
}
