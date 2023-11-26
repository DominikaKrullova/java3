package applicationtier.controller;

import applicationtier.model.ExamModel;
import applicationtier.service.api.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamDataController
{
    private final ExamService examService;

    @Autowired
    public ExamDataController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/Exams")
    public ResponseEntity<List<ExamModel>> fetchExamsByNameOfExam(@RequestParam String NameOfExam) {
        try {
            return new ResponseEntity<>(examService.fetchExamsByNameOfExam(NameOfExam), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/Exams")
    public ResponseEntity<ExamModel> storeExamData(@RequestBody ExamModel exam) {
        try {
            return new ResponseEntity<>(examService.storeExamData(exam), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}