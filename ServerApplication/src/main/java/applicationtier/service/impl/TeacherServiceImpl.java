package applicationtier.service.impl;

import applicationtier.model.StudentModel;
import applicationtier.model.TeacherModel;
import applicationtier.service.api.StudentService;
import applicationtier.service.api.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Override
    public List<TeacherModel> fetchTeachersById(String id) {
        return null;
    }

    @Override
    public TeacherModel storeTeacherData(TeacherModel teacher) {
        return null;
    }
}
