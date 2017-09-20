package com.in.serviceapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.in.serviceapp.Model.Subscription;
import com.in.serviceapp.Model.User;

import java.util.HashMap;
import java.util.Map;

public class SubscriptionActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    private TextView breakfast,lunch,dinner;
    private ImageButton break_add,break_min;
    private ImageButton lunch_add,lunch_min;
    private ImageButton dinner_add,dinner_min;
    private CardView submit;
    private Button but;
    private FirebaseUser firebaseUser;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase firebaseDatabase;
    private String userId;
    private DatabaseReference mDatabase;
    private SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;

    public Spinner breakf,lunchf,dinnerf;

    public User users;
    public String[] days = {"7 Days","15 Days","30 Days"};
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
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        userId = sharedPreferences.getString("userId",null);
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
        submit = findViewById(R.id.submit_cart);
        break_min.setEnabled(false);
        lunch_min.setEnabled(false);
        dinner_min.setEnabled(false);
        breakf  = findViewById(R.id.breakfase_week);
        lunchf = findViewById(R.id.lunch_week);
        dinnerf = findViewById(R.id.dinner_week);
        but = findViewById(R.id.button_submit_cart);
        breakf.setOnItemSelectedListener(this);
        lunchf.setOnItemSelectedListener(this);
        dinnerf.setOnItemSelectedListener(this);

        ArrayAdapter selections = new ArrayAdapter(this,android.R.layout.simple_spinner_item,days);

        selections.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        breakf.setAdapter(selections);
        lunchf.setAdapter(selections);
        dinnerf.setAdapter(selections);


        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();


        //FOR PERSISTENCE OF DATA

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("WALLET UPDATIOIN","updating");
                updateWallet();
            }
        });
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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        
    }

    private void updateWallet(){
            DatabaseReference user = FirebaseDatabase.getInstance().getReference();

        int nb = Integer.parseInt(breakfast.getText().toString());
        int nl = Integer.parseInt(lunch.getText().toString());
        int nd = Integer.parseInt(dinner.getText().toString());

        int b = (breakf.getSelectedItemPosition()+1)*7*nb;
        int l = (lunchf.getSelectedItemPosition()+1)*7*nl;
        int d = (dinnerf.getSelectedItemPosition()+1)*7*nd;

        HashMap<String, Integer> result = new HashMap<>();
            result.put("breakfast_sub",(b));
            result.put("lunch_sub",(l));
            result.put("dinner_sub",(d));
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("/users/" +userId +"/break_days" ,b);
            childUpdates.put("/users/" +userId +"/lunch_days" ,l);
            childUpdates.put("/users/" +userId +"/dinner_days" ,d);

        user.updateChildren(childUpdates);


        Intent intent = new Intent(SubscriptionActivity.this,MainActivity.class);
        startActivity(intent);
        finish();





    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
