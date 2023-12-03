package applicationtier.controller;

import applicationtier.model.StudentModel;
import applicationtier.service.api.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentDataController {

    private final StudentService studentService;

    @Autowired
    public StudentDataController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/Students-by-username")
    public ResponseEntity<List<StudentModel>> fetchStudentsByUsername(@RequestParam String username) {
        try {
            return new ResponseEntity<>(studentService.fetchStudentsByUsername(username), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: error handling could be improved
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Students")
    public ResponseEntity<List<StudentModel>> getAllStudents() {
        try {
            return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Student")
    public ResponseEntity<StudentModel> getStudentById(@RequestParam String id) {
        try {
            return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/Store-student")
    public ResponseEntity<StudentModel> storeStudentData(@RequestBody StudentModel student) {
        try {
            return new ResponseEntity<>(studentService.storeStudentData(student), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/Edit-student")
    public ResponseEntity<String> editStudent(@RequestBody StudentModel student) {
        try {
            return new ResponseEntity<>(studentService.editStudent(student), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/Delete-student")
    public ResponseEntity<String> deleteStudent(@RequestBody String id) {
        try {
            return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
