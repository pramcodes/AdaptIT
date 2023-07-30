package com.example.adaptit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adaptit.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
        ArrayList<com.example.adaptit.Bursary> bursaryArrayList;

        public Adapter (ArrayList<com.example.adaptit.Bursary> bursaryArrayList) {
            this.bursaryArrayList = bursaryArrayList;
        }

        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_bursary,parent, false);
            return new ViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.name.setText(bursaryArrayList.get(position).getName());
            holder.comapanyName.setText(String.valueOf(bursaryArrayList.get(position).getCompanyName()));
            holder.description.setText(String.valueOf(bursaryArrayList.get(position).getDescription()));
        }

        @Override
        public int getItemCount() {
            return bursaryArrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView name, comapanyName, description;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                name=itemView.findViewById(R.id.nametxt);
                comapanyName=itemView.findViewById(R.id.companyNametxt);
                description=itemView.findViewById(R.id.descriptiontxt);
            }
        }
    }
