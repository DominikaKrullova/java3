package applicationtier.service.api;

import applicationtier.model.StudentModel;

import java.util.List;

public interface StudentService {

    List<StudentModel> fetchStudentsByUsername(String username);

    StudentModel storeStudentData(StudentModel student);

}
