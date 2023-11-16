package applicationtier.service.impl;

import applicationtier.model.StudentModel;
import applicationtier.service.api.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public List<StudentModel> fetchStudentsByUsername(String username) {
        return null;
    }

    @Override
    public StudentModel storeStudentData(StudentModel student) {
        return null;
    }
}
