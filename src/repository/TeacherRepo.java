package repository;

import model.Teacher;

import java.util.List;

public class TeacherRepo extends InMemoryRepository<Teacher, Integer>{

    public TeacherRepo(List<Teacher> repoList) {
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
     *         this.repoList.removeIf(teach -> teach.getTeacherID() == ID)
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
     * @param teacher is an object of type Teacher
     * @return null, if the given ID does not exist, else the new, updated version is returned
     * */

    @Override
    public Teacher update(Integer ID, Teacher teacher) {
        if(this.repoList.removeIf(teach -> teach.getTeacherID() == ID)) {
            this.repoList.add(teacher);
            return teacher;
        }

        return null;
    }

}
