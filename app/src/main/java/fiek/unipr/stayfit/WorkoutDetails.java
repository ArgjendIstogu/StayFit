package fiek.unipr.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WorkoutDetails extends AppCompatActivity {

    ImageView img;
    TextView proName, proDescription;
    String name,description;

    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();

        name = i.getStringExtra("name");
        description = i.getStringExtra("description");
        image = i.getIntExtra("image",R.drawable.first);

        proName = findViewById(R.id.workoutName);
        proDescription = findViewById(R.id.workoutDescription);
        img = findViewById(R.id.big_image);

        proName.setText(name);
        proDescription.setText(description);

        img.setImageResource(image);




    }
}