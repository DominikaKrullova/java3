package applicationtier.service.impl;

import applicationtier.DAO.Exam.ExamDao;
import applicationtier.model.ExamModel;
import applicationtier.service.api.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService
{
    private final ExamDao examDao;

    @Autowired
    public ExamServiceImpl(ExamDao examDao)
    {
        this.examDao = examDao;
    }
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
