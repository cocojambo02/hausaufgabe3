package repository;

import model.Course;
import model.Student;
import model.Teacher;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class TeacherRepoTest {

    @Test
    void testGetAll() {
        List<Teacher> teachers = new ArrayList<>();
        TeacherRepo theTeachers = new TeacherRepo(teachers);
        assert (theTeachers.getAll().size() == 0);
    }

    @Test
    void testCreate() {
        //basically just data for the tests
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        Teacher tch1 = new Teacher(1, "Andru", "Alex" ,courses);
        Course crs1 = new Course(1, "ASC", tch1, 6, students,6);
        courses.add(crs1);
        tch1.setCourses(courses);
        Student std1 = new Student("Cosmin", "Ioan", 1, 29, courses);
        students.add(std1);
        crs1.setStudentsEnrolled(students);

        //actual test
        Teacher tch2 = new Teacher(2, "Cristea", "Diana" ,courses);
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(tch1);
        TeacherRepo theTeachers = new TeacherRepo(teachers);
        theTeachers.create(tch2);
        assert (theTeachers.getAll().size() == 2);
    }

    @Test
    void testDelete() {
        //basically just data for the tests
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        Teacher tch1 = new Teacher(1, "Andru", "Alex" ,courses);
        Course crs1 = new Course(1, "ASC", tch1, 6, students,6);
        courses.add(crs1);
        tch1.setCourses(courses);
        Student std1 = new Student("Cosmin", "Ioan", 1, 29, courses);
        students.add(std1);
        crs1.setStudentsEnrolled(students);

        //actual test
        Teacher tch2 = new Teacher(2, "Cristea", "Diana" ,courses);
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(tch1);
        TeacherRepo theTeachers = new TeacherRepo(teachers);
        theTeachers.create(tch2);
        theTeachers.delete(tch2);
        assert (theTeachers.getAll().size() == 1);
    }

    @Test
    void testUpdate() {
        //basically just data for the tests
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        Teacher tch1 = new Teacher(1, "Andru", "Alex" ,courses);
        Course crs1 = new Course(1, "ASC", tch1, 6, students,6);
        courses.add(crs1);
        tch1.setCourses(courses);
        Student std1 = new Student("Cosmin", "Ioan", 1, 29, courses);
        students.add(std1);
        crs1.setStudentsEnrolled(students);
        Teacher tch2 = new Teacher(2, "Cristea", "Diana" ,courses);
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(tch1);
        TeacherRepo theTeachers = new TeacherRepo(teachers);

        //actual test
        theTeachers.update(1,tch2);
        assert (theTeachers.getAll().get(0).getTeacherID() == 2);
        assert (theTeachers.getAll().get(0).getFirstName().equals("Cristea"));
        assert (theTeachers.getAll().get(0).getLastName().equals("Diana"));
    }
}