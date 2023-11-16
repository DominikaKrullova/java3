package applicationtier.controller;

import applicationtier.model.StudentModel;
import applicationtier.service.api.StudentService;
import jakarta.websocket.server.PathParam;
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

    @GetMapping("/Students")
    public ResponseEntity<List<StudentModel>> fetchStudentsByUsername(@RequestParam String username) {
        try {
            return new ResponseEntity<>(studentService.fetchStudentsByUsername(username), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: error handling could be improved
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/Students")
    public ResponseEntity<StudentModel> storeStudentData(@RequestBody StudentModel student) {
        try {
            return new ResponseEntity<>(studentService.storeStudentData(student), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: error handling could be improved
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
