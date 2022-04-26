package com.example.fooooood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AnalysisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        TextView textAnalysis = (TextView) findViewById(R.id.back_analysis);
        // back to main page
        textAnalysis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AnalysisActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}