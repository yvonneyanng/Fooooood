package com.example.fooooood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class RestaurantMainActivity extends AppCompatActivity {

    int changed1 = 0, changed2 = 0, changed3 = 0, changed4 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);


        // ============================================================================
        Switch st = (Switch) findViewById(R.id.status_switch);
        TextView storeSt = (TextView) findViewById(R.id.status_text);
        st.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    storeSt.setText("營業中");
                } else {
                    storeSt.setText("休息中");
                }
            }
        });


        // ============================================================================
        CardView card1 = findViewById(R.id.order_1);
        CardView card2 = findViewById(R.id.order_2);
        CardView card3 = findViewById(R.id.order_3);
        CardView card4 = findViewById(R.id.incoming);


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (changed1 == 0){
                    findViewById(R.id.order1).setVisibility(View.VISIBLE);
                    changed1 = 1;
                }else{
                    findViewById(R.id.order1).setVisibility(View.GONE);
                    changed1 = 0;
                }
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (changed2 == 0){
                    findViewById(R.id.order2).setVisibility(View.VISIBLE);
                    changed2 = 1;
                }else{
                    findViewById(R.id.order2).setVisibility(View.GONE);
                    changed2 = 0;
                }
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (changed3 == 0){
                    findViewById(R.id.order3).setVisibility(View.VISIBLE);
                    changed3 = 1;
                }else{
                    findViewById(R.id.order3).setVisibility(View.GONE);
                    changed3 = 0;
                }
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (changed4 == 0){
                    findViewById(R.id.order_info).setVisibility(View.VISIBLE);
                    changed4 = 1;
                }else{
                    findViewById(R.id.order_info).setVisibility(View.GONE);
                    changed4 = 0;
                }
            }
        });


        // ============================================================================
        Button buttonAccept = (Button) findViewById(R.id.accept);
        Button buttonDecline = (Button) findViewById(R.id.decline);
        Button buttonComplete = (Button) findViewById(R.id.complete);
        TextView textEdit = (TextView) findViewById(R.id.edit);
        TextView textAnalysis = (TextView) findViewById(R.id.analysis);
        ImageView img = (ImageView) findViewById(R.id.stat_img);

        // accept button clicked
        buttonAccept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                findViewById(R.id.button).setVisibility(View.GONE);
                findViewById(R.id.complete).setVisibility(View.VISIBLE);
            }
        });
        // complete button clicked
        buttonComplete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                findViewById(R.id.stat_img).setVisibility(View.VISIBLE);
                findViewById(R.id.complete).setVisibility(View.GONE);
                findViewById(R.id.order_info).setVisibility(View.GONE);
            }
        });
        // decline button clicked
        buttonDecline.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                findViewById(R.id.button).setVisibility(View.GONE);
                img.setImageResource(R.drawable.close);
                findViewById(R.id.stat_img).setVisibility(View.VISIBLE);
                findViewById(R.id.order_info).setVisibility(View.GONE);
            }
        });
        // edit menu
        textEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_edit = new Intent(RestaurantMainActivity.this, EditActivity.class);
                startActivity(intent_edit);
            }
        });
        // analysis page
        textAnalysis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_analysis = new Intent(RestaurantMainActivity.this, AnalysisActivity.class);
                startActivity(intent_analysis);
            }
        });
    }
}