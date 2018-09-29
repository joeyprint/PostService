package me.wasin.PostService.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserAdapter userAdapter;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<User[]> getAllUser () {
        User[] users = userAdapter.getAllUser();
        return new ResponseEntity<User[]>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{user_id:[\\d]}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser (@PathVariable (name = "user_id") int id) {
        User user = userAdapter.getUserDetail(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method= RequestMethod.POST)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User user_object = userAdapter.createUser(user);
        return new ResponseEntity<User>(user_object, HttpStatus.OK);
    }

}
