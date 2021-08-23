package fiek.unipr.stayfit;


import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {

    private Context mContext;
    private List<Exercises> mData;

    public RecyclerViewAdapter(Context mContext, List<Exercises> mData){
        this.mContext = mContext;
        this.mData = mData;
    }



    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view ;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.cardview_exercise,viewGroup,false);
        return  new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, final int i) {

        myHolder.exerciseTitle.setText(mData.get(i).getExerciseName());
        myHolder.img_thumbnail.setImageResource(mData.get(i).getThumbnail());
        myHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ExercisesActivity.class);

                intent.putExtra("ExerciseName",mData.get(i).getExerciseName());
                intent.putExtra("ExerciseDescription",mData.get(i).getExerciseDescription());
                intent.putExtra("ExerciseTitle",mData.get(i).getExerciseTitle());
                intent.putExtra("Exercise",mData.get(i).getExercise());
                intent.putExtra("Thumbnail",mData.get(i).getThumbnail());

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView exerciseTitle;
        CardView cardView;
        ImageView img_thumbnail;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            exerciseTitle = (TextView)itemView.findViewById(R.id.exercise_text);
            img_thumbnail = (ImageView)itemView.findViewById(R.id.exerciseimg_id);
            cardView = (CardView)itemView.findViewById(R.id.cardview_id);


        }
    }
}