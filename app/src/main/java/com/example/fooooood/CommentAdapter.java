package com.example.fooooood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class CommentAdapter extends ArrayAdapter<Comment> {
    private Context context;
    private int res;
    ArrayList<Comment> commentList;

    public CommentAdapter(@NonNull Context context, int resource, ArrayList<Comment> commentList) {
        super(context, resource, commentList);
        this.context = context;
        this.res = resource;
        this.commentList = commentList;
    }

    @NonNull
    @Override
    // 設定 list view
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(res, parent, false);
        TextView commentItem = convertView.findViewById(R.id.clientComment);
        commentItem.setText(getItem(position).getComment());
        return convertView;
    }
}
