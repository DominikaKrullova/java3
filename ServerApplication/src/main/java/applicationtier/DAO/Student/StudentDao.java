package applicationtier.DAO.Student;

import applicationtier.model.StudentModel;

import java.util.List;

public interface StudentDao
{
    StudentModel addStudent(StudentModel studentModel);
    String deleteStudent(String id);
    String editStudent(StudentModel studentModel);
    StudentModel getStudentById(String id);
    List<StudentModel> getAllStudents();
    List<StudentModel> filterStudentsByUsername(String username);
}
