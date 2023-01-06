package P07GoogleExercise;

public class Parent {
    private String parentName;
    private String parentBirthday;

    public Parent(String parentName, String birthday) {
        this.parentName = parentName;
        this.parentBirthday = birthday;
    }

    @Override
    public String toString() {
        return parentName + " " + parentBirthday;
    }
}
