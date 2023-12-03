package applicationtier.service.impl;

import applicationtier.DAO.Teacher.TeacherDao;
import applicationtier.model.TeacherModel;
import applicationtier.service.api.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherDao teacherDao;

    @Autowired
    public TeacherServiceImpl(TeacherDao teacherDao)
    {
        this.teacherDao = teacherDao;
    }
    
    @Override
    public List<TeacherModel> fetchTeachersByUsername(String username) {
        return teacherDao.filterTeachersByUsername(username);
    }

    @Override
    public List<TeacherModel> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }

    @Override
    public TeacherModel getTeacherById(String id) {
        return teacherDao.getTeacherById(id);
    }

    @Override
    public TeacherModel storeTeacherData(TeacherModel teacher) {
        return teacherDao.addTeacher(teacher);
    }

    @Override
    public String editTeacher(TeacherModel teacher) {
        return teacherDao.editTeacher(teacher);
    }

    @Override
    public String deleteTeacher(String id) {
        return teacherDao.deleteTeacher(id);
    }
}
