package applicationtier.controller;

import applicationtier.model.StudentModel;
import applicationtier.model.TeacherModel;
import applicationtier.service.api.StudentService;
import applicationtier.service.api.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherDataController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherDataController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/Teachers")
    public ResponseEntity<List<TeacherModel>> fetchTeachersById(@RequestParam String id) {
        try {
            return new ResponseEntity<>(teacherService.fetchTeachersById(id), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: error handling could be improved
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/Teachers")
    public ResponseEntity<TeacherModel> storeTeacherData(@RequestBody TeacherModel teacher) {
        try {
            return new ResponseEntity<>(teacherService.storeTeacherData(teacher), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: error handling could be improved
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
