package applicationtier.service.api;

import applicationtier.model.StudentModel;
import applicationtier.model.TeacherModel;

import java.util.List;

public interface TeacherService {

    List<TeacherModel> fetchTeachersById(String id);

    TeacherModel storeTeacherData(TeacherModel teacher);

}
