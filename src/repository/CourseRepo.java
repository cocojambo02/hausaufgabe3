package repository;

import model.Course;

import java.util.List;

public class CourseRepo extends InMemoryRepository<Course, Integer>{

    public CourseRepo(List<Course> repoList) {
        super(repoList);
    }

    /**
     *     Updates a given object from the repo by ID.
     *
     *     <br>
     *     <br>
     *
     *     PRE:
     *     <br>
     *          An int is given as parameter for the variable ID, while for the object you want
     *     to update, it is given the new, updated object.
     *
     *     <br>
     *     <br>
     *
     *     EXECUTION:
     *     <br>
     *          If the ID exists, the object at ID is modified with all the new values and returned, else NULL is
     *          returned.
     *
     *     <br>
     *     <br>
     *
     *     The following snippet looks the ID up, and if fount deletes it and returns true.
     *
     *     <br>
     *     <br>
     *
     *     <code>
     *         this.repoList.removeIf(course1 -> course1.getCourseID() == ID)
     *     </code>
     *
     *     <br>
     *     <br>
     *
     *     POST:
     *     <br>
     *          After the execution, the variable chosen by ID is updated with the object given as parameter
     *
     * @param ID is an int
     * @param course is an Object of type Course
     * @return null, if the given ID does not exist, else the new, updated version is returned
     * */
    @Override
    public Course update(Integer ID, Course course) {
        Course result = null;
        if (this.repoList.removeIf(course1 -> course1.getCourseID() == ID)) {
            this.repoList.add(course);
            result = course;
        }

        return result;
    }
}
