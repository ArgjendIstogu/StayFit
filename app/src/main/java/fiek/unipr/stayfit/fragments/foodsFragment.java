package fiek.unipr.stayfit.fragments;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import fiek.unipr.stayfit.R;
import fiek.unipr.stayfit.adapters.myadapter;


public class foodsFragment extends Fragment
{


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<datamodel> dataholder;

    public foodsFragment() {
        // Required empty public constructor
    }



    public static foodsFragment newInstance(String param1, String param2) {
        foodsFragment fragment = new foodsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_foods, container, false);
        recyclerView=view.findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataholder=new ArrayList<>();


        datamodel ob0=new datamodel(R.drawable.healthy,"The food we eat has the largest impact on our improved fitness performance. ","The key to a healthy life is to eat the right amount of calories for how active you are so you balance the energy you consume with the energy you use.Here are the best fitness foods that will get you to exercise to your fullest potential:");
        dataholder.add(ob0);


        datamodel ob1=new datamodel(R.drawable.grain,"Start With Whole-Grain Cereal","If you don’t have enough to eat before you exercise, you may not have enough gas in the tank.Have some healthy carbs at least an hour in advance of your workout.\n" +
                "\n" +
                "Try a bowl of whole-grain cereal with skim milk or some whole wheat toast or a bagel.Saturated fats take longer to digest and can affect the amount of oxygen your blood delivers to your muscles.");
        dataholder.add(ob1);

        datamodel ob2=new datamodel(R.drawable.energy,"An Energy Bar in the Afternoon","When you’re working out later in the day, have a small snack about an hour before you get started. A sports bar that has 200 calories or less is a good option.\n" +
                "\n" +
                "Look for a bar with low-fiber content, ideally 3 grams or less.On the ingredients list, keep an eye out for sugar alcohols, like sorbitol, xylitol, isomalt, and mannitol. Too much of these ingredients can give you cramps or diarrhea.");
        dataholder.add(ob2);

        datamodel ob3=new datamodel(R.drawable.chicken,"Grilled Chicken at Mealtime","When you exercise regularly, you need more protein than people who don’t, especially after a workout. Your body uses it to repair muscles, to make blood cells, and for many other purposes. For lunch or dinner, serve a leaner source, like grilled chicken or turkey, instead of something like a cheeseburger.");
        dataholder.add(ob3);

        datamodel ob4=new datamodel(R.drawable.bean,"Black Bean Burger","Whether you sometimes try a meat-free meal or stick to a full-time vegetarian diet, you can get plenty of protein (and lots of other nutrients, including fiber) from plants. Try pinto, kidney, white, or black beans, split peas, or chickpeas. Soy products, like tofu and tempeh, and nuts also have protein.");
        dataholder.add(ob4);
        datamodel ob5=new datamodel(R.drawable.berries,"A Bowl of Berries","After a workout, go for these instead of a bottle of juice. A lot of the fiber in whole fruits is lost as they become juice.\n" +
                "\n" +
                "Blueberries, in particular, have been shown to reduce muscle soreness from strenuous exercise. Cherries are another good option. But any berry will likely help.");
        dataholder.add(ob5);

        datamodel ob6=new datamodel(R.drawable.veggies,"Veggies and Hummus","When you exercise regularly, it’s all too easy to overestimate how many calories you’ve burned. An intense, hour-long bike ride could burn 590 calories.\n" +
                "\n" +
                "It’s better to snack on fruits and vegetables. After you work out, pair your produce with protein to help you feel more full and replenish muscles. Try vegetables with hummus or fruit with Greek yogurt.");
        dataholder.add(ob6);

        datamodel ob7=new datamodel(R.drawable.peanut,"Peanut Butter","While you train for a big event, the ideal post-workout snack combines protein with carbs. Revisit your childhood with a sandwich made with 2 slices of bread and 4 tablespoons of peanut butter. Of course, now that you’re an adult, you can substitute almond butter. Or try two or three cooked eggs for protein with a half a bagel.");
        dataholder.add(ob7);

        datamodel ob8=new datamodel(R.drawable.water," Water or a Sports Drink","Hydration is a must when you exercise. Often, water is all you need.If your activity is less than 60 minutes, sip small amounts of water often to replace lost fluids. But when your workout is intense and lasts longer than an hour, a sports drink could help your hydration and your performance. Just keep an eye on the calories and sugar, like with any other drink, especially if you want to lose weight.");
        dataholder.add(ob8);




        recyclerView.setAdapter(new myadapter(dataholder));

        return view;
    }
}