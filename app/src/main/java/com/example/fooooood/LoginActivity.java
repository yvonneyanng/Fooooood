package com.example.fooooood;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity implements OnCompleteListener<AuthResult> {

    ToggleButton customer;
    ToggleButton restaurant;
    ToggleButton delivery;
    int toggle = 0;
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
                    restaurant.setChecked(false);
                    customer.setChecked(false);
                    toggle = compoundButton.getId();
                }
            }
        }
    };
    private EditText etAccount;
    private EditText etPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etAccount = findViewById(R.id.textInputAccount);
        etPassword = findViewById(R.id.textInputPassword);
        firebaseAuth = FirebaseAuth.getInstance();

        customer = findViewById(R.id.toggleButton);
        restaurant = findViewById(R.id.toggleButton3);
        delivery = findViewById(R.id.toggleButton2);

        toggle = customer.getId();

        customer.setChecked(true);
        restaurant.setChecked(false);
        delivery.setChecked(false);

        customer.setOnCheckedChangeListener(changeChecker);
        restaurant.setOnCheckedChangeListener(changeChecker);
        delivery.setOnCheckedChangeListener(changeChecker);
    }

    public void login(View v) {
        String email = etAccount.getText().toString();
        String password = etPassword.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, this);
    }

    public void onGo() {
        Intent intent = new Intent();
        if (toggle == R.id.toggleButton) { // customer toggle is checked
            intent.setClass(this, HomeActivity.class);
            startActivity(intent);
        } else if (toggle == R.id.toggleButton3) { // restaurant toggle is checked
            intent.setClass(this, RestaurantMainActivity.class);
            startActivity(intent);
        } else if (toggle == R.id.toggleButton2) { // delivery man toggle is checked
            intent.setClass(this, DriverHome.class);
            startActivity(intent);
        }
    }

    public void goRegister(View v) {
        Intent intent = new Intent();
        intent.setClass(this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            FirebaseUser curUser = FirebaseAuth.getInstance().getCurrentUser();
            String className;
            if (toggle == R.id.toggleButton) {//custom
                className = "custom";
            } else if (toggle == R.id.toggleButton3) {
                className = "restaurant";
            } else {//delivery
                className = "delivery";
            }
            DatabaseReference db = FirebaseDatabase.getInstance().getReference();
            db.child("user").child(className).child(curUser.getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (!task.isSuccessful()) {
                        Log.e("firebase", "Error getting data", task.getException());
                        firebaseAuth.signOut();
                    } else {
                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                        if (task.getResult().getValue() == null) {
                            Toast.makeText(LoginActivity.this, "登入失敗", Toast.LENGTH_LONG).show();
                            firebaseAuth.signOut();
                        } else {
                            onGo();
                        }
                    }
                }
            });


        } else {
            Toast.makeText(this, "登入失敗", Toast.LENGTH_LONG).show();
        }
    }
}