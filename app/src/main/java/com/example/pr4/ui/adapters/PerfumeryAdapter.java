package com.example.pr4.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pr4.R;
import com.example.pr4.data.model.PerfumeryEntity;

import java.util.List;

public class PerfumeryAdapter extends RecyclerView.Adapter<PerfumeryAdapter.PerfumeryEntityViewHolder> {

    private List<PerfumeryEntity> perfumery;

    public void setPerfumeryEntities(List<PerfumeryEntity> perfumeryEntities) {
        perfumery = perfumeryEntities;
        notifyDataSetChanged();
    }

    @Override
    public PerfumeryEntityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
        return new PerfumeryEntityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PerfumeryEntityViewHolder holder, int position) {
        if (perfumery != null) {
            PerfumeryEntity currentEntity = perfumery.get(position);
            holder.textViewName.setText(currentEntity.getName());
        } else {
            holder.textViewName.setText("No PerfumeryEntity");
        }
    }

    @Override
    public int getItemCount() {
        return perfumery != null ? perfumery.size() : 0;
    }

    static class PerfumeryEntityViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        public PerfumeryEntityViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView);
        }
    }
}