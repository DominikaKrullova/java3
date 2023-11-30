package applicationtier.service.impl;

import applicationtier.model.ClassModel;
import applicationtier.service.api.ClassService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClassServiceImpl implements ClassService
{

    @Override
    public List<ClassModel> fetchClassByClassId(int classId) {
        return null;
    }

    @Override
    public ClassModel storeClassData(ClassModel class_) {
        return null;
    }
}
