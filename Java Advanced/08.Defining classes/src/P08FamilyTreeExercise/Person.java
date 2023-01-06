package P08FamilyTreeExercise;

public class Person {
    private String personName;
    private String personBirthday;
    private Parent parent;
    private Child child;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonBirthday() {
        return personBirthday;
    }

    public void setPersonBirthday(String personBirthday) {
        this.personBirthday = personBirthday;
    }
}
