package com.in.serviceapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText email;
    private Button verify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        email = (EditText)findViewById(R.id.forgot_email);
        verify = (Button)findViewById(R.id.forgot_button);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                String emailAddress = email.getText().toString();
                if(emailAddress.equals(null)){
                    Toast.makeText(ForgotPasswordActivity.this,"Enter the Email for Password Resetting.",Toast.LENGTH_SHORT).show();
                }else {
                    auth.sendPasswordResetEmail(emailAddress)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Log.d("PASSWORD RESET", "Email sent.");
                                        Toast.makeText(ForgotPasswordActivity.this, "A Password Reset Mail has been sent to " + email.getText().toString(), Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(ForgotPasswordActivity.this,LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });

                }
            }
        });

    }
}
