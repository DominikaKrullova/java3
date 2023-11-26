package applicationtier.model;

import org.springframework.lang.NonNull;

public record ExamModel(@NonNull String NameOfExam, @NonNull int grade, @NonNull String dt, @NonNull Class class_)
{

}
