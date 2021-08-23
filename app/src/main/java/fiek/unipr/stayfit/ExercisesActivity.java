package fiek.unipr.stayfit;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import fiek.unipr.stayfit.R;

public class ExercisesActivity extends AppCompatActivity {

    private TextView mExerciseName;
    private TextView mExerciseDescription;
    private TextView mExerciseTitle;
    private TextView mExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mExerciseName = (TextView)findViewById(R.id.text_exercise);
        mExerciseDescription = (TextView)findViewById(R.id.description);
        mExerciseTitle = (TextView)findViewById(R.id.method);
        mExercise = (TextView)findViewById(R.id.desc);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("ExerciseName");
        String Description = intent.getExtras().getString("ExerciseDescription");
        String ExerciseTitle = intent.getExtras().getString("ExerciseTitle");
        String Exercise = intent.getExtras().getString("Exercise");

        mExerciseName.setText(Title);
        mExerciseDescription.setText(Description);
        mExerciseTitle.setText(ExerciseTitle);
        mExercise.setText(Exercise);

    }
}