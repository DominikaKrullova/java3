package applicationtier.controller;

import applicationtier.model.UserModel;
import applicationtier.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserDataController
{
    private final UserService userService;

    @Autowired
    public UserDataController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/Users")
    public ResponseEntity<List<UserModel>> fetchUsersById(@RequestParam String Id)
    {
        try
        {
            return new ResponseEntity<>(userService.fetchUsersById(Id), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}