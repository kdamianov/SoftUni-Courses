package exercise;

import java.io.*;

public class P11SerializeCustomObject {
    public static void main(String[] args) throws IOException {

        Course course = new Course();
        course.name = "Java Advanced September 2022";
        course.numberOfStudents = 250;

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("exercise/courses.ser"));
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("exercise/courses.ser"));
    }
}
