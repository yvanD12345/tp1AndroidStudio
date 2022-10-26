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

    private ArrayList companyName_id, email_id,contact_id;

    private ArrayList<OffreStageListModel> offreStageListModels;

    public adapter(Context context, ArrayList companyName_id, ArrayList email_id, ArrayList contact_id/*, ArrayList<OffreStageListModel> offreStageListModels*/) {
        this.context = context;
        this.companyName_id = companyName_id;
        this.email_id = email_id;
        this.contact_id = contact_id;
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
        holder.email_id.setText(String.valueOf(email_id.get(position)) );
        holder.contact_id.setText(String.valueOf(contact_id.get(position)) );
    }

    @Override
    public int getItemCount() {
        return companyName_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView companyname_id, email_id, contact_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            companyname_id = itemView.findViewById(R.id.textcompanyName);
            email_id = itemView.findViewById(R.id.textemail);
            contact_id = itemView.findViewById(R.id.textcontact);
        }
    }
}
