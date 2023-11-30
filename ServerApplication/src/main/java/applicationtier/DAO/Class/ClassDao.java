package applicationtier.DAO.Class;

import applicationtier.model.ClassModel;

import java.util.List;

public interface ClassDao
{
  String addClass(String className, int classId);
  String deleteClass(String className, int classId);
  String editClass(String className, int classId);
  List<ClassModel> getAllClasses();
  List<ClassModel> filterClasses(String className);
  List<ClassModel> filter(String className, String...attr);
}
