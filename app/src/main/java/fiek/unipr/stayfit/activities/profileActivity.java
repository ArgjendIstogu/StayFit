package fiek.unipr.stayfit.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.User;

import java.util.HashMap;
import java.util.Map;

import fiek.unipr.stayfit.R;
import fiek.unipr.stayfit.login.Login_Form;
import fiek.unipr.stayfit.login.user;

public class profileActivity extends AppCompatActivity {

    private FirebaseUser User;
    private DatabaseReference reff;

    private String userID;

    private Button logout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        logout = (Button) findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(profileActivity.this, Login_Form.class));
            }
        });


        User = FirebaseAuth.getInstance().getCurrentUser();
        reff = FirebaseDatabase.getInstance().getReference("User");
        userID=User.getUid();


        final TextView greeting = (TextView) findViewById(R.id.greeting);
        final TextView nametxt = (TextView) findViewById(R.id.name);
        final TextView emailtxt = (TextView) findViewById(R.id.email);
        final TextView usernametxt = (TextView) findViewById(R.id.username);
        final TextView gendertxt = (TextView) findViewById(R.id.gender);

        reff.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user userProfile = snapshot.getValue(user.class);

                if(userProfile !=null ){
                    String name = userProfile.fullName;
                    String email = userProfile.Email;
                    String username = userProfile.Username;
                    String gender = userProfile.Gender;

                    greeting.setText("Welcome, " + name + "!");
                    nametxt.setText(name);
                    emailtxt.setText(email);
                    usernametxt.setText(username);
                    gendertxt.setText(gender);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(profileActivity.this,"Something wrong happened!",Toast.LENGTH_LONG).show();
            }
        });




    }





}