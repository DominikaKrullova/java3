package applicationtier.DAO.Student;

import applicationtier.model.StudentModel;

import java.util.List;

public interface StudentDao
{
    String addStudent(String id, String userId, String name, String password);
    String deleteStudent(String id, String userId, String name, String password);
    String editStudent(String id, String userId, String name, String password);
    StudentModel getStudentById(String id);
    List<StudentModel> getAllStudents();
    List<StudentModel> filterStudentsByUsername(String username);
}
