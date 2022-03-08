package fiek.unipr.stayfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;


import android.os.Bundle;
import android.view.WindowManager;



import com.google.android.material.bottomnavigation.BottomNavigationView;

import fiek.unipr.stayfit.fragments.foodsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this,  R.id.fragmentContainerView);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}