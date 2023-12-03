package applicationtier.service.impl;

import applicationtier.DAO.Student.StudentDao;
import applicationtier.model.StudentModel;
import applicationtier.service.api.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao)
    {
        this.studentDao = studentDao;
    }

    @Override
    public List<StudentModel> fetchStudentsByUsername(String username) {
        return studentDao.filterStudentsByUsername(username);
    }

    @Override
    public List<StudentModel> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public StudentModel getStudentById(String id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public StudentModel storeStudentData(StudentModel student) {
        return studentDao.addStudent(student);
    }

    @Override
    public String editStudent(StudentModel student) {
        return studentDao.editStudent(student);
    }

    @Override
    public String deleteStudent(String id) {
        return studentDao.deleteStudent(id);
    }


}
