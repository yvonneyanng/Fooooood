package com.example.fooooood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements OnCompleteListener {
    ToggleButton customer;
    ToggleButton restaurant;
    ToggleButton delivery;
    int toggle = 0;

    private EditText etAccount;
    private EditText etPassword;
    private EditText etName;
    private EditText etPhone;
    private EditText etSName;
    private EditText etSPhone;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toggle = R.id.toggleButton;

        etAccount = findViewById(R.id.textInputAccount);
        etPassword = findViewById(R.id.textInputPassword);
        etName = findViewById(R.id.textInputName);
        etPhone = findViewById(R.id.textInputPhone);
        etSName = findViewById(R.id.textInputStoreName);
        etSPhone = findViewById(R.id.textInputStorePhone);

        firebaseAuth = FirebaseAuth.getInstance();

        customer = (ToggleButton) findViewById(R.id.toggleButton);
        restaurant = (ToggleButton) findViewById(R.id.toggleButton3);
        delivery = (ToggleButton) findViewById(R.id.toggleButton2);

        customer.setChecked(true);
        restaurant.setChecked(false);
        delivery.setChecked(false);

        customer.setOnCheckedChangeListener(changeChecker);
        restaurant.setOnCheckedChangeListener(changeChecker);
        delivery.setOnCheckedChangeListener(changeChecker);
        reorganize();
    }

    ToggleButton.OnCheckedChangeListener changeChecker = new ToggleButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                if (compoundButton == customer) {
                    restaurant.setChecked(false);
                    delivery.setChecked(false);
                    toggle = compoundButton.getId();
                } else if (compoundButton == restaurant) {
                    customer.setChecked(false);
                    delivery.setChecked(false);
                    toggle = compoundButton.getId();
                } else if (compoundButton == delivery) {
                    customer.setChecked(false);
                    restaurant.setChecked(false);
                    toggle = compoundButton.getId();
                }
            }
            reorganize();
        }
    };
    public void reorganize() {
        TextView title=findViewById(R.id.title_register);
        RelativeLayout rn = findViewById(R.id.relativeStoreName);
        RelativeLayout rp = findViewById(R.id.relativeStorePhone);
        if (toggle == R.id.toggleButton) {//custom
            title.setText("消費者註冊");
            rn.setVisibility(View.GONE);
            rp.setVisibility(View.GONE);
        } else if (toggle == R.id.toggleButton2) {//register
            title.setText("店家註冊");
            rn.setVisibility(View.VISIBLE);
            rp.setVisibility(View.VISIBLE);
        } else {//delivery
            title.setText("外送員註冊");
            rn.setVisibility(View.GONE);
            rp.setVisibility(View.GONE);
        }
    }

    public void register(View v) {
        String account = etAccount.getText().toString();
        String password = etPassword.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(account, password)
                .addOnCompleteListener(this, this);
    }

    @Override
    public void onComplete(@NonNull Task task) {
        if (task.isSuccessful()) {
            Toast.makeText(this, "註冊成功", Toast.LENGTH_LONG).show();
            addUser();
        } else {
            Toast.makeText(this, "註冊失敗", Toast.LENGTH_LONG).show();
        }
    }

    public void addUser() {
        FirebaseUser curUser = FirebaseAuth.getInstance().getCurrentUser();
        String account = etAccount.getText().toString();
        String phone = etPhone.getText().toString();
        String name = etName.getText().toString();
        String storeName = etSName.getText().toString();
        String storePhone = etSPhone.getText().toString();
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference userRef = db.getReference("user");
        String className;

        if (toggle == R.id.toggleButton) {//custom
            className = "custom";
        } else if (toggle == R.id.toggleButton2) {
            className = "restaurant";
        } else {//delivery
            className = "delivery";
        }
        DatabaseReference classRef = userRef.child(className);
        DatabaseReference uidRef= classRef.child(curUser.getUid());
        Map<String, Object> user = new HashMap<>();
        user.put("account", account);
        user.put("phone", phone);
        user.put("name", name);
        if (toggle == R.id.toggleButton2) {
            user.put("storeName", storeName);
            user.put("storePhone", storePhone);
        }
        uidRef.updateChildren(user);
        finish();
    }

    public void goBack(View v) {
        Intent intent = getIntent();
        finish();
    }
}



