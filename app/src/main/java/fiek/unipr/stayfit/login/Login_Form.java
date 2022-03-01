package fiek.unipr.stayfit.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import fiek.unipr.stayfit.MainActivity;
import fiek.unipr.stayfit.R;

public class Login_Form extends AppCompatActivity implements View.OnClickListener {

    private EditText txt_email, txt_password;
    private Button LogIn;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login Form");


        LogIn = (Button) findViewById(R.id.btn_login);
        LogIn.setOnClickListener(Login_Form.this);

        txt_email = (EditText) findViewById(R.id.email);
        txt_password = (EditText) findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
    }
    public void btn_signUpForm(View view){
        startActivity(new Intent(getApplicationContext(),Signup_Form.class));
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){


            case R.id.btn_login:
                userLogin();
                break;
        }
    }

    private void userLogin(){
        String email = txt_email.getText().toString().trim();
        String password = txt_password.getText().toString().trim();

        if(email.isEmpty()){
            txt_email.setError("Email is required!");
            txt_email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            txt_email.setError("Please enter a valid Email!");
            txt_email.requestFocus();
            return;
        }

        if(password.isEmpty()){
            txt_password.setError("Password is required!");
            txt_password.requestFocus();
            return;
        }

        if(password.length() < 6){
            txt_password.setError("Min password length should be 6 characters!");
            txt_password.requestFocus();
            return;
        }


        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                }
                else{
                    Toast.makeText(Login_Form.this, "Failed to login! Please check your credentials!", Toast.LENGTH_LONG).show();
                }
            }
        });


    }





}