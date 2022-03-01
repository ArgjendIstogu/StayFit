package fiek.unipr.stayfit.workouts;

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

import fiek.unipr.stayfit.R;
import fiek.unipr.stayfit.adapters.ImageAdapter;
import fiek.unipr.stayfit.adapters.RecyclerViewAdapter;
import fiek.unipr.stayfit.adapters.WorkoutsAdapter;
import fiek.unipr.stayfit.exercises.Exercises;
import fiek.unipr.stayfit.fragments.PictureFragment;


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
                "The deadlift is a great exercise to really work the entire back of your body—including your hamstrings, butt, and back. And there are tons of deadlift variations, which makes it easy to choose the right version that works for you.The deadlift targets multiple muscle groups in a single lift, offering more bang for your buck than an isolation exercise.This move also relies on core strength to stabilize your body throughout the lift, which means you’ll be working your abs on top of everything else. Building muscle helps increase your metabolism, too, which in turn helps you lose more fat long-term.\n" +
                        "\n" +
                        "Deadlift training produces a lot of muscle activation in your lower body", R.drawable.deadlift));

        exercise.add(new Exercises("Back Squat", "Place a barbell in a rack just below shoulder-height. Dip under the bar to put it behind the neck across the top of the back, and grip the bar with the hands wider than shoulder-width apart. Lift the chest up and squeeze the shoulder blades together to keep the straight back throughout the entire movement. Stand up to bring the bar off the rack and step backwards, then place the feet so that they are a little wider than shoulder-width apart. Sit back into hips and keep the back straight and the chest up, squatting down so the hips are below the knees. From the bottom of the squat, press feet into the ground and push hips forward to return to the top of the standing position.", R.drawable.back));
        exercise.add(new Exercises("Bench Press", "First, before you get underneath the bar you need to make sure you have the strength on your chest, shoulders and triceps to manage the weight of the empty bar. The Olympic barbell, which is the standard one used to bench press in most decent gyms, weighs exactly 20kg. That may or may not sound like a lot depending on your weight training experience. If it does, then you need to get up to speed with press-ups first.\n" +
                "\nStart in the press-up position with your hands underneath your shoulders, your core tight, and your toes together so your body forms a straight line from head to heels. Bend your elbows to lower your chest down to the floor, pause for a second at the bottom position, then press back powerfully to the start (but don’t lock out your arms at the top).", R.drawable.bench));
        exercise.add(new Exercises("Dumbbell Romanian Deadlift", "The dumbbell Romanian deadlift is one of the most popular exercises on the gym floor — with good reason. When it comes to the plethora of benefits the humble lower-body move offers, it's not hard to see why it's such a fave.\n" +
                "\n" +
                "'Romanian deadlifts are probably my favourite movement to programme and to do myself,' says Jake van't Hoff, founder and coach at Beyond Fitness Coaching. 'When done correctly, the exercise is a phenomenal glute movement, hits your hamstrings really well and builds fantastic overall strength.Bonus: the DB Romanian deadlift (or RDL) also requires minimal equipment – just a pair of dumbbells and enough space to comfortably hinge at the hips.", R.drawable.dumbell));
        exercise.add(new Exercises("Kettlebell swing", "There’s no one type of weight that’s better than all the others, but it is fair to say that the kettlebell is the most under-appreciated member of the free-weight family. You can use kettlebells for just about anything, from high-rep HIIT workouts to low-rep heavyweight slogs, and they’re especially good for compound moves like swings and squats.\n" +
                "\n" +
                "Next time you go the gym, grab a kettlebell and try some of these beginner, intermediate and advanced exercises.Before you dive into the exercises, there’s a kettlebell-specific position to familiarise yourself with – the rack. It’s the finishing position of the technical, difficult-to-master clean, and the starting position for presses. Hold the handle with your hand by your chin, elbow out to the side and the bell resting on the top of your forearm by your armpit.", R.drawable.kittlebell));


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