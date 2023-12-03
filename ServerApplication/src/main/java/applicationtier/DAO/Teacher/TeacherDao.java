package applicationtier.DAO.Teacher;

import applicationtier.model.TeacherModel;

import java.util.List;

public interface TeacherDao
{
    TeacherModel addTeacher(TeacherModel teacherModel);
    String deleteTeacher(String id);
    String editTeacher(TeacherModel teacherModel);
    TeacherModel getTeacherById(String id);
    List<TeacherModel> getAllTeachers();
    List<TeacherModel> filterTeachersByUsername(String username);
}
