package applicationtier.controller;

import applicationtier.model.TeacherModel;
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

    @GetMapping("/Teachers-by-username")
    public ResponseEntity<List<TeacherModel>> fetchTeachersByUsername(@RequestParam String username) {
        try {
            return new ResponseEntity<>(teacherService.fetchTeachersByUsername(username), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: error handling could be improved
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Teachers")
    public ResponseEntity<List<TeacherModel>> getAllTeachers() {
        try {
            return new ResponseEntity<>(teacherService.getAllTeachers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Teacher")
    public ResponseEntity<TeacherModel> getTeacherById(@RequestParam String id) {
        try {
            return new ResponseEntity<>(teacherService.getTeacherById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/Store-teacher")
    public ResponseEntity<TeacherModel> storeTeacherData(@RequestBody TeacherModel teacher) {
        try {
            return new ResponseEntity<>(teacherService.storeTeacherData(teacher), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/Edit-teacher")
    public ResponseEntity<String> editTeacher(@RequestBody TeacherModel teacher) {
        try {
            return new ResponseEntity<>(teacherService.editTeacher(teacher), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/Delete-teacher")
    public ResponseEntity<String> deleteTeacher(@RequestBody String id) {
        try {
            return new ResponseEntity<>(teacherService.deleteTeacher(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
