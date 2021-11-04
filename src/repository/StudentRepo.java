package repository;

import model.Student;

import java.util.List;

public class StudentRepo extends InMemoryRepository<Student, Integer>{

    public StudentRepo(List<Student> repoList) {
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
     *         this.repoList.removeIf(stud -> stud.getStudentId() == ID)
     *     </code>
     *
     *     <br>
     *     <br>
     *
     *     POST:
     *     <br>
     *          After the execution, the variable chosen by ID is updated with the object given as parameter
     *
     *@param ID is an int
     *@param student an object of type Student
     *@return null, if the given ID does not exist, else the new, updated version is returned
     * */
    @Override
    public Student update(Integer ID, Student student) {
        if(this.repoList.removeIf(stud -> stud.getStudentId() == ID)) {
            this.repoList.add(student);
            return student;
        }

        return null;
    }


}
