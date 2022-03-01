package fiek.unipr.stayfit.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fiek.unipr.stayfit.R;
import fiek.unipr.stayfit.workouts.WorkoutDetails;
import fiek.unipr.stayfit.workouts.Workouts;

public class WorkoutsAdapter  extends RecyclerView.Adapter<WorkoutsAdapter.WorkoutsViewHolder> {

    Context context;

    public WorkoutsAdapter(Context context, List<Workouts> workoutsList) {
        this.context = context;
        this.workoutsList = workoutsList;
    }

    List<Workouts> workoutsList;

    @NonNull
    @Override
    public WorkoutsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.workout_items,parent,false );
        return new  WorkoutsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutsAdapter.WorkoutsViewHolder holder, int position) {
        holder.name.setText(workoutsList.get(position).getName());
        holder.name.setText(workoutsList.get(position).getDescripton());
        holder.bg.setBackgroundResource(workoutsList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, WorkoutDetails.class);
                i.putExtra("name",workoutsList.get(position).getName());
                i.putExtra("image",workoutsList.get(position).getBigimageurl());
                i.putExtra("description",workoutsList.get(position).getDescripton());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return workoutsList.size();
    }


    public static class WorkoutsViewHolder extends RecyclerView.ViewHolder{

        TextView name,description,img;
        ConstraintLayout bg;

        public WorkoutsViewHolder(@NonNull  View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.workoutName);
            description = itemView.findViewById(R.id.workoutDescription);
            bg = itemView.findViewById(R.id.workout_layout);

        }
    }
}