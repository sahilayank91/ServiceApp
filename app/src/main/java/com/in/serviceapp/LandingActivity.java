package com.in.serviceapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.in.serviceapp.Model.User;

public class LandingActivity extends AppCompatActivity {

    private EditText name,email,address,mobileNo;
    private Button submit;
    private DatabaseReference databaseReference;
    private TextView skip;
    private String phone;
    public static final String MyPREFERENCES = "MyPrefs" ;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        name  = findViewById(R.id.name);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        mobileNo = findViewById(R.id.mobile);
        skip = findViewById(R.id.skip);
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        phone = getIntent().getStringExtra("phone");
        mobileNo.setText(phone);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String username = name.getText().toString();
                    String useremail = email.getText().toString();
                    String useraddress  = address.getText().toString();
                    String usermobileNo = mobileNo.getText().toString();
                    String userId = databaseReference.push().getKey();
                    User user  = new User(username,userId,useremail,useraddress,usermobileNo,50);
                    databaseReference.child(userId).setValue(user);

                sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("userId",userId);
                editor.putString("username",username);
                editor.putString("useraddress",useraddress);
                editor.putString("mobile",usermobileNo);
                editor.putString("useremail",useremail);
                editor.commit();


                Intent intent = new Intent(LandingActivity.this,MainActivity.class);
                intent.putExtra("phone",phone);
                startActivity(intent);
                finish();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LandingActivity.this,MainActivity.class);
                intent.putExtra("phone",phone);
                startActivity(intent);
                finish();
            }
        });


    }
}
