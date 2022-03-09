package fiek.unipr.stayfit.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import fiek.unipr.stayfit.activities.MainActivity;
import fiek.unipr.stayfit.R;

public class Signup_Form extends AppCompatActivity {

    EditText txt_fullname,txt_username,txt_email,txt_password;
    Button btn_register;
    RadioButton btnMale,btnFemale;
    DatabaseReference databaseReference;
    String gender = "";
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);
        getSupportActionBar().setTitle("Signup Form");

        txt_fullname = (EditText) findViewById(R.id.txt_fullName);
        txt_username = (EditText) findViewById(R.id.txt_username);
        txt_email = (EditText) findViewById(R.id.txt_email);
        txt_password = (EditText) findViewById(R.id.txt_password);
        btn_register = (Button) findViewById(R.id.btn_register);
        btnMale = (RadioButton) findViewById(R.id.btnMale);
        btnFemale = (RadioButton) findViewById(R.id.btnFemale);

        databaseReference = FirebaseDatabase.getInstance().getReference("User");
        firebaseAuth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String fullName =  txt_fullname.getText().toString();
                String username =  txt_username.getText().toString();
                String email =  txt_email.getText().toString();
                String password =  txt_password.getText().toString();

                if(btnMale.isChecked()){
                    gender = "Male";
                }
                if(btnFemale.isChecked()){
                    gender = "Female";
                }


                if(TextUtils.isEmpty(fullName)){
                    Toast.makeText(Signup_Form.this, "Please Enter Full Name", Toast.LENGTH_LONG).show();
                    txt_fullname.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(username)){
                    Toast.makeText(Signup_Form.this, "Please Enter Username", Toast.LENGTH_LONG).show();
                    txt_username.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Signup_Form.this, "Please Enter Email", Toast.LENGTH_LONG).show();
                    txt_email.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Signup_Form.this, "Please Enter Password", Toast.LENGTH_LONG).show();
                    txt_password.requestFocus();
                    return;
                }
                if(password.length()<6){
                    txt_password.setError("Min password length should be 6 characters!");
                    txt_password.requestFocus();
                    return;
                }



                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Signup_Form.this,new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task){
                        if(task.isSuccessful()){

                            user information = new user(
                                    fullName,
                                    username,
                                    email,
                                    gender
                            );

                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(information).addOnCompleteListener(new OnCompleteListener<Void> () {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(Signup_Form.this, "Registration Completed", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                }
                            });


                        } else{
                            Toast.makeText(Signup_Form.this, "Failed to Register! Try again!", Toast.LENGTH_LONG).show();



                        }
                    }
                });




            }
        });










    }
}