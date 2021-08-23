package fiek.unipr.stayfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class fitActivity extends AppCompatActivity {

    ConstraintLayout fitActivity;

    RecyclerView myrecyclerView;
    RecyclerViewAdapter myAdapter;

    List<Exercises> exercise;


    RecyclerView workoutRecycler;
    WorkoutsAdapter workoutsAdapter;
    List<Workouts> workoutsList;



    public void displayToast(View v){
        Toast.makeText(fitActivity.this,"Do these workouts Daily",
                Toast.LENGTH_SHORT).show();

    }

    public void buttonClick(View v){
        Snackbar.make(fitActivity,"Important Gym Routines",Snackbar.LENGTH_SHORT)
                .setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setActionTextColor(R.color.white).show();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fitActivity = findViewById(R.id.fitActivity);


        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);


        workoutRecycler = findViewById(R.id.workout_items);


        workoutsList = new ArrayList<>();
        workoutsList.add(new Workouts("On a bar or assisted pullup machine," +
                " place your hands so they are each 6-8 inches beyond your shoulder width," +
                " fingers facing away from you. Inhale,then exhale as you pull your body up, " +
                "chin above the bar. Inhale as you lower down with control.", "Wide Grip Pull Ups",
                R.drawable.pullup, R.drawable.pullup));
        workoutsList.add(new Workouts("Set your feet hip-to-shoulder-width apart." +
                " Holding dumbbells above your shoulders, elbows bent and close to your sides," +
                " inhale as you sit back deeply while keeping your chest high, into a squat. " +
                "Exhale and press the floor away to come back to stand",
                "Dumbell Front Squats", R.drawable.squat, R.drawable.squat));
        workoutsList.add(new Workouts("Begin bending down by sending your hips back so" +
                " your torso is hinged at the waist; lightly bend your knees. Let the barbell hang " +
                "in front of your legs, fingers facing them, but don’t allow your shoulders to droop " +
                "forward. Inhale, then exhale as you row the barbell up,pulling your shoulder blades" +
                " together at the top. Slowly lower it back to start.",
                "Barbell Bentover Row", R.drawable.barbell, R.drawable.barbell));
        workoutsList.add(new Workouts("Sit on the floor with your back perpendicular to" +
                " a weight bench, and a barbell resting in your hip crease. Rest your shoulders " +
                "against the bench and bend your knees so your feet are on the floor. With your" +
                " hands holding the barbell in place, inhale, then exhale as you press your hips" +
                " toward the ceiling, such that your body from knees to shoulders forms a flat " +
                "tabletop position and your feet are flat on the ground directly below your knees." +
                " Inhale as you crease your hips to lower your butt back down.",
                "Barbell Hip Thrust", R.drawable.hip, R.drawable.hip));


        setWorkoutRecycler(workoutsList);







        exercise = new ArrayList<>();
        exercise.add(new Exercises("Deadlift Exercise",
                "Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps" +
                        " the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount" +
                        " of testosterone (a muscle-building hormone) " +
                        "into the bloodstream. For this reason, the deadlift is a great cornerstone for any fitness plan." +
                        "1 tablespoon green chilli sauce", "Method",
                "Deadlift Exercise\",\n" +
                        "Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                        "  the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                        "  of testosterone (a muscle-building hormone!\n", R.drawable.deadlift));

        exercise.add(new Exercises("Back Squat", "Deadlift Exercise\",\n" +
                "                \"Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                "                        \" the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                "                        \" of testosterone (a muscle-building hormone" +
                "Canola or vegetable oil, for frying", "Method", "\n" +
                "Deadlift Exercise,\n" +
                "  Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                "    the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                "   of testosterone (a muscle-building hormone!)", R.drawable.back));
        exercise.add(new Exercises("Bench Press", "Deadlift Exercise\",\n" +
                "   Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                "   the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                "  of testosterone (a muscle-building hormone"
                , "Method",
                "Deadlift Exercise\",\n" +
                        " Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                        "   the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                        "  of testosterone (a muscle-building hormone", R.drawable.bench));
        exercise.add(new Exercises("Dumbbell Romanian Deadlift", "Deadlift Exercise\",\n" +
                "        Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                "         the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                "         of testosterone (a muscle-building hormone", "Method",
                "Deadlift Exercise\",\n" +
                        "Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                        " the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                        " of testosterone (a muscle-building hormone.", R.drawable.dumbell));
        exercise.add(new Exercises("Kettlebell swing", "Deadlift Exercise\",\n" +
                "        Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                "         the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                "         of testosterone (a muscle-building hormone"
                , "Method",
                "Deadlift Exercise\",\n" +
                        "   Arguably the king of all exercises, the deadlift hits every major muscle group hard, and is perhaps\" +\n" +
                        "   the greatest test of strength there is. Because of all the muscles involved, it releases a huge amount\" +\n" +
                        "   of testosterone (a muscle-building hormone", R.drawable.kittlebell));


        myrecyclerView = (RecyclerView) findViewById(R.id.recyclerView_id);

        myAdapter = new RecyclerViewAdapter(this, exercise);

        myrecyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        myrecyclerView.setAdapter(myAdapter);


        Button picture = findViewById(R.id.picture);

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new PictureFragment()).commit();
            }
        });

    }

    private void setWorkoutRecycler(List<Workouts> workoutsDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        workoutRecycler.setLayoutManager(layoutManager);
        workoutsAdapter = new WorkoutsAdapter(this, workoutsDataList);
        workoutRecycler.setAdapter(workoutsAdapter);

    }

    String url = "https://images.pexels.com/photos/2261485/pexels-photo-2261485.jpeg?cs=srgb&dl=pexels-victor-freitas-2261485.jpg&fm=jpg";
    ImageView imageView;

    public void Loading(View view){
        fitActivity.DownloadImage downloadImage= new DownloadImage();
        imageView = findViewById(R.id.imgView);

        try {
            Bitmap bitmap = downloadImage.execute(url).get();

            imageView.setImageBitmap(bitmap);



        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class DownloadImage extends AsyncTask<String, Void,Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = null;

            URL url;
            HttpURLConnection httpURLConnection;

            InputStream in;

            try {
                url = new URL(strings[0]);

                httpURLConnection = (HttpURLConnection) url.openConnection();
                in = httpURLConnection.getInputStream();
                bitmap = BitmapFactory.decodeStream(in);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmap;
        }
    }



}