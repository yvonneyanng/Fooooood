
package com.example.fooooood;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class LoginActivity extends AppCompatActivity {

    ToggleButton customer;
    ToggleButton restaurant;
    ToggleButton delivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        customer = (ToggleButton) findViewById(R.id.toggleButton);
        restaurant = (ToggleButton) findViewById(R.id.toggleButton2);
        delivery = (ToggleButton) findViewById(R.id.toggleButton3);

        customer.setOnCheckedChangeListener(changeChecker);
        restaurant.setOnCheckedChangeListener(changeChecker);
        delivery.setOnCheckedChangeListener(changeChecker);
    }

    ToggleButton.OnCheckedChangeListener changeChecker = new ToggleButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b){
                if (compoundButton == customer) {
                    restaurant.setChecked(false);
                    delivery.setChecked(false);
                }
                if (compoundButton == restaurant) {
                    customer.setChecked(false);
                    delivery.setChecked(false);
                }
                if (compoundButton == delivery) {
                    restaurant.setChecked(false);
                    customer.setChecked(false);
                }
            }
        }
    };

    public void toHome(View view) {
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
}