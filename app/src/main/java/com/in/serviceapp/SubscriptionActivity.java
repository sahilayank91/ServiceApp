package com.in.serviceapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SubscriptionActivity extends AppCompatActivity {

    TextView breakfast,lunch,dinner;
    ImageButton break_add,break_min;
    ImageButton lunch_add,lunch_min;
    ImageButton dinner_add,dinner_min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription_detail);
        break_add=(ImageButton)findViewById(R.id.breakfast_add);
        break_min = (ImageButton)findViewById(R.id.breakfast_minus);
        breakfast = (TextView)findViewById(R.id.breakfast_count);

      /*  break_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(breakfast.getText().toString());
                num= num+1;
                breakfast.setText(num);
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
                    breakfast.setText(num);
                }
            }
        });*/



    }
}
