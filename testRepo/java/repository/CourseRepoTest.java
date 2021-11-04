package repository;

import model.Course;
import model.Student;
import model.Teacher;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class CourseRepoTest {


    @Test
    void getAll() {

        List<Course> courses = new ArrayList<>();
        CourseRepo theCourses = new CourseRepo(courses);
        assert (theCourses.getAll().size() == 0);

    }


    @Test
    void create() {

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
        Course  crs2 = new Course(2, "DSA", tch1, 6, students,6);


        //actual tests
        CourseRepo theCourses = new CourseRepo(courses);
        theCourses.create(crs2);
        assert (theCourses.getAll().size() == 2);
    }


    @Test
    void delete() {

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
        Course  crs2 = new Course(2, "DSA", tch1, 6, students,6);
        CourseRepo theCourses = new CourseRepo(courses);
        theCourses.create(crs2);


        //actual test
        assert (theCourses.getAll().size() == 2);
        theCourses.delete(crs2);
        assert (theCourses.getAll().size() == 1);
    }

    @Test
    void update() {

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
        CourseRepo theCourses = new CourseRepo(courses);

        //actual test
        Course  crs2 = new Course(2, "DSA", tch1, 6, students,6);
        theCourses.update(1, crs2);
        assert (theCourses.getAll().size() == 1);
        assert (theCourses.getAll().get(0).getCourseID() == 2);
        assert (theCourses.getAll().get(0).getName().equals("DSA"));
        assert (theCourses.getAll().get(0).getMaxEnrollment() == 6);
        assert (theCourses.getAll().get(0).getCredits() == 6);

    }
}