package applicationtier.DAO.Exam;

public interface ExamDao
{
    String addExam(String NameOfExam, int grade, String dt, String class_);
    String deleteExam(String NameOfExam, int grade, String dt, String class_);
    String editExam(String NameOfExam, int grade, String dt, String class_);
    String getAllExams();
    String filterExams(String NameOfExam, int grade, String dt, String class_);
    String filter(String NameOfExam, int grade, String dt, String class_);

}
