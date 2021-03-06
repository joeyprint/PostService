package me.wasin.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUser () {
        List<User> users = userService.getAllUser();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{user_id:[\\d]}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser (@PathVariable (name = "user_id") int id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method= RequestMethod.POST)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User user_object = userService.createUser(user);
        return new ResponseEntity<User>(user_object, HttpStatus.OK);
    }

}
