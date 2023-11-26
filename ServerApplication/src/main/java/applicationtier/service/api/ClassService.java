package applicationtier.service.api;

import applicationtier.model.ClassModel;

import java.util.List;

public interface ClassService
{
    List<ClassModel> fetchClassByClassId (int classId);

    ClassModel storeClassData (ClassModel class_);
}
