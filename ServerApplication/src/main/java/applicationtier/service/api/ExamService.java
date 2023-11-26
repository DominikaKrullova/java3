package applicationtier.service.api;

import applicationtier.model.ExamModel;

import java.util.List;

public interface ExamService
{
    List<ExamModel> fetchExamsByNameOfExam(String NameOfExam);

    ExamModel storeExamData(ExamModel exam);
}
