package applicationtier.service.api;

import applicationtier.model.StudentModel;

import java.util.List;

public interface StudentService {

    List<StudentModel> fetchStudentsByUsername(String username);

    List<StudentModel> getAllStudents();

    StudentModel getStudentById(String id);

    StudentModel storeStudentData(StudentModel student);

    String editStudent(StudentModel student);

    String deleteStudent(String id);
}
