package me.wasin.PostService.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> getAllPost() {
        List<Comment> posts = commentService.getAllPost();
        return new ResponseEntity<List<Comment>>(posts, HttpStatus.OK);
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public ResponseEntity<Comment> createPost(@Valid @RequestBody Comment comment) {
        Comment comment_object = commentService.createComment(comment);
        return new ResponseEntity<Comment>(comment_object, HttpStatus.OK);
    }

}
