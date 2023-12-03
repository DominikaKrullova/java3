package applicationtier.service.impl;

import applicationtier.DAO.Class.ClassDao;
import applicationtier.model.ClassModel;
import applicationtier.service.api.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClassServiceImpl implements ClassService
{
    private final ClassDao classDao;

    @Autowired
    public ClassServiceImpl(ClassDao classDao)
    {
        this.classDao = classDao;
    }

    @Override
    public List<ClassModel> fetchClassByClassId(int classId) {
        return null;
    }

    @Override
    public ClassModel storeClassData(ClassModel class_) {
        return null;
    }
}
