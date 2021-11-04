package repository;

import model.Course;
import model.Student;
import model.Teacher;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class StudentRepoTest{

    @Test
    void testGetAll() {
        List<Student> students = new ArrayList<>();
        StudentRepo theStudents = new StudentRepo(students);
        assert (theStudents.getAll().size() == 0);
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
        Student std2 = new Student("Alexandru", "Lapusneanu", 2, 29, courses);
        StudentRepo theStudents = new StudentRepo(students);
        theStudents.create(std2);
        assert (theStudents.getAll().size() == 2);
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
        Student std2 = new Student("Alexandru", "Lapusneanu", 2, 29, courses);
        StudentRepo theStudents = new StudentRepo(students);
        theStudents.create(std2);

        //actual test
        theStudents.delete(std2);
        assert (theStudents.getAll().size() == 1);
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
        Student std2 = new Student("Alexandru", "Lapusneanu", 2, 29, courses);
        StudentRepo theStudents = new StudentRepo(students);

        //actual test
        theStudents.update(1, std2);
        assert(theStudents.getAll().get(0).getFirstName().equals("Alexandru"));
        assert(theStudents.getAll().get(0).getLastName().equals("Lapusneanu"));
        assert(theStudents.getAll().get(0).getStudentId() == 2);
        assert(theStudents.getAll().get(0).getTotalCredits() == 29);
    }
}