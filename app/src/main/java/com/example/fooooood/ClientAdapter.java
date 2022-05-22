package com.example.fooooood;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder>{

    private List<Client> myListClient;

    public void setData(List<Client> list){
        this.myListClient = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.client_list, parent, false);
        return new ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        Client client = myListClient.get(position);
        if(client == null){
            return;
        }
        holder.name.setText(client.getName());
        holder.number.setText(client.getNumber());
        holder.status.setImageResource(client.getStatus());
        holder.time.setText(client.getTime());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                View dialogView = LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.order_list, null);
                Dialog dialog;
                TextView progress = dialogView.findViewById(R.id.progress);
                Button accept = dialogView.findViewById(R.id.accept);
                Button decline = dialogView.findViewById(R.id.decline);
                Button complete = dialogView.findViewById(R.id.complete);
                if (client.status == R.drawable.check || client.status == R.drawable.close) {
                    if(client.status == R.drawable.check){
                        progress.setText("您已完成此訂單！");
                    } else {
                        progress.setText("您已拒絕此訂單！");
                    }
                    accept.setVisibility(View.GONE);
                    decline.setVisibility(View.GONE);
                    complete.setVisibility(View.GONE);
                } else if(client.status == R.drawable.incoming){
                    progress.setText("是否接受此訂單？");
                    accept.setVisibility(View.VISIBLE);
                    decline.setVisibility(View.VISIBLE);
                    complete.setVisibility(View.GONE);
                } else if(client.status == R.drawable.doing){
                    accept.setVisibility(View.GONE);
                    decline.setVisibility(View.GONE);
                    complete.setVisibility(View.VISIBLE);
                }

                builder.setView(dialogView);
                builder.setCancelable(true);

                dialog = builder.show();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                if(dialog.getWindow() != null){
                    WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
                    lp.width = 900;
                    dialog.getWindow().setAttributes(lp);
                }

                accept.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        accept.setVisibility(View.GONE);
                        decline.setVisibility(View.GONE);
                        complete.setVisibility(View.VISIBLE);
                        holder.status.setImageResource(R.drawable.doing);
                        client.status = R.drawable.doing;
                        progress.setText("您已接受此訂單，正在製作中...");
                    }
                });

                decline.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        holder.status.setImageResource(R.drawable.close);
                        client.status = R.drawable.close;
                    }
                });

                complete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        holder.status.setImageResource(R.drawable.check);
                        client.status = R.drawable.check;
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        if(myListClient != null){
            return myListClient.size();
        }
        return 0;
    }

    public class ClientViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView number;
        private ImageView status;
        private TextView time;
        private CardView cardView;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            status = itemView.findViewById(R.id.status);
            time = itemView.findViewById(R.id.time);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
