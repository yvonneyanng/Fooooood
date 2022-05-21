package com.example.fooooood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

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

        TextView textAnalysis = (TextView) findViewById(R.id.back_analysis);
        // back to main page
        textAnalysis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AnalysisActivity.this, RestaurantMainActivity.class);
                startActivity(intent);
            }
        });
    }
}