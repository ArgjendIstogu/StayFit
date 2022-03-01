package fiek.unipr.stayfit.exercises;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import fiek.unipr.stayfit.R;

public class ExercisesActivity extends AppCompatActivity {

    private TextView mExerciseName;
    private TextView mExerciseDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mExerciseName = (TextView)findViewById(R.id.text_exercise);
        mExerciseDescription = (TextView)findViewById(R.id.description);


        Intent intent = getIntent();
        String Title = intent.getExtras().getString("ExerciseName");
        String Description = intent.getExtras().getString("ExerciseDescription");


        mExerciseName.setText(Title);
        mExerciseDescription.setText(Description);


    }
}