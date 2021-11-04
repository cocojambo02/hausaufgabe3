package model;

import java.util.List;

/**
 * Is a modell class for the InMemoryRepository template
 * */
public class Teacher extends Person{
    public List<Course> courses;
    public int teacherID;

    public Teacher(int teacherID, String firstName, String lastName, List<Course> courses) {
        super(firstName, lastName);
        this.courses = courses;
        this.teacherID = teacherID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
