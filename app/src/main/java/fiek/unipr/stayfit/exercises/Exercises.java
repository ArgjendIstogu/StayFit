package fiek.unipr.stayfit.exercises;

public class Exercises {
    private String ExerciseName;
    private String ExerciseDescription;

    private int Thumbnail;


    public Exercises(String name, String exerciseDescription, int thumbnail){

        ExerciseName = name;
        ExerciseDescription = exerciseDescription;

        Thumbnail = thumbnail;

    }


    public  String getExerciseName(){

        return ExerciseName;
    }
    public String getExerciseDescription(){
        return ExerciseDescription;
    }



    public int getThumbnail(){
        return Thumbnail;
    }
}