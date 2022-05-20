package com.example.fooooood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
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

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            status = itemView.findViewById(R.id.status);
            time = itemView.findViewById(R.id.time);
        }
    }
}
