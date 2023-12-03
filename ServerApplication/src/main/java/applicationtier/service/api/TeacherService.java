package applicationtier.service.api;

import applicationtier.model.TeacherModel;

import java.util.List;

public interface TeacherService {

    List<TeacherModel> fetchTeachersByUsername(String id);

    List<TeacherModel> getAllTeachers();

    TeacherModel getTeacherById(String id);

    TeacherModel storeTeacherData(TeacherModel teacher);

    String editTeacher(TeacherModel teacher);

    String deleteTeacher(String id);

}
