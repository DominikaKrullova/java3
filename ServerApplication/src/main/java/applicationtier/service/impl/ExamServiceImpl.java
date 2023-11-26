package applicationtier.service.impl;

import applicationtier.model.ExamModel;
import applicationtier.service.api.ExamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService
{
    @Override
    public List<ExamModel> fetchExamsByNameOfExam(String NameOfExam)
    {
        return null;
    }

    @Override
    public ExamModel storeExamData(ExamModel exam)
    {
        return null;
    }
}
