package com.example.fooooood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnalysisAdapter extends RecyclerView.Adapter<AnalysisAdapter.ViewHolder> {
    ArrayList<Analysis> analysis;
    Context context;

    public AnalysisAdapter(Context context, ArrayList<Analysis> analysis){
        this.context = context;
        this.analysis = analysis;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.analysis_blocks, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.t1.setText(analysis.get(position).getMeal1());
        holder.t2.setText(analysis.get(position).getMeal2());
        holder.t3.setText(analysis.get(position).getMeal3());
        holder.t4.setText(analysis.get(position).getQuant1());
        holder.t5.setText(analysis.get(position).getQuant2());
        holder.t6.setText(analysis.get(position).getQuant3());
        holder.title.setText(analysis.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return analysis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView t1;
        TextView t2;
        TextView t3;
        TextView t4;
        TextView t5;
        TextView t6;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.top1_meal);
            t2 = itemView.findViewById(R.id.top2_meal);
            t3 = itemView.findViewById(R.id.top3_meal);
            t4 = itemView.findViewById(R.id.top1_quantities);
            t5 = itemView.findViewById(R.id.top2_quantities);
            t6 = itemView.findViewById(R.id.top3_quantities);
            title = itemView.findViewById(R.id.analysisTitle);
        }
    }
}
