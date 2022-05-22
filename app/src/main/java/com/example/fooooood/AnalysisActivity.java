package com.example.fooooood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnalysisActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Analysis> analysis;
    AnalysisAdapter analysisAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);


        //  analysis blocks
        recyclerView = findViewById(R.id.analysis);
        analysis = new ArrayList<>();
        analysis.add(new Analysis("披薩", "義大利麵", "飲料", "500", "460", "200", "類別總銷量"));
        analysis.add(new Analysis("肉醬", "海鮮", "牛肉", "200", "180", "150", "披薩"));
        analysis.add(new Analysis("雞肉", "雞腿", "火腿", "100", "75", "40", "義大利麵"));
        analysis.add(new Analysis("可樂", "可爾必思", "紅茶", "50", "45", "30", "飲料"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(AnalysisActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        analysisAdapter = new AnalysisAdapter(AnalysisActivity.this, analysis);
        recyclerView.setAdapter(analysisAdapter);


        // comment list view
        listView = findViewById(R.id.comment);
        ArrayList<Comment> commentList = new ArrayList<>();
        commentList.add(new Comment("pizza 好吃"));
        commentList.add(new Comment("好難吃"));
        commentList.add(new Comment("可爾必思送來的時候灑了"));
        commentList.add(new Comment("難吃的媽媽給難吃開門，難吃到家了。"));
        commentList.add(new Comment("雞肉義大利麵很好吃"));
        commentList.add(new Comment("pizza 好吃"));;
        commentList.add(new Comment("可樂送來的時候灑了"));
        commentList.add(new Comment("雞腿義大利麵很好吃"));
        CommentAdapter commentAdapter = new CommentAdapter(this, R.layout.comment_list, commentList);
        listView.setAdapter(commentAdapter);


        // back to main page
        TextView textAnalysis = (TextView) findViewById(R.id.back_analysis);
        textAnalysis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AnalysisActivity.this, RestaurantMainActivity.class);
                startActivity(intent);
            }
        });
    }
}