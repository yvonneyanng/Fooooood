package com.example.fooooood;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
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

import org.w3c.dom.Text;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder>{

    private List<Client> myListClient;
    int changed = 0;
    int orderCompleteOrDecline = 0;

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
                TextView totalPrice = dialogView.findViewById(R.id.price);
                Button accept = dialogView.findViewById(R.id.accept);
                Button decline = dialogView.findViewById(R.id.decline);
                Button complete = dialogView.findViewById(R.id.complete);

                if(client.status == R.drawable.check || client.status == R.drawable.close || orderCompleteOrDecline == 1){
                    accept.setVisibility(View.GONE);
                    decline.setVisibility(View.GONE);
                    complete.setVisibility(View.GONE);
                } else if(client.status == R.drawable.questionmark && changed == 0){
                    accept.setVisibility(View.VISIBLE);
                    decline.setVisibility(View.VISIBLE);
                    complete.setVisibility(View.GONE);
                } else if(client.status == R.drawable.questionmark && changed == 1){
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

                totalPrice.setText(client.getPrice());
                accept.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        accept.setVisibility(View.GONE);
                        decline.setVisibility(View.GONE);
                        complete.setVisibility(View.VISIBLE);
                        changed = 1;
                    }
                });

                decline.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        holder.status.setImageResource(R.drawable.close);
                        orderCompleteOrDecline = 1;
                    }
                });

                complete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        holder.status.setImageResource(R.drawable.check);
                        orderCompleteOrDecline = 1;
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
        private ImageView imageView;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            status = itemView.findViewById(R.id.status);
            time = itemView.findViewById(R.id.time);
            cardView = itemView.findViewById(R.id.card);
            imageView = itemView.findViewById(R.id.status);
        }
    }
}
