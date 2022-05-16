package com.example.fooooood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{

    private List<Menu> myListMenu;
    public void setData(List<Menu> list){
        this.myListMenu = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_row, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu menu = myListMenu.get(position);
        if(menu == null){
            return;
        }
        holder.img.setImageResource(menu.getImage());
        holder.name.setText(menu.getName());
        holder.price.setText(menu.getPrice());
    }

    @Override
    public int getItemCount() {
        if(myListMenu != null){
            return myListMenu.size();
        }
        return 0;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView name;
        private TextView price;

        public MenuViewHolder(@NonNull View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.foodImg);
            name = itemView.findViewById(R.id.foodName);
            price = itemView.findViewById(R.id.foodPrice);
        }
    }
}
