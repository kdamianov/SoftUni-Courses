package workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }
    public boolean removeExercise (String name, String muscle) {
        return this.exercises.removeIf(e -> e.getName().contains(name));
    }
    public Exercise getExercise (String name, String muscle) {
        return exercises.stream()
                .filter(e -> e.getName().equals(name) && e.getMuscle().equals(muscle))
                .findAny()
                .orElse(null);
    }
    public Exercise getMostBurnedCaloriesExercise() {
        return Collections.max(exercises, Comparator.comparingInt(Exercise::getBurnedCalories));
    }
    public int getExerciseCount() {
        return this.exercises.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: ").append(this.type).append(System.lineSeparator());
        for (Exercise exercise : exercises) {
                    sb.append(exercise)
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
