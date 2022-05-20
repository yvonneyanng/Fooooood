package com.example.fooooood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMainActivity extends AppCompatActivity {

    private RecyclerView rcvClient;
    private ClientAdapter clientAdapter;
    List<Client> clientList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        rcvClient = findViewById(R.id.rcv_client);
        clientAdapter = new ClientAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvClient.setLayoutManager(linearLayoutManager);
        clientAdapter.setData(getListUser());
        rcvClient.setAdapter(clientAdapter);

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

        TextView textEdit = (TextView) findViewById(R.id.edit);
        TextView textAnalysis = (TextView) findViewById(R.id.analysis);

        // edit page
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

    private List<Client> getListUser() {
        clientList.add(new Client(R.drawable.questionmark, "陳小姐", "0911111111", "1:00 PM"));
        clientList.add(new Client(R.drawable.close, "何先生", "0922222222", "1:30 PM"));
        clientList.add(new Client(R.drawable.check, "林小姐", "0933333333", "2:00 PM"));
        clientList.add(new Client(R.drawable.check, "王先生", "0944444444", "2:30 PM"));
        clientList.add(new Client(R.drawable.check, "陳小姐", "0955555555", "3:00 PM"));
        clientList.add(new Client(R.drawable.check, "何先生", "0966666666", "3:30 PM"));
        clientList.add(new Client(R.drawable.check, "林先生", "0977777777", "4:00 PM"));
        clientList.add(new Client(R.drawable.close, "楊先生", "0988888888", "4:30 PM"));
        clientList.add(new Client(R.drawable.check, "陳小姐", "0912345678", "5:00 PM"));
        clientList.add(new Client(R.drawable.close, "吳先生", "0987654321", "5:30 PM"));
        clientList.add(new Client(R.drawable.check, "林小姐", "0913579246", "6:00 PM"));
        clientList.add(new Client(R.drawable.close, "王小姐", "0924680135", "6:30 PM"));
        return clientList;
    }
}