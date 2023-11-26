package applicationtier.controller;


import applicationtier.model.SupervisorModel;
import applicationtier.service.api.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupervisorDataController {
    private final SupervisorService supervisorService;

    @Autowired
    public SupervisorDataController(SupervisorService supervisorService) {
        this.supervisorService = supervisorService;
    }

    @GetMapping("/Supervisors")
    public ResponseEntity<List<SupervisorModel>> fetchSupervisorsById(@RequestParam String Id) {
        try {
            return new ResponseEntity<>(supervisorService.fetchSupervisorsById(Id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/Supervisors")
    public ResponseEntity<SupervisorModel> storeSupervisorData(@RequestBody SupervisorModel supervisor) {
        try {
            return new ResponseEntity<>(supervisorService.storeSupervisorData(supervisor), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}