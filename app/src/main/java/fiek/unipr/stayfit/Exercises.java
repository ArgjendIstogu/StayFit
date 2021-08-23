package fiek.unipr.stayfit;


public class Exercises {
    private String ExerciseName;
    private String ExerciseDescription;
    private String ExerciseTitle;
    private String Exercise;
    private int Thumbnail;


    public Exercises(String name, String exerciseDescription, String exerciseTitle, String exercise, int thumbnail){

        ExerciseName = name;
        ExerciseDescription = exerciseDescription;
        ExerciseTitle = exerciseTitle;
        Exercise = exercise;
        Thumbnail = thumbnail;

    }


    public  String getExerciseName(){

        return ExerciseName;
    }
    public String getExerciseDescription(){
        return ExerciseDescription;
    }

    public String getExerciseTitle(){
        return ExerciseTitle;
    }

    public String getExercise(){
        return Exercise;
    }

    public int getThumbnail(){
        return Thumbnail;
    }
}
