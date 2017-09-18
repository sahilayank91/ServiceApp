package com.in.serviceapp;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SubscriptionActivity extends AppCompatActivity implements View.OnClickListener {

    TextView breakfast,lunch,dinner;
    ImageButton break_add,break_min;
    ImageButton lunch_add,lunch_min;
    ImageButton dinner_add,dinner_min;

    @Override
    public void onBackPressed() {

            super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setEnabled(true);
        collapsingToolbar.setTitle("Subscribe");
        break_add=(ImageButton)findViewById(R.id.breakfast_add);
        break_min = (ImageButton)findViewById(R.id.breakfast_minus);
        breakfast = (TextView)findViewById(R.id.breakfast_count);
        lunch_add = (ImageButton)findViewById(R.id.lunch_add);
        lunch_min =(ImageButton)findViewById(R.id.lunch_minus);
        dinner_add = (ImageButton)findViewById(R.id.dinner_add);
        dinner_min = (ImageButton)findViewById(R.id.dinner_minus);
        lunch = (TextView)findViewById(R.id.lunch_count);
        dinner = (TextView)findViewById(R.id.dinner_count);
        break_min.setEnabled(false);
        lunch_min.setEnabled(false);
        dinner_min.setEnabled(false);


        dinner_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num =Integer.parseInt(lunch.getText().toString());
                num = num+1;
                dinner.setText(String.valueOf(num));
                dinner_min.setEnabled(true);
            }
        });
        dinner_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(lunch.getText().toString());
                if(num==0){
                    dinner_min.setEnabled(false);
                }else{
                    num = num-1;
                    dinner.setText(String.valueOf(num));
                }
            }
        });
        lunch_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num =Integer.parseInt(lunch.getText().toString());
                num = num+1;
                lunch.setText(String.valueOf(num));
                lunch_min.setEnabled(true);
            }
        });

        lunch_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(lunch.getText().toString());
                if(num==0){
                    lunch_min.setEnabled(false);
                }else{
                    num = num-1;
                    lunch.setText(String.valueOf(num));
                }
            }
        });

        break_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(breakfast.getText().toString());
                num= num+1;
                breakfast.setText(String.valueOf(num));
                break_min.setEnabled(true);
            }
        });

        break_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(breakfast.getText().toString());
                if(num==0){
                    break_min.setEnabled(false);
                }else {
                    num = num - 1;
                    breakfast.setText(String.valueOf(num));
                }
            }
        });



    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.home){
            startActivity(new Intent(SubscriptionActivity.this,MainActivity.class));
            finish();
        }
    }
}
