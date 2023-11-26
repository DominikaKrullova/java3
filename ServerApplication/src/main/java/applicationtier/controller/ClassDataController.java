package applicationtier.controller;

import applicationtier.model.ClassModel;
import applicationtier.model.StudentModel;
import applicationtier.service.api.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassDataController
{
    private final ClassService classService;

    @Autowired
    public ClassDataController(ClassService classService)
    {
        this.classService = classService;
    }

    @GetMapping("/Class")
    public ResponseEntity<List<ClassModel>> fetchClassByClassId (@RequestParam int classId)
    {
        try {
            return new ResponseEntity<>(classService.fetchClassByClassId(classId), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: error handling could be improved
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/Class")
    public ResponseEntity<ClassModel> storeClassData(@RequestBody ClassModel class_) {
        try {
            return new ResponseEntity<>(classService.storeClassData(class_), HttpStatus.OK);
        }
        catch (Exception e)

        {
            // TODO: error handling could be improved
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
